import java.sql.SQLException;
import java.util.List;

public interface HRManagerDAO {
    void addHRManager(HRManager hrManager) throws SQLException;
    HRManager getHRManagerById(int id) throws SQLException;
    List<HRManager> getAllHRManagers() throws SQLException;
    void updateHRManager(HRManager hrManager) throws SQLException;
    void deleteHRManager(int id) throws SQLException;
}
