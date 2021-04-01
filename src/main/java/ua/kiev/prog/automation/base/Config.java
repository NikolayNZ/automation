package ua.kiev.prog.automation.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Config {

    final static  public  Param ENV          = new Param("env", "dev", true);
    final static  public  Param NO_GUI       = new Param("noGUI", "false", true);
    final static  public  Param BROWSER_NAME = new Param("browserName", "chrome", true);


    final static public Param BASE_URL       = new Param("base_url");
    final static public Param SITE_USERNAME  = new Param("site.username");
    final static public Param SITE_PASSWORD  = new Param("site.password");

    final static public Param MYSQL_HOST     = new Param("mysql.host");
    final static public Param MYSQL_PORT     = new Param("mysql.port");
    final static public Param MYSQL_DATABASE = new Param("mysql.database");
    final static public Param MYSQL_USERNAME = new Param("mysql.username");
    final static public Param MYSQL_PASSWORD = new Param("mysql.password");

    final static public class Param {
        final public String value;

        public Param(String name, String defValue, boolean isSys) {
            String tmpValue = null;
            if (isSys)
                tmpValue = System.getProperty(name);
            if (tmpValue == null && getEnvProperties().containsKey(name)) {
                tmpValue = getEnvProperties().getProperty(name);
            }
            if (tmpValue == null && defValue != null)
                tmpValue = defValue;
            if (tmpValue == null)
                throw new RuntimeException("Parameter name is not found for env");
            value = tmpValue;
        }


        public Param (String name, String defValue) {
            this (name, defValue, false);
        }
        public Param (String name, boolean isSys) {
            this (name,null, isSys);
        }
        public Param (String name) {
            this (name,null, false);
        }


        @Override
        public String toString () {
            return this.value;
        }

    }

    static private Properties envProperties;

    static private Properties getEnvProperties() {
        if (envProperties == null) {
            envProperties = new Properties();
            InputStream iStream = null;
            try {
                // Loading properties file from the classpath
                String env = System.getProperty("env", "dev"); // -Denv=stg
                iStream = Config.class.getClassLoader()
                        .getResourceAsStream("environments/" + env + ".properties");
                if (iStream == null) {
                    throw new IOException("File not found");
                }
                envProperties.load(iStream);
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
        return envProperties;
    }
}