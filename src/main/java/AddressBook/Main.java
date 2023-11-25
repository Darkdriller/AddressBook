package AddressBook;

public class Main {

    // Main Method
    public static void main(String[] args) {
        System.out.println("**********Welcome to Address Book System Service*********");

        // Add Contact to the Address Book
        AddressBookDetails addressBook = new AddressBookDetails("Dhruvjyoti", "Swain", "Vandan Flat", "Vadodara",
                "Gujarat", "390007", "8191804100", "example@google.com");
        AddressBookService addressBookService = new AddressBookService();
        addressBookService.addData(addressBook);
        Print.printDetails(DataBase.dtoMap);
    }
}