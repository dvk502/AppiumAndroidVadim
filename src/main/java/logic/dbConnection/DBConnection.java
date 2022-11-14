package logic.dbConnection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final Logger log = Logger.getLogger(DBConnection.class);

    /**
     * Создаем подключение к базе данных.
     * Метод getConnection имеет входящие значения из класса DBConstant с именем пользователя, паролем, и именем БД.
     * Тело метода создает драйвер org.postgreSQL.Driver, через который потом будут отправляться запросы на указанную БД.
     * Функция getConnection из класса DriverManager проверяет успешное соединение с указанной БД.
     * Метод closeConnection закрывает доступ к БД после выполнения запроса.
     */
    static Connection con = null;
    public static Connection getConnection(){
        if(con!=null) return con;
        return getConnection(DBConstant.DB_URL, DBConstant.USER_DB, DBConstant.PASS_DB);
    }
    private static Connection getConnection(String db_url, String user, String password){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            log.error("PostgreSQL JDBC Driver is not found. Include it in your library path: " + e );
        }
        try {
            con = DriverManager.getConnection(db_url, user, password);
            log.info("Connection is successful!");
        } catch (SQLException e) {
            log.error("Connection Failed: " + e);
        }
        return con;
    }

    public static void closeConnection()  {
        if(con!=null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
