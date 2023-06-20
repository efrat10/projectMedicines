import java.time.LocalDate;
import java.util.Locale;

import exception.*;
public abstract class Medicine {
    /*Medicine – an abstract class.
    Attributes: medicine name, company name, company email,
    quantity, quantity (num of box), expirationYear (YYYY ), typeOfMedicine (from enum)
    Methods: constructors, getters and setters, toString(),
    totalInventory() - an abstract method to calculate the total
    inventory for each medicine type (ex: 1 Acamol box has 50
    pills, if we have 1000 boxes = total 1000X50),
    inStock() – returns true if the quantity > 0 else returns false*/

    //Attributes
    private String medicineName;
    private String companyName;
    private String companyEmail;
    private int quantity;
    private int expirationYear;
    private double price;
    public enum Type {
        INHALER,
        PILLS,
        SYRUP
    }
    private Type type;

    //Constructors
    public Medicine()
    {

    }

    public Medicine(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, Type type) {
        setMedicineName(medicineName);
        setCompanyName(companyName);
        setCompanyEmail(companyEmail);
        setPrice(price);
        setQuantity(quantity);
        setExpirationYear(expirationYear);
        setType(type);
    }

    //getters
    public String getMedicineName() {
        return medicineName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public Type getType() {
        return type;
    }


    //setters

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName.toUpperCase();
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(Type type) {
        this.type = type;
    }

    //Method toString
    public String toString()
    {
     return "Medicine name: " + getMedicineName() + ", Company Name: " + getCompanyName() + ", Company email: "  + getCompanyEmail() + ", Price: "  + getPrice()  +
             ", Quantity: " + getQuantity() + ", Expiration year: " + getExpirationYear() +  ", Type of medicine: " + getType();

    }


    //totalInventory() - an abstract method to calculate the total
    //inventory for each medicine type (ex: 1 Acamol box has 50
    //pills, if we have 1000 boxes = total 1000X50),
    public abstract int totalInventory();

    //inStock() –The method returns true if the quantity > 0 else returns false
    public boolean inStock()
    {
        return ((getQuantity()>0));

    }

}
