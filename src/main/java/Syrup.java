import exception.*;
public class Syrup extends Medicine {
    //Syrup – extends from Medicine
    //(תכולת בקבוק במ"ל) Attributes: bottleContent
    //Methods: Constructors, getters and setters, override of
    //toString(), override of totalInventory()

    //Attributes
    private int bottleContent;

    //Constructors
    public Syrup()
    {

    }
    public Syrup(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, int bottleContent) {
        super(medicineName, companyName, companyEmail, price, quantity, expirationYear, Type.SYRUP);
        setBottleContent(bottleContent);
    }

    //Getters
    public int getBottleContent() {
        return bottleContent;
    }

    //Setters
    public void setBottleContent(int bottleContent){
                this.bottleContent = bottleContent;
    }

    //override of toString()
    public String toString()
    {
        return super.toString() + ", Bottle contant: " + bottleContent;
    }

    //override of totalInventory()
    public  int totalInventory()
    {
        return getBottleContent()*getQuantity();
    }
}
