import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Appointment {
    public int appointmentId;
    public int patientId;
    public LocalDateTime dateTime;
    public String doctorName;
    public String specialization;

    public Appointment(int patientId, LocalDateTime dateTime, String doctorName, String specialization) {
        this.patientId = patientId;
        this.dateTime = dateTime;
        this.doctorName = doctorName;
        this.specialization = specialization;
    }

    public Appointment(ResultSet rs) throws SQLException {
        this.appointmentId = rs.getInt("appointment_id");
        this.patientId = rs.getInt("patient_id");
        Timestamp timestamp = rs.getTimestamp("appointment_date");
        this.dateTime = timestamp.toLocalDateTime();
        this.doctorName = rs.getString("doctor_name");
        this.specialization = rs.getString("specialization");
    }
}
