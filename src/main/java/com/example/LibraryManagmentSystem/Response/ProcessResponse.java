package com.example.LibraryManagmentSystem.Response;

import com.example.LibraryManagmentSystem.Models.RequestStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcessResponse {

    private RequestStatus requestStatus;
    private String systemComment;
    private String adminComment;
}
