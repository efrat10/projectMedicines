import java.util.ArrayList;
import java.util.Collections;
import exception.*;

public class Inventory {
    /*Inventory – class contains array list of all Medicines
    Methods:
    Constructors, getters and setters,
    addMedicine() – adds new medicine to array list
    Validation: Before adding a new medicine to the Inventory
    check if medicine name already exists.
    If so throw a new MedicineAlreadyExistException .
    searchMedicineByNameAndType() – returns a medicine according
    to its name and type and prints its total Inventory.
    If the Medicine does not exist throws a new
    MedicineDoesNotExistException.
    searchMedicineByType() – returns an array list of
    medicines by its type.
    getMedicinesInStock() - return array list of all medicines in stock*/

    private final ArrayList<Medicine> listOfMedicine = new ArrayList<>();

    /**
     * Adding a new drug to array list
     * @param medicine - obj of Medicine
     * @throws MedicineAlreadyExistException - if medicine name already exists
     */
    public void addMedicine(Medicine medicine) throws MedicineAlreadyExistException {

           if(!isMedicineExist(medicine.getMedicineName(),medicine.getType()))
               listOfMedicine.add(medicine);
           else
               throw new MedicineAlreadyExistException(" " + medicine.getMedicineName());
    }

    /**
     * The method check if the medicine already exist
     *  it gets a name and type of medicine and return true if exist and false if it doesn't
     * @param medicineName - The name of the medicine
     * @param type -The type of the medicine
     * @return true if exist and false if it doesn't
     */
    public boolean isMedicineExist(String medicineName, Medicine.Type type)
    {
        boolean flag = false;
        for (Medicine medicine:listOfMedicine) {
            if (medicine.getMedicineName().equalsIgnoreCase(medicineName) && medicine.getType().equals(type)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     *The function receives a drug name and type, and searches if it is in איק ןמהקמאםרט,
     * if so returns the drug object
     * @param medicineName - The name of medicine
     * @param type - The type of medicine
     * @return - the Medicine object
     * @throws MedicineDoesNotExistException - If the drug is not found
     */
    public Medicine searchMedicineByNameAndType(String medicineName, Medicine.Type type) throws MedicineDoesNotExistException {
        Medicine medicineFound = null;
        boolean flag = false;
        for (int i = 0; i < listOfMedicine.size() && !flag; i++) {

            if(listOfMedicine.get(i).getMedicineName().equalsIgnoreCase( medicineName) && listOfMedicine.get(i).getType().equals(type))
            {
                medicineFound =listOfMedicine.get(i) ;
                flag=true;
            }
        }
        if(!flag)
            throw new MedicineDoesNotExistException(medicineName,String.valueOf(type));
        else
        return medicineFound;
    }

    /**
     * Returns as an array all drugs that are or are not in stock (depending on the received parameter)
     * @param bool - True if you want to receive as an array all drugs in stock,
       and false if you want to receive as an array all drugs that are not in stock
     * @return an array all drugs that are or are not in stock (depending on the received parameter)
     */
    public ArrayList<Medicine> getListAllMedicineInStock(boolean bool) {
        ArrayList<Medicine> medicinesInStockArr = new ArrayList<>();
        for (Medicine medicine : listOfMedicine)
            if (medicine.inStock() == bool)
                medicinesInStockArr.add(medicine);
            return medicinesInStockArr;
        }

        //The method gets the type to search and returns an array list of medicines by its type.
        public ArrayList<Medicine> searchMedicineByType (Medicine.Type type)
        {
        ArrayList<Medicine> listOfMedicineByType = new ArrayList<>();

        for ( Medicine medicine:listOfMedicine )
        {
                if(medicine.getType().equals(type))

                    listOfMedicineByType.add(medicine);
        }
        return listOfMedicineByType;

        }

    }



