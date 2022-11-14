package logic.dbConnection;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.ArrayUtil;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class SqlRequests {

    /**
     * В шапке указаны константы которые используются в запросах к БД.
     * Метод deleteEvents удаляет определенные ивенты у водителей.
     * Метод deleteBC удаляет определенные Border Cross ивенты у водителей.
     * Метод deleteIR удаляет определенные Inspection Report ивенты у водителей.
     * Метод takeLastEventSequence получает последнее значение Event Sequence, и добавляет к нему 1, это значение указывается при создании новых ивентов водителям.
     * Метод addEvent добавляет определенные ивенты водителям.
     *
     * Принцип работы запросов к БД:
     * Происходит подключение к БД через класс DBConnection.
     * Statement st принимает значение драйвера при подключении к БД, и уже через statement происходит отправка запроса в БД.
     * После отправки запроса срабатывает finally в блоке try catch, который закрывает подключение к БД с помощью функции close.
     */
    private static final Logger log = Logger.getLogger(SqlRequests.class);
    static private final String DELETE_BC = "DELETE from eld.eld_border_crossing_event WHERE org_id=5891 and driver_id_1=";
    static private final String TAKE_EVENT_SEQUENCE = "SELECT event_sequence FROM eld.eld_event WHERE org_id=5891 and driver_id_1=";
    static private final String DELETE_EVENTS_FROM_DRIVER = "DELETE FROM eld.eld_event WHERE org_id=5891 and event_sequence NOT IN (1) AND driver_id_1=";
    static private final String DELETE_INSPECTIONREPORTS_FROM_DRIVER = "DELETE FROM eld.inspection_report WHERE org_id=5891 and driver_id_1=";
    static private final String INSERT_EVENT = "INSERT INTO eld.eld_event (driver_id_1, org_id, record_status, record_origin, " +
            "event_type, event_code, event_timestamp, device_uid, location_description, total_vehicle_miles, shipping_number, trailer_number, event_sequence, truck_id, latitude, longitude, prov_state, country, city, truck_number, truck_vin, platform, app_version, accumulated_vehicle_miles, elapsed_engine_hours, total_engine_hours, eld_sequence) VALUES (";
    public static Long nextSequence;
    private static int eld_sequence = 380;

    @Step("Delete events for driver(s).")
    public static boolean deleteEvents(long driver_id) {
        try (Statement st = DBConnection.getConnection().createStatement()) {
            st.executeUpdate(DELETE_EVENTS_FROM_DRIVER + driver_id);
            log.warn("Delete all events for driver_id = " + driver_id);
        } catch (SQLException e) {
            log.error("Delete events is not successful: " + e);
            return false;
        }
        return true;
    }

    public static int getEld_sequence() {
        return eld_sequence--;
    }

    @Step("Delete events for driver(s).")
    public static boolean deleteBC(long driver_id) {
        try (Statement st = DBConnection.getConnection().createStatement()) {
            st.executeUpdate(DELETE_BC + driver_id);
            log.warn("Delete all BC for driver_id = " + driver_id);
        } catch (SQLException e) {
            log.error("Delete BC is not successful: " + e);
            return false;
        }
        return true;
    }

    @Step("Delete Inspection Reports for driver(s).")
    public static boolean deleteIR(long driver_id) {
        try (Statement st = DBConnection.getConnection().createStatement()) {
            st.executeUpdate(DELETE_INSPECTIONREPORTS_FROM_DRIVER + driver_id);
            log.warn("Delete all Inspection Reports for driver_id = " + driver_id);
        } catch (SQLException e) {
            log.error("Delete Inspection Reports is not successful: " + e);
            return false;
        }
        return true;
    }

    @Step("Take last Event Sequence.")
    public static List<Long> takeLastEventSequence(int driver_id) {
        List<Long> result = new ArrayList<>();
        try (Statement st = DBConnection.getConnection().createStatement()) {
            ResultSet resultSet = st.executeQuery(TAKE_EVENT_SEQUENCE + driver_id);
            while (resultSet.next()) {
                result.add(resultSet.getLong("event_sequence"));
            }
            log.warn("Take Last Event Sequence for driver_id = " + driver_id);
            log.info("Last event sequence: " + Collections.max(result));
            nextSequence = Collections.max(result);
            log.info("Next event sequence: " + (nextSequence + 1));
        } catch (SQLException e) {
            log.error("Take all Event Sequences is not successful: " + e);
        }
        return result;
    }

    @Step("Insert event for driver(s).")
    public static boolean addEvent(String eventType, long driver_id, long org_id, int record_status, int record_origin, int event_type, int event_code, String event_timestamp, String device_uid, String location_description, String total_vehicle_miles, String shipping_number, String trailer_number, Long event_sequence, int truck_id, String city) {
        try (Statement st = DBConnection.getConnection().createStatement()) {
            st.executeUpdate(INSERT_EVENT + driver_id + ", " + org_id + ", " + record_status + ", " + record_origin + ", " + event_type + ", " + event_code + ", " + "'" + event_timestamp + "'" + ", " + "'" + device_uid + "'" + ", " + "'" + location_description + "'" + ", " + "'" + total_vehicle_miles + "'" + ", " + "'" + "[{\"from\":\"\",\"number\":\"" + shipping_number + "\",\"to\":\"\"}]" + "'" + ", " + "'" + "[{\"license\":\"\",\"number\":\"" + trailer_number + "\",\"odometer\":\"" + total_vehicle_miles + "\"}]" + "'" + ", " + "'" + event_sequence + "'" + ", " + "'" + truck_id + "'" + ", " + "'" + "M" + "'" + ", " + "'" + "M" + "'" + ", " + "'" + "AL" + "'" + ", " + "'" + "US" + "'" + ", " + "'" + city + "'" + ", " + "'" + "TestTruck1638441050133" + "'" + ", 'BZM1CPPP1PWVD8440', 'Android', '3.0.48', 0, 0, 0.0, " + getEld_sequence() + ")");
            log.warn("Insert event " + eventType + " with RS = " + record_status + ", Event_Sequence = " + event_sequence + ", Truck ID = " + truck_id + ", ELD Sequence =  " + eld_sequence + ", and RO = " + record_origin + " for driver_id = " + driver_id + " in Org_Id = " + org_id + ".");
        } catch (SQLException e) {
            log.error("Event INSERT is not successful: " + e);
            return false;
        }
        return true;
    }
}
