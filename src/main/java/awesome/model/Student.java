package awesome.model;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Entity
public class Student  extends AbstractEntity{

    private String name;
    public static List<Student> studentList;

    static {
        studentRepository();
    }


    private static void studentRepository(){
        studentList = new ArrayList<>(asList(new Student("Rai"), new Student("Erika"), new Student("Erika Rai")));

    }
    public static Student getStudentById(int id){
        return studentList.get(id);
    }


    public static void addStudent(Student student){
        studentList.add(student);
    }
    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public static void deleteStudent(Student student) {
        studentList.remove(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n<p><strong>Student </strong>  => " + name +"</p>";
    }
}
