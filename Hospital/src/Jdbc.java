import java.util.Properties;

public class Jdbc {
    private final Properties parameters = new Properties();

    public Jdbc() {
        parameters.put("user", "postgres");
        parameters.put("password", "1111");
    }

    public String getURL() {
        return "jdbc:postgresql://localhost:5433/hospital_db";
    }

    public Properties getParameters() {
        Properties copy = new Properties();
        copy.putAll(parameters);
        return copy;
    }
}
