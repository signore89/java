import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient {
    public int patient_id;
    public String patient_full_name;
    public String diagnosis;
    public int doctors_id = 3;

    public Patient(String patient_full_name) {
        this.patient_full_name = patient_full_name;
    }

    public Patient(ResultSet rs) throws SQLException {
        this.patient_id = rs.getInt("patient_id");
        this.patient_full_name = rs.getString("patient_full_name");
        this.diagnosis = rs.getString("diagnosis");
        this.doctors_id = rs.getInt("doctor_id");
    }
}
