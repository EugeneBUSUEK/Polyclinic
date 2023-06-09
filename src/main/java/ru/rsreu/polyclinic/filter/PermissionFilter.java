package ru.rsreu.polyclinic.filter;

import ru.rsreu.polyclinic.data.User;
import ru.rsreu.polyclinic.enums.Route;
import ru.rsreu.polyclinic.helper.PermissionHelper;
import ru.rsreu.polyclinic.helper.UserHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(
            ServletRequest servletRequest,
            ServletResponse servletResponse,
            FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getPathInfo();

        if (path.equals(Route.NOT_FOUND.getRelative())) {
            filterChain.doFilter(request, response);
            return;
        }

        Optional<User> user = UserHelper.getFromRequest(request);

        if (!user.isPresent()) {
            if (path.equals(Route.LOGIN.getRelative()) || path.equals(Route.PROFILE.getRelative())) {
                filterChain.doFilter(request, response);
                return;
            }

            response.sendRedirect(Route.LOGIN.getAbsolute());
            return;
        }

        if (PermissionHelper.hasPermission(path, user.get())) {
            filterChain.doFilter(request, response);
            return;
        }

        response.sendRedirect(Route.NOT_FOUND.getAbsolute());
    }
}
