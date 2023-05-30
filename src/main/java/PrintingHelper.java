import java.util.ArrayList;


public class PrintingHelper {
    Inventory inventory = new Inventory();

    //The method displays a main menu to the user
    public static void mainMenu() {
        System.out.println("\nChoose from the menu\n" +
                " 1. Printing all medications in stock\n" + " 2. Printing all out-of-stock medications\n" +
                " 3. Adding a medicine\n 4. Searching for a medicine by name and type\n 5. Searching for medicines by type\n" +
                " 6. For exit\n");
    }

    public static void allMedicineNotInStock(ArrayList<Medicine> arrNotInStock) {
        if(arrNotInStock.size()!=0) {
            System.out.println("----Printing all out of stock medication----");
            for (Medicine medicine : arrNotInStock)
                System.out.println(medicine.toString());
        }
        else
            System.out.println("There are no drugs that are out of stock");
    }

    //The method Print all in stock medications
    public static void allMedicineInStock(ArrayList<Medicine> arrInStock) {
        ArrayList<Medicine> arr = new ArrayList<>();
        System.out.println("----Printing all medication in stock----");
        for (Medicine medicine : arrInStock)
            System.out.println(medicine.toString());
    }

    //The func prints arrayList
    public static void printArr(ArrayList<Medicine> medicineArrayList) {
        for (Medicine medicine : medicineArrayList) {
            System.out.println(medicine.toString());

        }

    }
}