package com.tmane.springbootmvcdemo.service.Impl;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import com.tmane.springbootmvcdemo.enums.Sector;
import com.tmane.springbootmvcdemo.model.Company;
import com.tmane.springbootmvcdemo.service.CompanyService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    
    private List<Company> companies = new ArrayList<>();
    private Long nextId = 1L;
    
    public CompanyServiceImpl() {
        // Initialize with some sample data
        companies.add(new Company(nextId++, "Tech Corp", "info@techcorp.com", "USA", "John Smith", 
                LocalDate.of(2010, 3, 15), 15000000L, Sector.INFORMATION_TECHNOLOGY, "A leading technology company"));
        companies.add(new Company(nextId++, "Health Solutions", "contact@healthsolutions.com", "Canada", "Sarah Johnson", 
                LocalDate.of(2015, 7, 22), 8500000L, Sector.HEALTHCARE_AND_LIFE_SCIENCES, "Healthcare service provider"));
        companies.add(new Company(nextId++, "Finance Pro", "hello@financepro.com", "UK", "Michael Brown", 
                LocalDate.of(2008, 11, 5), 22000000L, Sector.FINANCE_AND_BANKING, "Financial services company"));
    }
    
    @Override
    public List<CompanyDTO> getAllCompanies() {
        return companies.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<CompanyDTO> getCompaniesByName(String name) {
        return companies.stream()
                .filter(company -> company.getName().toLowerCase().contains(name.toLowerCase()))
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public CompanyDTO getCompanyById(Long id) {
        return companies.stream()
                .filter(company -> company.getId().equals(id))
                .map(this::convertToDTO)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public void saveCompany(CompanyDTO companyDTO) {
        Company company = convertFromDTO(companyDTO);
        
        if (company.getId() == null) {
            // New company
            company.setId(nextId++);
            companies.add(company);
        } else {
            // Update existing company
            companies.removeIf(c -> c.getId().equals(company.getId()));
            companies.add(company);
        }
    }
    
    @Override
    public void deleteCompanyById(Long id) {
        companies.removeIf(company -> company.getId().equals(id));
    }
    
    private CompanyDTO convertToDTO(Company company) {
        return CompanyDTO.builder()
                .id(company.getId())
                .name(company.getName())
                .email(company.getEmail())
                .country(company.getCountry())
                .CEO(company.getCEO())
                .foundationDate(company.getFoundationDate())
                .revenue(company.getRevenue())
                .sector(company.getSector())
                .description(company.getDescription())
                .build();
    }
    
    private Company convertFromDTO(CompanyDTO dto) {
        Company company = new Company();
        company.setId(dto.getId());
        company.setName(dto.getName());
        company.setEmail(dto.getEmail());
        company.setCountry(dto.getCountry());
        company.setCEO(dto.getCEO());
        company.setFoundationDate(dto.getFoundationDate());
        company.setRevenue(dto.getRevenue());
        company.setSector(dto.getSector());
        company.setDescription(dto.getDescription());
        return company;
    }
}
