package simple.com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfigReader {
    private final String fileName;

    public PropertiesConfigReader(String fileName) {
        this.fileName = fileName;
    }

     public DBConfigDTO getDbconfig() {
        DBConfigDTO dbConfigDTO = null;
        try {
            FileInputStream inputStream = new FileInputStream(fileName);
            Properties properties = new Properties();
            properties.load(inputStream);
            String dbUrl = properties.getProperty("dbURL");
            String dbName = properties.getProperty("dbName");
            String dbHost = properties.getProperty("dbHost");
            String dbPort = properties.getProperty("dbPort");
            String dbUser = properties.getProperty("dbUser");
            String dbPass = properties.getProperty("dbPass");
            String driver = properties.getProperty("driver");
            dbConfigDTO = new DBConfigDTO(dbUrl, dbName, dbHost, dbPort, dbUser, dbPass, driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dbConfigDTO;
    }
}
