import java.util.jar.Attributes;
import exception.*;
public class Pills extends Medicine {
    //extends from Medicine
    //Attributes: (מספר כדורים) numOfPillsInBox
    //Methods: Constructors, getters and setters, override of
    //toString(), override of totalInventory()

    //Attributes
    private int numOfPillsInBox;

    //constructors
    public Pills() {

    }

    public Pills(String medicineName, String companyName, String companyEmail, double price, int quantity, int expirationYear, int numOfPillsInBox) {
        super(medicineName, companyName, companyEmail, price, quantity, expirationYear, Type.PILLS);
        setNumOfPillsInBox(numOfPillsInBox);
    }

    //getters
    public int getNumOfPillsInBox() {
        return numOfPillsInBox;
    }

    //setters
    public void setNumOfPillsInBox(int numOfPillsInBox)  {
                this.numOfPillsInBox = numOfPillsInBox;

    }

    //override of toString()
    public String toString()
    {
        return super.toString() + ", num of pills in box: " + numOfPillsInBox;
    }

    //override of totalInventory()


    @Override
    public int totalInventory() {
        return (numOfPillsInBox*getQuantity());
    }
}
