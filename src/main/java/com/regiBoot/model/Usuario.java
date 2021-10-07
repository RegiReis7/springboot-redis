package com.regiBoot.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private int age;
}
