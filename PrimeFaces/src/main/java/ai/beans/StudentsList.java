package ai.beans;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Named(value = "studentsList")
@ViewScoped
public class StudentsList implements Serializable {
    private List<Student> allStudents;
    private static List<String> firstNames = Arrays.asList("Celine", "Anya", "Ronald", "Marni", "Drema", "Shanita", "Hershel", "Jose", "Armandina", "Ulysses", "Doug", "Louvenia", "Annalisa", "Peggy", "Corey", "Levi", "Ute", "Chi", "Annalee", "Marianne", "Cristen", "Dwain", "Delinda", "Hortense", "Phyllis", "Maribeth", "Ashely", "Naoma", "Aubrey", "Geoffrey");
    private static List<String> lastNames = Arrays.asList("Solis", "Bonilla", "Hodges", "Flores", "Gill", "Kane", "Goodwin", "Chambers", "Shea", "Adams", "Evans", "Wolf", "Dyer", "Callahan", "Trujillo", "Mayer", "Ward", "Foley", "Silva", "Cooke", "Collins", "Macias", "Finley", "Frye", "Pitts", "Roy", "Hobbs", "Riddle", "Grant", "French");
    private static Random rand = new Random();

    public StudentsList() {
        generateStudents();
    }

    private void generateStudents() {
        allStudents = new ArrayList<>();
        int studentsNumber = rand.nextInt(30) + 1;
        for (int i = 0; i < studentsNumber; i++) {
            allStudents.add(generateNewStudent());
        }
    }

    private Student generateNewStudent() {
        return new Student(firstNames.get(rand.nextInt(firstNames.size())),
                lastNames.get(rand.nextInt(lastNames.size())),
                rand.nextDouble() * 3 + 2);
    }

    public List<Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(List<Student> allStudents) {
        this.allStudents = allStudents;
    }

}
