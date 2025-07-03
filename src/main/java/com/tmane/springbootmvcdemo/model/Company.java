package com.tmane.springbootmvcdemo.model;

import com.tmane.springbootmvcdemo.enums.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private Long id;
    private String name;
    private String email;
    private String country;
    private String CEO;
    private LocalDate foundationDate;
    private Long revenue;
    private Sector sector;
    private String description;
}
