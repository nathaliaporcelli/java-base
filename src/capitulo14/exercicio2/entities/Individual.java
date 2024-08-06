package capitulo14.exercicio2.entities;

public class Individual extends TaxPayer{

   private Double healthExpenditures;

    public Individual(){
        super();
    }

    public Individual(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double taxToPay() {
        double basicTax;

        if(getAnualIncome() < 20000){
            basicTax = getAnualIncome()*0.15;
        } else {
            basicTax = getAnualIncome()*0.25;

        }
        if (healthExpenditures > 0){
            basicTax -= healthExpenditures*.5;

            if(basicTax < 0.0){
                basicTax = 0.0;
            }
        }
        return basicTax;
    }
}
