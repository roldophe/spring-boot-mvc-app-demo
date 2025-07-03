package com.tmane.springbootmvcdemo.dto;

import com.tmane.springbootmvcdemo.enums.Sector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
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
