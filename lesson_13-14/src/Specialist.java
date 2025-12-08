public class Specialist extends Graduate{

    private int diplomaAssessment;

    public Specialist(String lastName, String firstName, int age, String speciality,
                      String group, int rating, String topic, int diplomaAssessment) {
        super(lastName, firstName, age, speciality, group, rating, topic);
        this.diplomaAssessment = diplomaAssessment;
    }
    public Specialist(Graduate original,int diplomaAssessment){
        super(original);
        this.diplomaAssessment = diplomaAssessment;
    }

    @Override
    public void info() {
        super.info();
        System.out.print(" " + "Оценка по диплому: " + diplomaAssessment);
    }
}
