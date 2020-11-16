package awesome.endpoint;

import awesome.error.CustomErrorType;
import awesome.model.Student;
import awesome.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentEndpoint(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id){
        if ( id < Student.studentList.size()){
            Optional<Student> student = studentRepository.findById(id);
            if ( student != null){
                return new ResponseEntity<>(student, HttpStatus.OK);
            }
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CustomErrorType("Id além do tamanho da lista"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

   @PostMapping
    public ResponseEntity<?> save(@RequestBody Student student){
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id")
    public ResponseEntity<?> delete(@PathVariable Long id){
        studentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> put(@RequestBody Student student){
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

}
