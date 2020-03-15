package com.example.springboothellogradle.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@ToString
@Document
public class User {

    @Id
    private String user_email;
    private String name;
    private int age;

}
