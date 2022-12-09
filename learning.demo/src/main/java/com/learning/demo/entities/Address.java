package com.learning.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "user_id")
    private Integer id;
    @Column(name="flat_no")
    private String flatNo;
    @Column(name="area")
    private String area;
    @Column(name="state")
    private String state;
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "user_id")
//    private User user;
//

}
