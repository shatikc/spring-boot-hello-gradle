package com.example.springboothellogradle.dto;


import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponseDTO implements Serializable {

    private String name;
    private String email;
    private String message;
    private int age;

}
