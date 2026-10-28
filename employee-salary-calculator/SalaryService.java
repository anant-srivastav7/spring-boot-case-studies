package com.example.employee_salary_calculator;

import org.springframework.stereotype.Service;

@Service
public class SalaryService {
	public double calculateAllowances(double basicSalary) {
        return basicSalary * 0.20;
    }

    public double calculateDeductions(double basicSalary) {
        return basicSalary * 0.10;
    }

    public double calculateNetSalary(double basicSalary) {
        double allowances = calculateAllowances(basicSalary);
        double deductions = calculateDeductions(basicSalary);

        return basicSalary + allowances - deductions;
    }

}
