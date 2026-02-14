package org.example;

public class LoanService {

    public boolean isEligible(int age, double salary) {

        if (age < 21 || age > 60) {
            return false;
        }

        if (salary < 25000) {
            return false;
        }

        return true;
    }

    public double calculateEMI(double loanAmount, int tenureYears) {

        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Invalid loan amount");
        }

        if (tenureYears <= 0) {
            throw new IllegalArgumentException("Invalid tenure");
        }

        return loanAmount / (tenureYears * 12);
    }

    public String getLoanCategory(int creditScore) {

        if (creditScore >= 750) {
            return "Premium";
        }
        else if (creditScore >= 600) {
            return "Standard";
        }
        else {
            return "High Risk";
        }
    }
}
