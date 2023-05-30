package exception;



public class MedicineDoesNotExistException extends Exception{
    /* To be thrown if a searched medicine does not exist in
    the inventory
     */

    public MedicineDoesNotExistException(String name, String type) {
        super("ERROR :: A  " + type +  "-type " + "\"" + name + "\"" + " does not exist in the inventory" );
    }
}
