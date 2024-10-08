package heranca_polimorfismo.exercicio1.heranca.entities;

public class ImportedProduct extends Product{
    private Double customsFee;

    public ImportedProduct(){
        super();

    }
    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }


    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }

    public String priceTag() {
        return super.priceTag()+" Custom Fee: " + customsFee + " Valor total: " + (customsFee + super.getPrice()) ;
    }



}
