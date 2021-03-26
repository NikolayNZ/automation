package ua.kiev.prog.automation.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Config {

    final static public Param BASE_URL = new Param("base_url");
    final static public Param SITE_USERNAME = new Param("site.username");
    final static public Param SITE_PASSWORD = new Param("site.password");

    final static public Param MYSQL_HOST = new Param("mysql.host");
    final static public Param MYSQL_PORT = new Param("mysql.port");
    final static public Param MYSQL_DATABASE = new Param("mysql.database");
    final static public Param MYSQL_USERNAME = new Param("mysql.user");
    final static public Param MYSQL_PASSWORD = new Param("mysql.password");

    final static public class Param {
        final public String value;

        public Param(String name) {
            if (getProperties().containsKey(name))
                value = getProperties().getProperty(name);
            else
                throw new RuntimeException("Parameter name is not found for env " );
        }

        @Override
        public String toString () {
            return this.value;
        }

    }

    static private Properties properties;

    static private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            InputStream iStream = null;
            try {
                // Loading properties file from the classpath
                String env = System.getProperty("env", "dev"); // -Denv=stg
                iStream = Config.class.getClassLoader()
                        .getResourceAsStream("environments/" + env + ".properties");
                if (iStream == null) {
                    throw new IOException("File not found");
                }
                properties.load(iStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (iStream != null) {
                        iStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}