import java.util.ArrayList;
import exception.*;
//new
public class MedicineMain {

    /* Main Class:
        1) create a new inventory
        2) create 3 medicines of each type add them to the inventory
        3) search for a specific medicine by name and type
        4) search for all medicines by type
        5) prints all medicines in stock
        6) try to add an existing Medicine to the Inventory
        7) Search for a non-existing Medicine
        8) Try to add a medicine with an incorrect e-mail*/

    //create a new obj for Inventory
    static Inventory inventory = new Inventory();

    public static void main(String[] args) {

        int choice = 0;
        boolean flagAddMedicine = true;

        ArrayList<Medicine> medicinesOfType;

        //Create medicines of each type and adding them to the inventory
        try {
            Pills medicine1 = new Pills("Acamoly", "teva", "teva@gmail.com", 40, 0, 2030, 30);
            inventory.addMedicine(medicine1);
            Pills medicine2 = new Pills("Dexamol", "dexcel", "dexcel@mail.com", 18.5, 45, 2023, 20);
            inventory.addMedicine(medicine2);
            Syrup medicine3 = new Syrup("Noraphen", "relax", "relax@co.il", 45, 270, 2028, 180);
            inventory.addMedicine(medicine3);
            Syrup medicine7 = new Syrup("Ferripel", "cts", "cts@co.il", 27, 270, 2024, 15);
            inventory.addMedicine(medicine7);

            Inhaler medicine4 = new Inhaler("Sodium", "saga", "saga@org.il", 52.5, 300, 2024, 44);
            inventory.addMedicine(medicine4);
            Inhaler medicine5 = new Inhaler("Chlorid", "natrol", "natrol@co.il", 52.5, 300, 2027, 44);
            inventory.addMedicine(medicine5);
            Inhaler medicine6 = new Inhaler("Acamol porta", "natrol", "natrol@org.il", 52.5, 13, 2027, 100);
            inventory.addMedicine(medicine6);
            System.out.println(medicine1);

        } catch (MedicineAlreadyExistException m) {
            m.printStackTrace();
        }


        //Calling to func that print main menu
        PrintingHelper.mainMenu();

        //Executes the loop as long as the number 6 is not selected from the menu (exit)
        while (choice != Constants.CHOICE6) {

            //calling the func that returns the user's selection from the main menu (int between 1 and 6)
            choice = ScanHelper.UserInputFromTheMainMenu();

            switch (choice) {
                case 1:
                    //Printing all medicine in stock
                    PrintingHelper.allMedicineInStock(inventory.getListAllMedicineInStock(true));
                    break;

                case 2:
                    //Printing all medicine that not in stock
                    PrintingHelper.allMedicineNotInStock(inventory.getListAllMedicineInStock(false));
                    break;

                case 3:
                    //Adding a new medicine
                    try {
                        addMedicineMain(ScanHelper.typeMedicineFromUser());
                        flagAddMedicine = false;
                    } catch (MedicineAlreadyExistException e) {
                        e.printStackTrace();
                        flagAddMedicine = true;
                    } finally {
                        if (!flagAddMedicine)
                            System.out.println("The medicine was added successfully");
                    }
                    break;

                case 4:
                    //Search for a specific medicine by name and type
                    //Reference to a searchByNameMain()
                    try {
                        searchByNameMain();
                    } catch (MedicineDoesNotExistException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                {
                    /*Printing all medicine according to type That received from user
                    Sending the type that received from the user to searchMedicineByType func and receiving ArrayList from it*/
                    medicinesOfType = inventory.searchMedicineByType(ScanHelper.typeMedicineFromUser());

                    //Sending ArrayList to printArr func that print it
                    if (medicinesOfType.size() > 0) {
                        System.out.println("----Printing medicines By type----");
                        PrintingHelper.printArr(medicinesOfType);
                    } else
                        System.out.println("There is no such medicine for this type");
                }

                }//close switch
                    //A reference to the method that displays a main menu to the user
                    if (choice != Constants.CHOICE6)
                        PrintingHelper.mainMenu();

            }//close while
        }//close main func



    /**
     * Adds a new drug to the inventory, according to the details the user enters
     * @param typeOfMedicine-The type of new drug the user wants to add
     * @throws MedicineAlreadyExistException- If the drug already exists
     */
        public static void addMedicineMain(Medicine.Type typeOfMedicine ) throws   MedicineAlreadyExistException {

            switch (typeOfMedicine) {
                case PILLS -> {
                    Pills pills = new Pills();
                    setMedicine(pills, Medicine.Type.PILLS);
                    pills.setNumOfPillsInBox(ScanHelper.numOfPillsInBox());
                    inventory.addMedicine(pills);
                }
                case SYRUP -> {
                    Syrup syrup = new Syrup();

                        setMedicine(syrup, Medicine.Type.SYRUP);
                        syrup.setBottleContent(ScanHelper.inputBottleContent());
                        inventory.addMedicine(syrup);
                }
                case INHALER -> {
                    Inhaler inhaler = new Inhaler();
                    setMedicine(inhaler, Medicine.Type.INHALER);
                    inhaler.setAmountOfClick(ScanHelper.inputAmountOfClick());
                    inventory.addMedicine(inhaler);
                }
            }
    }


    /**
     * The func asks form user values to Characters medicine and set them in the received obj
     * @param medicine-An empty object created according to the type requested to be added-
     * @param type-The type of drug to add
     * @throws MedicineAlreadyExistException-If the drug already exists
     */
    public static void setMedicine(Medicine medicine, Medicine.Type type) throws MedicineAlreadyExistException {
        String medicineName = ScanHelper.inputMedicineName().toUpperCase();
        if(!inventory.isMedicineExist(medicineName,type))
        {
            medicine.setMedicineName(medicineName);
            medicine.setCompanyName(ScanHelper.inputCompanyName());
            medicine.setCompanyEmail(ScanHelper.inputCompanyEmail());
            medicine.setPrice(ScanHelper.inputPrice());
            medicine.setQuantity(ScanHelper.inputQuantity());
            medicine.setExpirationYear(ScanHelper.inputExpirationYear());
            medicine.setType(type);
        }
        else
            throw new MedicineAlreadyExistException(" " + type + " " + medicineName);
    }

    /**
     * The method asks from user a name medicine and type for  search
     * and Prints the details of the drug found as well as its total inventory
     * @throws MedicineDoesNotExistException-If the drug is not found
     */
    public static void searchByNameMain() throws  MedicineDoesNotExistException {
        String nameMedicineFromUser;
        Medicine.Type typeMedicineFromUser;
        Medicine medicineReturn;
        //Receiving a medicine name for search from the user
        nameMedicineFromUser = ScanHelper.inputMedicineName();
        typeMedicineFromUser = ScanHelper.typeMedicineFromUser();

        medicineReturn = inventory.searchMedicineByNameAndType(nameMedicineFromUser,typeMedicineFromUser);
                System.out.println("A " + typeMedicineFromUser + "-type " + "\"" + medicineReturn.getMedicineName() + "\"" + " exists in the inventory" +
                        " and the total inventory is: " + medicineReturn.totalInventory() + "\n" + medicineReturn);
    }

    }


