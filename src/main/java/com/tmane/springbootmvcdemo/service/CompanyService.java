package com.tmane.springbootmvcdemo.service;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import java.util.List;

public interface CompanyService {
    List<CompanyDTO> getAllCompanies();
    List<CompanyDTO> getCompaniesByName(String name);
    CompanyDTO getCompanyById(Long id);
    void saveCompany(CompanyDTO companyDTO);
    void deleteCompanyById(Long id);
}
