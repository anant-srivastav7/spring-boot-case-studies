package com.example.employee_salary_calculator;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
public class SalaryController {
	private final SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping
    public Map<String, Object> calculateSalary(@RequestBody Employee employee) {

        double basicSalary = employee.getBasicSalary();
        double allowances = salaryService.calculateAllowances(basicSalary);
        double deductions = salaryService.calculateDeductions(basicSalary);
        double netSalary = salaryService.calculateNetSalary(basicSalary);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("employeeName", employee.getName());
        result.put("basicSalary", basicSalary);
        result.put("allowances", allowances);
        result.put("deductions", deductions);
        result.put("netSalary", netSalary);

        return result;
    }

}
