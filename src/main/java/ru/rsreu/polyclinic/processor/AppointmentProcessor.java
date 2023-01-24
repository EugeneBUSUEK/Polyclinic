package ru.rsreu.polyclinic.processor;

import ru.rsreu.polyclinic.data.RequestsTableRow;
import ru.rsreu.polyclinic.database.dao.AppointmentsDAO;
import ru.rsreu.polyclinic.database.dao.DAOFactory;
import ru.rsreu.polyclinic.database.dao.DoctorChartsDAO;
import ru.rsreu.polyclinic.database.dao.VacationRequestsDAO;
import ru.rsreu.polyclinic.helper.DateTimeHelper;

import java.util.Date;
import java.util.List;

public class AppointmentProcessor {

    private AppointmentsDAO appointmentsDAO;
    private VacationRequestsDAO vacationRequestsDAO;
    private DoctorChartsDAO doctorChartsDAO;

    public AppointmentProcessor() {
        this.appointmentsDAO = DAOFactory.getAppointmentsDAO();
        this.vacationRequestsDAO = DAOFactory.getVacationRequestsDAO();
        this.doctorChartsDAO = DAOFactory.getDoctorChartsDAO();
    }

    public boolean isAppointmentValid(String timeFrom, String timeTo, Long doctorId) {
        Date dateTimeFrom = DateTimeHelper.getTimeFromString(timeFrom);
        Date dateTimeTo = DateTimeHelper.getTimeFromString(timeTo);
        List<String> chartList = doctorChartsDAO.returnDoctorChartForDay(doctorId, 0);
        Date chartTimeFrom = DateTimeHelper.getTimeFromString(chartList.get(0));
        Date chartTimeTo = DateTimeHelper.getTimeFromString(chartList.get(1));
        if (dateTimeFrom.before(chartTimeFrom) || dateTimeTo.after(chartTimeTo)) {
            return false;
        }
        List<RequestsTableRow> chartsList = vacationRequestsDAO.returnRequestsOfDoctorById(doctorId);
        dateTimeFrom = DateTimeHelper.getDateFromString(timeFrom);
        dateTimeTo = DateTimeHelper.getDateFromString(timeTo);
        for (RequestsTableRow row : chartsList) {
            Date vacationDateFrom = DateTimeHelper.getDateFromString(row.getDate_from());
            Date vacationDateTo = DateTimeHelper.getDateFromString(row.getDate_to());
            if (dateTimeFrom.after(vacationDateFrom) && dateTimeTo.before(vacationDateTo)) {
                return false;
            }
        }
        return true;
    }
}
