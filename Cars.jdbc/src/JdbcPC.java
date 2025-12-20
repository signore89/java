import java.util.Properties;

public class JdbcPC {
    private final Properties parameters = new Properties();

    public JdbcPC() {
        parameters.put("user","***********");
        parameters.put("password","****");
    }

    public String getURL(){
        return "jdbc:postgresql://localhost:*****/cars_db";
    }
    public Properties getParameters(){
        Properties copy = new Properties();
        copy.putAll(parameters);
        return copy;
    }


}
