public class Student extends Human{

    private String speciality, group;
    private int rating;

    public Student(String lastName, String firstName, int age
                        , String speciality, String group, int rating) {
        super(lastName, firstName, age);
        this.speciality = speciality;
        this.group = group;
        this.rating = rating;
    }

    public Student() {
    }

    public Student(Student original) {
        super(original);
        this.speciality = original.speciality;
        this.group = original.group;
        this.rating = original.rating;
    }

    @Override
    public void info() {
        super.info();
        System.out.print("специальность: " + speciality +  " " + "группа: " + group
                                + " " + "рейтинг: " + rating);
    }
}
