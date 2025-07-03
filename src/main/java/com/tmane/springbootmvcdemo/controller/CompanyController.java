package com.tmane.springbootmvcdemo.controller;

import com.tmane.springbootmvcdemo.dto.CompanyDTO;
import com.tmane.springbootmvcdemo.enums.Sector;
import com.tmane.springbootmvcdemo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tmane.springbootmvcdemo.util.Constants.*;

@AllArgsConstructor
@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public String displayHomePage(Model model,
                                  @RequestParam(value = "keyword", required = false) String keyword) {
        List<CompanyDTO> companyList;
        
        if (keyword != null && !keyword.trim().isEmpty() && !"null".equalsIgnoreCase(keyword)) {
            companyList = companyService.getCompaniesByName(keyword);
        } else {
            companyList = companyService.getAllCompanies();
        }
        
        model.addAttribute("companyList", companyList);
        model.addAttribute("keyword", keyword);
        
        return COMPANIES_PAGE;
    }

    @GetMapping("/{id}")
    public String displayCompanyDetails(@PathVariable Long id, Model model) {
        CompanyDTO company = companyService.getCompanyById(id);
        if (company == null) {
            return "redirect:/companies";
        }
        model.addAttribute("company", company);
        return VIEW_COMPANY_PAGE;
    }

    @GetMapping("/new")
    public String displayAddCompanyForm(Model model) {
        model.addAttribute("company", new CompanyDTO());
        model.addAttribute("sectors", Sector.values());
        return ADD_COMPANY_PAGE;
    }

    @PostMapping
    public String saveCompany(@ModelAttribute("company") CompanyDTO companyDTO) {
        if (companyDTO.getSector() == null) {
            companyDTO.setSector(Sector.DEFAULT_SECTOR);
        }
        companyService.saveCompany(companyDTO);
        return "redirect:" + COMPANIES_REDIRECT;
    }

    @GetMapping("/{id}/edit")
    public String displayEditCompanyForm(@PathVariable Long id, Model model,
                                         @RequestParam(value = "keyword", required = false) String keyword) {
        CompanyDTO companyDTO = companyService.getCompanyById(id);
        if (companyDTO == null) {
            return "redirect:/companies";
        }
        model.addAttribute("company", companyDTO);
        model.addAttribute("sectors", Sector.values());
        model.addAttribute("keyword", keyword);
        return EDIT_COMPANY_PAGE;
    }

    @PostMapping("/{id}/update")
    public String updateCompany(@ModelAttribute("company") CompanyDTO companyDTO,
                                @PathVariable Long id,
                                @RequestParam(value = "keyword", required = false) String keyword) {
        companyDTO.setId(id);
        companyService.saveCompany(companyDTO);
        return "redirect:" + COMPANIES_REDIRECT + "?keyword=" + (keyword == null ? "" : keyword);
    }

    @GetMapping("/{id}/delete")
    public String deleteCompany(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return "redirect:" + COMPANIES_REDIRECT;
    }
}
