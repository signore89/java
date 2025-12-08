public class Human {
    private String lastName,firstName;
    private int age;

    public Human(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public Human() {
    }

    public Human(Human original) {
        this.lastName = original.lastName;
        this.firstName = original.firstName;
        this.age = original.age;
    }

    public void info(){
        System.out.print("\n" + lastName + " " + firstName + " " + age + " ");
    }
}
