import java.sql.SQLException;
import java.util.List;

public interface ScheduleDAO {
    void addSchedule(Schedule schedule) throws SQLException;
    Schedule getScheduleById(int id) throws SQLException;
    List<Schedule> getAllSchedules() throws SQLException;
    void updateSchedule(Schedule schedule) throws SQLException;
    void deleteSchedule(int id) throws SQLException;
}
