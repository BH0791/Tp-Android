package fr.hamtec.boutiqueinfo.models;

public class HighTechItem {
    private String name;
    private double price;
    private String mnemonic;
    
    public HighTechItem( String name, String mnemonic, double price ) {
        this.name = name;
        this.mnemonic = mnemonic;
        this.price = price;
    }
    
    public String getMnemonic( ) {
        return mnemonic;
    }
    
    public String getName( ) {
        return name;
    }
    
    public double getPrice( ) {
        return price;
    }
}
