package exception;
public class MedicineAlreadyExistException extends Exception{
     /* To be thrown in the case of an attempt to add a medicine
      that already exists in the inventory
     */

    public MedicineAlreadyExistException(String name) {
        super("ERROR :: Adding The medicine failed Because of the " + name + " already exist in the inventory.");
    }
}

