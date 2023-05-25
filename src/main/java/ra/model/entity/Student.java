package ra.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private int studentId;
    @Column(name = "studentName",columnDefinition = "nvarchar(50)",nullable = false,unique = true)
    private String studentName;
    @Column(name = "age")
    private int age;
    @Column(name = "birthDate")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date birthDate;
   @Column(name = "status")
    private boolean status;



}
