package AddressBook;
import java.util.Scanner;

public class UserInput {

    /* UC-2 */
   /*  Ability to add new contact to address book
     Use console to add person details */
    public static Scanner sc = new Scanner(System.in);

    public static AddressBookDetails userInputFromConsole(){
        AddressBookDetails AddressBookDetails;
        AddressBookDetails = new AddressBookDetails();
        System.out.println("To Add New Contact :- ");

        System.out.println("Enter First Name : ");
        AddressBookDetails.setFirstName(sc.nextLine());

        System.out.println("Enter Last Name : ");
        AddressBookDetails.setLastName(sc.nextLine());

        System.out.println("Enter the Address : ");
        AddressBookDetails.setAddress(sc.nextLine());

        System.out.println("Enter the City Name : ");
        AddressBookDetails.setCity(sc.nextLine());

        System.out.println("Enter the State Name : ");
        AddressBookDetails.setState(sc.nextLine());

        System.out.println("Enter the Zip Code of the City : ");
        AddressBookDetails.setZipNo(sc.nextLine());

        System.out.println("Enter the Mobile Number : ");
        AddressBookDetails.setMobileNo(sc.nextLine());

        System.out.println("Enter the Email Id : ");
        AddressBookDetails.setEmailId(sc.nextLine());

        return AddressBookDetails;
    }
}