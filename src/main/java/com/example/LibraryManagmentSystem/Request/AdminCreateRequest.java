package com.example.LibraryManagmentSystem.Request;

import com.example.LibraryManagmentSystem.Models.Admin;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminCreateRequest {

    private String name;
    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 12,max = 12)
    private String urn;
    private String phoneNo;

    public Admin to(){
        return Admin.builder()
                .email(this.email)
                .name(this.name)
                .urn(this.urn)
                .phoneNo(this.phoneNo)
                .build();
    }
}
