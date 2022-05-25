package simple.com.config;

public class DBConfigDTO {

    protected String dbUrl;
    protected String dbName;
    protected String dbHost;
    protected String dbPort;
    protected String dbUser;
    protected String dbPass;
    protected String dbDriver;

    public DBConfigDTO(String dbUrl, String dbName, String dbHost,
                       String dbPort, String dbUser, String dbPass,
                       String dbDriver) {
        this.dbUrl = dbUrl;
        this.dbName = dbName;
        this.dbHost = dbHost;
        this.dbPort = dbPort;
        this.dbUser = dbUser;
        this.dbPass = dbPass;
        this.dbDriver = dbDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbHost() {
        return dbHost;
    }

    public String getDbPort() {
        return dbPort;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPass() {
        return dbPass;
    }

    public String getDbDriver() {
        return dbDriver;
    }
}
