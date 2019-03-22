package passwordmanager.database;

import java.io.File;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public static Database instance;
    public static String url;

    public Database(String fileName, File location) {
        url = "jdbc:sqlite:" + location + "/" + fileName;
        instance = this;
        createDatabase(fileName);

    }

    public static Database getInstance() {
        return instance;
    }

    private Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createDatabase(String url) {
        try (Connection conn = this.connect()) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Using Database driver " + meta.getDriverName());
                System.out.println("A database connection has been established.");
                ScriptRunner s = new ScriptRunner(conn);
                s.runScript(new InputStreamReader(this.getClass().getResourceAsStream("schema.sql")));

            }
        } catch (SQLException e) {
            System.out.println("A database connection has not been established.");
        }
    }

    public void executeSQL(final String sql, boolean aSync) {
        try (Connection conn = DriverManager.getConnection(url); Statement statement = conn.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                DriverManager.getConnection(url).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ResultSet selectData(String sql) {
        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
