package com.learning.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="age")
    private Integer age;
    @Column(name="password")
    private String password;
}
