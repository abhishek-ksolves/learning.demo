package com.learning.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="employee")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="designation")
    private String designation;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "company_id", referencedColumnName = "id")
//    private Company company;

}
