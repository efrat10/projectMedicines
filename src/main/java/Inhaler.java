
import exception.*;
public class Inhaler extends Medicine {
    // Inhaler – extends from Medicine
    //(מס' לחיצות) Attributes: amountOfClick
    //Methods: Constructors, getters and setters, override of
    //toString(), override of totalInventory()

    //Attributes
    private int amountOfClick;

    //constructors
    public Inhaler() {

    }

    public Inhaler(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, int amountOfClick)  {
        super(medicineName, companyName, companyEmail, price, quantity, expirationYear, Type.INHALER);
        setAmountOfClick(amountOfClick);
    }

    //Getters
    public int getAmountOfClick() {
        return amountOfClick;
    }

    //Setters
    public void setAmountOfClick(int amountOfClick) {
        this.amountOfClick = amountOfClick;
    }

    //override of toString()
    public String toString()
    {
        return super.toString() + ", Amount of click: " + amountOfClick;
    }

    //override of totalInventory()
    @Override
    public int totalInventory() {
        return getAmountOfClick()*getQuantity();
    }

}
