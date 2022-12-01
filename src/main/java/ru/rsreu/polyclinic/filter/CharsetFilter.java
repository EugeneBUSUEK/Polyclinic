package ru.rsreu.polyclinic.filter;

import javax.servlet.*;

import java.io.IOException;

public class CharsetFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        next.doFilter(request, response);
    }
}
