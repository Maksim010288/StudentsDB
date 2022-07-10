package simple.com.dal;

import simple.com.config.DBConfigDTO;
import simple.com.config.PropertiesConfigReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnectionFactory{
    DBConfigDTO config;
    PropertiesConfigReader propertiesConfigReader = new PropertiesConfigReader(
            "src/main/resources/application.properties");

    public SQLConnectionFactory(DBConfigDTO config) {
        this.config = config;
    }

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        DBConfigDTO configDTO = propertiesConfigReader.getDbconfig();
        String connectionString = String.format(configDTO.getDbUrl() + "://%s:%s/%s",
                configDTO.getDbHost(),
                configDTO.getDbPort(),
                configDTO.getDbName());
        Class.forName(configDTO.getDbDriver());
        return DriverManager.getConnection(connectionString, configDTO.getDbUser(), configDTO.getDbPass());
    }
}