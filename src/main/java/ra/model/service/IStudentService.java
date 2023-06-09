package ra.model.service;

import ra.model.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
    Student findById(int studentId);
    Student saveOrUpdate(Student student);
    void delete(int studentId);
    List<Student> findByName(String studentName,int studentId);
    List<Student> getStudentsByAgeBetween(int ageFrom,int ageTo);

}
