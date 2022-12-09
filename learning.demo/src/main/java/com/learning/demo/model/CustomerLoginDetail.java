package com.learning.demo.model;

import com.learning.demo.entities.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLoginDetail {

    @Min(5)
    private Integer id;
    @NotBlank(message = "Name is required")
    @NotEmpty(message = "Name is required!")
    private String name;
    private String email;
    private Integer age;
    private String password;
//    private Address address;
}
