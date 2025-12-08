public class Graduate extends Student{
    private String topic;

    public Graduate(String lastName, String firstName, int age, String speciality
                        , String group, int rating, String topic) {
        super(lastName, firstName, age, speciality, group, rating);
        this.topic = topic;
    }

    public Graduate(Graduate original) {
        super(original);
        this.topic = original.topic;
    }

    @Override
    public void info() {
        super.info();
        System.out.print(" " + "Диплом: " + topic);
    }
}
