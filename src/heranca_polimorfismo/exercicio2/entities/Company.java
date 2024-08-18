package heranca_polimorfismo.exercicio2.entities;

public class Company extends TaxPayer{

    private Integer numberOfEmployees;

    public Company(){
        super();
    }

    public Company(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double taxToPay() {
       Double basicTax;
        if(numberOfEmployees <= 10){
            basicTax = getAnualIncome()*0.16;
        } else{
            basicTax = getAnualIncome()*0.14;
        }
        return basicTax;
    }
}
