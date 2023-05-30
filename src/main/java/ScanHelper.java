

import java.time.LocalDate;
import java.util.Scanner;

public class ScanHelper {

    //Create an obj for Scanner
    static Scanner input = new Scanner(System.in);

    /**
     * The function asks the user to enter a valid and desired value from the main menu
     *     and returns that (valid) value
     * @return-The selected valid value
     */
    public static int UserInputFromTheMainMenu(){
        int choice =0;
        String tmp ="";
        boolean flag = false;//if was NumberFormatException in main menu, flag will be true else it will be false

            //Executes the loop until a valid value is selected
            do{
                if(flag) {
                    if(tmp.length() == 0)
                        System.out.println("Nothing entered, please enter!");
                    else
                    System.out.println("No valid choice was entered, please enter a number between 1 and 6");
                }
                flag = false;
                //Receiving input from the user
                try {
                    tmp = input.nextLine();
                    if(tmp.length() !=1)
                        flag = true;
                    else {
                        choice = Integer.parseInt(tmp);
                        if(choice != Constants.CHOICE1 && choice != Constants.CHOICE2 && choice != Constants.CHOICE3 && choice != Constants.CHOICE4 && choice != Constants.CHOICE5 && choice != Constants.CHOICE6)
                            flag = true;
                    }
                } catch (NumberFormatException numberFormatException) {
                    //numberFormatException.printStackTrace();
                    flag = true;
                }
        }while (flag);
        return choice;
    }

    /**
     * The function asks from user to enter a valid int type of medicine from menu,
     * and returns it (in the form of an enum Type variable).
     * @return
     */
    public static Medicine.Type typeMedicineFromUser(){
        int numOfType = 0;
        String tmp ="";
        Medicine.Type type;
        boolean flag = false;

        //receiving a search type from the user
        System.out.println("Enter type:\n" + Constants.NUM_FOR_PILLS + " for pills\n" + Constants.NUM_FOR_SYRUP + " for syrup\n" + Constants.NUM_FOR_INHALER + " for inhaler");
        do {
            if(flag)
            {
                if(tmp.length() == 0)
                    System.out.println("Nothing entered, please enter!");
                else
                System.out.println("No valid choice was entered, please enter a number between 1 and 3");
            }

            flag =false;
            try{
                tmp = input.nextLine();
                if(tmp.length() !=1)
                    flag =true;
                if(!flag) {
                    numOfType = Integer.parseInt(tmp);
                    if (numOfType != Constants.NUM_FOR_PILLS && numOfType != Constants.NUM_FOR_SYRUP && numOfType != Constants.NUM_FOR_INHALER)
                        flag = true;
                }
            }catch (NumberFormatException n)
            {
                //n.printStackTrace();
                flag = true;
            }
        }while (flag);
        type = switch (numOfType) {
            case 2 -> Medicine.Type.SYRUP;
            case 3 -> Medicine.Type.INHALER;
            default -> Medicine.Type.PILLS;
        };
        return type;
    }

    /**
     * The function asks from the user to enter a medicine name (up to 20 characters)
     * @return - The name of the medicine entered
     */
    public static String inputMedicineName(){
        String str;
        System.out.println("Enter name of the medicine:");
        str = inputString(Constants.MAX_CHARACTERS_MEDICINE_NAME, "name Medicine");
        return str;
    }

    /**
     * The function asks from the user (until valid input)
     * to enter a company name (up to 20 characters)
     * @return - The name of the company entered
     */
    public static String inputCompanyName(){
        String str;
        System.out.println("Enter company Name of the medicine");
        str = inputString(Constants.MAX_CHARACTERS_FOR_COMPANY_NAME, "company name");
        return str;
    }

    /**
     *The function asks from the user (until valid input)
     * to enter a valid company email (up to 20 characters)
     * @return - The company email entered
     */
    public static String inputCompanyEmail(){
        String companyEmail;
        boolean flag;
        int lastIndexDot;
        int lastIndexShtrudel;
        System.out.println("Enter company email");
        do{
            flag = false;
            companyEmail = inputString(Constants.MAX_CHARACTERS_FOR_COMPANY_EMAIL, "company email");

            lastIndexDot = companyEmail.lastIndexOf(Constants.DOT_CHAR);
            lastIndexShtrudel = companyEmail.lastIndexOf(Constants.SHTRUDEL_CHAR);

            if (companyEmail.contains(Constants.SHTRUDEL_STR) && companyEmail.contains(Constants.DOT_STR))
                if ((companyEmail.endsWith(Constants.SHTRUDEL_STR)) || (companyEmail.endsWith(Constants.DOT_STR))
                        || (companyEmail.startsWith(Constants.SHTRUDEL_STR)) || (companyEmail.startsWith(Constants.DOT_STR)) || (lastIndexDot < lastIndexShtrudel) || (lastIndexShtrudel+1 == lastIndexDot)) {

                    flag = true;
                }
                else
                    flag = false;
            else
                flag = true;
            if (flag)
                System.out.println("The email address is invalid, please enter again");

        }while (flag);

        return companyEmail;
    }
    public static double inputPrice(){
        double price;
        boolean flag;
        System.out.println("Enter price");
        do {
            flag = false;
            price = inputDouble("price");
            if(price<=0) {
                flag = true;
                System.out.println("The price should be greater than 0, please press again");
            }
        } while (flag);

        return price;
    }

    /**
     * The function asks from the user (until valid input)
     * to enter int a quantity (up to 5 characters)
     * @return - The valid quantity entered
     */
    public static int inputQuantity(){
        int quantity;
        System.out.println("Enter quantity");
        quantity = inputIntOverZero("quantity",Constants.MAX_CHARACTERS_FOR_QUANTITY);
        return quantity;
    }

    /**
     * The function asks from the user (until valid input)
     * to enter valid expiration year
     * @return - The valid expiration year entered
     */
    public static int inputExpirationYear(){
        int expirationYear;
        boolean flag;
        LocalDate yearCurObj ;
        yearCurObj = LocalDate.now();
        System.out.println("Enter expiration year");
        do {
            flag = false;
            expirationYear = inputIntOverZero("expiration Year",Constants.MAX_CHARACTERS_FOR_EXPIRATION_YEAR);
            if (expirationYear < yearCurObj.getYear()) {
                flag = true;
                System.out.println("The year has expired, please enter again");
            }
        }while (flag);

        return expirationYear;
    }

    /**
     * The function asks from the user (until valid input)
     * to enter an amount of click(int) (up to 5 characters)
     * @return - The amount entered (int)
     */
    public static int inputAmountOfClick(){
        int amountOfClick;
        System.out.println("Enter amount Of Click");
        amountOfClick = inputIntOverZero("Amount Of Click" , Constants.MAX_CHARACTERS_FOR_AMOUNT_OF_CLICK);
        return amountOfClick;
    }

    /**
     * The function asks from the user (until valid input)
     * to enter a valid bottle content (int) (up to 4 characters)
     * @return -The bottle content entered (int)
     */
    public static int inputBottleContent(){
        int bottleContent;
        System.out.println("Enter bottle Content");
        bottleContent = inputIntOverZero("bottle Content", Constants.MAX_CHARACTERS_BOTTLE_CONTENT);
        return bottleContent;
    }

    /**
     * The function asks from the user (until valid input)
     * to enter a valid num of pills in box (int) (up to 3 characters)
     * @return - The name of the num of pills entered
     */
    public static int numOfPillsInBox(){
        int numOfPillsInBox;
        System.out.println("enter number Of Pills In Box");
        numOfPillsInBox = inputIntOverZero("num Of Pills In Box",Constants.MAX_CHARACTERS_NUM_OF_PILLS_IN_BOX);
        return numOfPillsInBox;
    }

    //The function accepts a string from the user and return its

    /**
     * The function accepts as a parameter a variable of type string as well as the number of characters limited to this variable,
     * and requests repeated input as long as the condition is not met,
     * Finally returns the entered legal value
     * @param maxCharacters - Number of characters to limit (of type int)
     * @param nameVar - The name of variable (of type String)
     * @return - The entered legal value
     */
    public static String inputString(int maxCharacters,String nameVar){
        String str;
        boolean flag;
        do
        {
            flag = false;
            str = input.nextLine();
            if(str.length() > maxCharacters) {
                System.out.println("You cannot enter more than " + maxCharacters + " characters for " + nameVar +", please enter again!");
                flag = true;
            }
            else if(str.trim().length() == 0) {
                    System.out.println("Nothing entered for " + nameVar +", please enter!");
                    flag = true;
                }
        }while (flag);
        return str;
    }

    /**
     *  The function accepts as a parameter a string as well as the number of characters limited to this variable,
     *   and requests repeated input as long as the condition is not met
     *   (A positive integer up to the maximum number of characters received as a parameter)
     *   Finally returns the entered legal value (of type int)
     * @param nameVar - The string you want to check and return as a number
     * @param maxCharacters - The maximum number of characters that the first parameter will be limited to
     * @return - The entered legal value (of type int)
     */
    public static int inputIntOverZero(String nameVar,int maxCharacters) {
        String tmp;
        boolean flag;
        int number = 0;
        do {
            flag = false;
            tmp = inputString(maxCharacters,nameVar);
            if (tmp.contains(" ")) {
                System.out.println("Please enter a number without a space");
                flag = true;
            } else if (tmp.contains(Constants.DOT_STR)) {
                System.out.println("Decimal number cannot be entered for " + nameVar + " please enter a whole number");
                flag = true;
            }
            if (!flag) {
                try {
                    number = Integer.parseInt(tmp);
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                    System.out.println("An invalid value was entered, please enter a valid value for " +nameVar);
                    flag = true;
                }
                if(number<=0 && !flag) {
                    flag = true;
                    System.out.println("The " + nameVar+" should be greater than 0, please press again");
                }
            }

        } while (flag);
        return number;
    }


    /**
     * The function receives a string, and checks if it is correct in terms of input of a number of type double,
     * if not it requests repeated input until the input is correct, finally returns a legal variable of type double
     * @param nameVar - the string
     * @return - A legal variable of type double
     * @throws NumberFormatException - if it is not correct in terms of input of a number of type double
     */
    public static double inputDouble(String nameVar) throws NumberFormatException{
        String tmp;
        boolean flag;
        double number = 0;

        do{
            flag = false;
            tmp = inputString(9,nameVar);
            try {
                number = Double.parseDouble(tmp);
            }catch (NumberFormatException n){
                System.out.println("An invalid value was entered for " + nameVar + ", please enter a valid value");
                flag = true;
            }
        }while (flag);

        return number;
    }
}
