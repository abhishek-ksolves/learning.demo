package com.learning.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CabBook")
public class CabBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id")
    private Integer bookingId;

    @Column(name="cab_name")
    private String cabName;
}
