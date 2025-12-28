import javax.print.Doc;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private Connection connection;
//    private Statement stmt;

    public DatabaseManager(Jdbc jdbcPC) {
        try{
            connection = DriverManager.getConnection(jdbcPC.getURL(), jdbcPC.getParameters());
            System.out.println("Соединение с базой данных установлено.");
        }catch (SQLException e){
            System.out.println("Ошибка подключения к базе данных!");
            e.printStackTrace();
        }
    }

    public int addPatient(Patient patient) throws SQLException {
        String sql = "INSERT INTO patients (patient_full_name, diagnosis, doctor_id) VALUES (?, ?, ?)";
        System.out.println("\n=== Добавление нового пациента ===");
        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, patient.patient_full_name);
            pstmt.setString(2, patient.diagnosis);
            pstmt.setInt(3, patient.doctors_id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(4);
                    }
                }
            }
        }
        System.out.println("Пациент успешно добавлен!");
        return -1;
    }

    public List<Patient> getAllPatients() throws SQLException {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY patient_id";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                patients.add(new Patient(rs));
            }
        }
        return patients;
    }

    public List<Doctor> getAllDoctors() throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors ORDER BY id";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                doctors.add(new Doctor(rs));
            }
        }
        return doctors;
    }

    public Patient getPatientById(int id) throws SQLException {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Patient(rs);
                }
            }
        }
        return null;
    }

    public int addAppointment(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointments (patient_id, appointment_date, doctor_name, specialization) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, appointment.patientId);
            pstmt.setTimestamp(2, Timestamp.valueOf(appointment.dateTime));
            pstmt.setString(3, appointment.doctorName);
            pstmt.setString(4, appointment.specialization);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }
        }
        return -1;
    }

//    public List<Appointment> getAllAppointments() throws SQLException {
//        List<Appointment> appointments = new ArrayList<>();
//        String sql = "SELECT * FROM appointments ORDER BY appointment_date";
//
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                appointments.add(new Appointment(rs));
//            }
//        }
//        return appointments;
//    }
//
//    public List<Appointment> getAppointmentsByPatientId(int patientId) throws SQLException {
//        List<Appointment> appointments = new ArrayList<>();
//        String sql = "SELECT * FROM appointments WHERE patient_id = ? ORDER BY appointment_date";
//
//        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
//            pstmt.setInt(1, patientId);
//
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    appointments.add(new Appointment(rs));
//                }
//            }
//        }
//        return appointments;
//    }


    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Соединение с базой данных закрыто.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
