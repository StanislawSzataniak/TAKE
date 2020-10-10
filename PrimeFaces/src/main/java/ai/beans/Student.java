package ai.beans;

public class Student {
    private String firstName;
    private String lastName;
    private double avgGrade;

    public Student(String firstName, String lastName, double avgGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.avgGrade = avgGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}
