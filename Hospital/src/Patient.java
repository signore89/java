public class Patient {
    public int patient_id;
    public String patient_full_name;
    public String diagnosis;
    public int doctors_id;

    public Patient(int patient_id, String patient_full_name, String diagnosis, int doctors_id) {
        this.patient_id = patient_id;
        this.patient_full_name = patient_full_name;
        this.diagnosis = diagnosis;
        this.doctors_id = doctors_id;
    }
}
