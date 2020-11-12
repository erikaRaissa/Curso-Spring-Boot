package awesome.endpoint;

import awesome.error.CustomErrorType;
import awesome.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentEndPoint {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(Student.studentList.toString(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") int id){
        if ( id < Student.studentList.size()){
            if ( Student.getStudentById(id)!= null){
                return new ResponseEntity<>(Student.getStudentById(id).toString(), HttpStatus.OK);
            }
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CustomErrorType("Id além do tamanho da lista"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @RequestMapping(method = RequestMethod.GET, path = "/add/{name}")
    public ResponseEntity<?> addStudent(@PathVariable("name") String name){
        if (!name.isEmpty()){
            Student.addStudent(new Student(name, Student.setId()));
            return new ResponseEntity<>(Student.getStudentById(Student.getId()).toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomErrorType("Não foi possivel add"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Student student){
        Student.addStudent(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Student student){
        Student.deleteStudent(student);
        return new ResponseEntity<>("DELETADO", HttpStatus.OK);
    }
}
