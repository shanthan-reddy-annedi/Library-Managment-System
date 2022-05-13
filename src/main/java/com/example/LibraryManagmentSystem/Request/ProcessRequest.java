package com.example.LibraryManagmentSystem.Request;

import com.example.LibraryManagmentSystem.Models.Request;
import com.example.LibraryManagmentSystem.Models.RequestStatus;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProcessRequest {
    @NotNull
    private int adminId;
    @NotNull
    private int requestId;
    @NotNull
//    PENDING,
//    ACCEPTED,  // APPROVED
//    REJECTED
    private RequestStatus requestStatus;

    private String comment;

}
