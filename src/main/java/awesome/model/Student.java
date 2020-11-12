package awesome.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Student {

    private int id;
    private String name;
    public static List<Student> studentList;

    static {
        studentRepository();
    }


    private static void studentRepository(){
        studentList = new ArrayList<>( asList(new Student("Rai", 0), new Student("Erika", 1), new Student("Erika Rai", 2)));

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

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
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

    public static int setId(){
       return studentList.size();
    }
    public static int getId(){
        return studentList.size() - 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\n<p><strong>Student  "+ (id + 1)+
                "</strong>  => " + name +"</p>";
    }
}
