package com.example.LibraryManagmentSystem.Request;

import com.example.LibraryManagmentSystem.Models.Student;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateRequest {
    @NotNull
    private String name;

    @Min(1)
    private Integer age;

    @Email
    private String email;

    private String phoneNo;

    @NotNull
    @Size(min = 12, max=12)
    private String rollno;

    public Student to(){
        return Student.builder()
                .age(this.age)
                .email(this.email)
                .phoneNo(this.phoneNo)
                .name(this.name)
                .URN(this.rollno)
                .build();
    }
}
