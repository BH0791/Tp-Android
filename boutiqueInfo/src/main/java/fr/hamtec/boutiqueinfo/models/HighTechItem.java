package fr.hamtec.boutiqueinfo.models;

public class HighTechItem {
    private String name;
    private double price;
    
    public HighTechItem( String name, double price ) {
        this.name = name;
        this.price = price;
    }
    
    public String getName( ) {
        return name;
    }
    
    public double getPrice( ) {
        return price;
    }
}
