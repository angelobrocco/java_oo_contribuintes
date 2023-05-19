package entities;

public class TaxPayer {

    private static final double SALARY_TAX_RATE_ABOVE_5000 = 0.2;
    private static final double SALARY_TAX_RATE_BETWEEN_3000_AND_5000 = 0.1;
    private static final double SERVICES_TAX_RATE = 0.15;
    private static final double CAPITAL_TAX_RATE = 0.2;
    private static final double TAX_REBATE_PERCENTAGE = 0.3;
	
	private Double salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending;

	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome) {
		super();
		this.salaryIncome = salaryIncome;
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		super();
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax (double annualSalary) {
		double	salaryMonthly = annualSalary / 12;
		double salaryTax = 0;
		if (salaryMonthly >= 5000.00) {
			 salaryTax = annualSalary * SALARY_TAX_RATE_ABOVE_5000;
		
		} else if (salaryMonthly > 3000.00 && salaryMonthly <= 5000.00 ) {
			 salaryTax = annualSalary * SALARY_TAX_RATE_BETWEEN_3000_AND_5000;
			
		}
		return salaryTax;
	}
	
	public double servicesTax (double servicesIncome) {
		double servicesTax = servicesIncome * SERVICES_TAX_RATE;
		return servicesTax;
	}
	
	public double capitalTax(double capitalIncome ) {
		double capitalTax = capitalIncome * CAPITAL_TAX_RATE;
		return capitalTax;
	}
	
	public double grossTax(double annualSalary, double servicesIncome, double capitalIncome) {
		return salaryTax(annualSalary) + servicesTax(servicesIncome) + capitalTax(capitalIncome);
	}
	
	public double calculateTaxRebate(double annualSalary, double servicesIncome, double capitalIncome) {
		double sumExpenses = this.healthSpending + this.educationSpending;
		double maximumDeductible =  grossTax(annualSalary, servicesIncome, capitalIncome) * TAX_REBATE_PERCENTAGE;
		double abatement = Math.min(sumExpenses, maximumDeductible);
		
		return abatement;
	}
	
	public double netTax(double annualSalary, double servicesIncome, double capitalIncome) {
		return grossTax(annualSalary, servicesIncome, capitalIncome) - calculateTaxRebate(annualSalary, servicesIncome, capitalIncome);
	}
	
	public String toString() {
		return  "Imposto bruto total: " + String.format("%.2f\n", grossTax(salaryIncome, servicesIncome, capitalIncome)) 
        + "Abatimento: " + String.format("%.2f\n", calculateTaxRebate(salaryIncome, servicesIncome, capitalIncome)) 
        + "Imposto devido: " + String.format("%.2f", netTax(salaryIncome, servicesIncome, capitalIncome));
}
	}