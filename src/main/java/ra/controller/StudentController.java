package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Student;
import ra.model.service.IStudentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public List<Student> getAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/studentId")
    public Student getStudentById(@PathVariable("studentId") int studentId) {
        return studentService.findById(studentId);
    }

    @PostMapping("")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveOrUpdate(student);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        Student studentUpdate = studentService.findById(studentId);
        studentUpdate.setStudentName(student.getStudentName());
        studentUpdate.setBirthDate(student.getBirthDate());
        studentUpdate.setAge(student.getAge());
        studentUpdate.setStatus(student.isStatus());
        return studentService.saveOrUpdate(studentUpdate);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId) {
        studentService.delete(studentId);
    }

    @GetMapping("/search")
    public List<Student> findByNameOrId(@RequestParam("studentName") String studentName,@RequestParam("studentId") int studentId) {
        return studentService.findByName(studentName,studentId);
    }
   @GetMapping("/searchByAge")
    public List<Student> getStudentByAgeFromTo(@RequestParam("ageFrom") int ageFrom,@RequestParam("ageTo") int ageTo){
        return studentService.getStudentsByAgeBetween(ageFrom, ageTo);
   }

}
