package AddressBook;
import java.util.Scanner;

public class Main {
    public static AddressBookService addressBookService = new AddressBookService();
    private static void updateRecords() {
        addressBookService.updateAddressBook(UserInput.userInputFromConsole());
    }
    // Main Method
    public static void main(String[] args) {
        System.out.println("**********Welcome to Address Book System Service*********");
        Scanner sc = new Scanner(System.in);
        // Add Contact to the Address Book
        AddressBookDetails addressBook = new AddressBookDetails("Dhruvjyoti", "Swain", "Vandan Flat", "Vadodara",
                "Gujarat", "390007", "8191804100", "example@google.com");
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.addData(addressBook);
        Print.printDetails(DataBase.dtoMap);

        String input = "Start";

        while(!input.equalsIgnoreCase("quit")) {
            System.out.println("enter quit to Quit or press any Button to Continue");
            input = sc.nextLine();
            System.out.println("Pick up the correct choice!");
            System.out.println("1. Add New Contact");
            System.out.println("2. Update Existing Contact");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addressBookService.addData(UserInput.userInputFromConsole());
                    break;
                case 2:
                    updateRecords();
                    break;
                default:
                    System.out.println("Please Enter valid choice!!");
                    break;
            }
            Print.printDetails(DataBase.dtoMap);

        }
    }


    }