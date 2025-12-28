import java.sql.ResultSet;
import java.sql.SQLException;

public class Doctor {
    public int doctor_id;
    public String doctor_full_name;
    public String specialization;
    public boolean availability_status;

    public Doctor(int doctor_id, String doctor_full_name, String specialization, boolean availability_status) {
        this.doctor_id = doctor_id;
        this.doctor_full_name = doctor_full_name;
        this.specialization = specialization;
        this.availability_status = availability_status;
    }

    public Doctor(ResultSet rs) throws SQLException {
        this.doctor_id = rs.getInt("doctor_id");
        this.doctor_full_name = rs.getString("doctor_full_name");
        this.specialization = rs.getString("specialization");
        this.availability_status = rs.getBoolean("availability_status");
    }
}
