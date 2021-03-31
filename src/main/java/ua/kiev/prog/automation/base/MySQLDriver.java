package ua.kiev.prog.automation.base;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class MySQLDriver {

    private Connection _mysqlCon;

    public MySQLDriver() {
        String url = String.format(
                "jdbc:mysql://%s:%s/%s",
                Config.MYSQL_HOST,
                Config.MYSQL_PORT,
                Config.MYSQL_DATABASE
        );
        try {
            _mysqlCon = DriverManager.getConnection(url, Config.MYSQL_USERNAME.value, Config.MYSQL_PASSWORD.value);
        } catch (SQLException e) {
            throw new RuntimeException("Can not connect to MySQL server" + url, e);
        }
    }

    private Statement getStatement() throws SQLException {
        return _mysqlCon.createStatement();

    }

    public boolean execute (String sql) {
        try {
            return getStatement().execute(sql);
        }catch (SQLException e){
            throw new RuntimeException("Can not execute SQL query", e);
        }
    }

    public ResultSet executeQuery (String sql) {
        try {
            return getStatement().executeQuery(sql);
        }catch (SQLException e){
            throw new RuntimeException("Can not execute SQL query ", e);
        }
    }

    public void close() {
        try{
            this._mysqlCon.close();
        }catch (SQLException e) {/* ignore*/}
    }

}
