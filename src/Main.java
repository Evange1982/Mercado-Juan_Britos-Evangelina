import com.backend.dao.impl.OdontologoDaoH2;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            Class.forName("org.h2.Driver");
            conexion = DriverManager.getConnection("jdbc:h2:~/odontologos;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }

    }
}