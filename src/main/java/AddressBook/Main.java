package AddressBook;

import java.util.Scanner;

public class Main {
    private static AddressBookService addressBookService = new AddressBookService();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("**********Welcome to Address Book System Service*********");


        while (true) {
            System.out.println("Current AddressBooks Are: ");
            Print.printAllAddressBooks();

            System.out.println("Choose option: \n1. Add new Address Book \n2. Add Contact \n3. Update Contact \n4. Delete Contact \n5. Exit");
            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            String bookName;
            switch (option) {
                case 1:
                    System.out.println("Available Address Books: " + DataBase.getAllAddressBookNames());
                    System.out.println("Enter Address Book Name:");
                    bookName = sc.nextLine();
                    DataBase.getAddressBook(bookName);
                    break;
                case 2:
                    System.out.println("Enter Address Book Name:");
                    bookName = sc.nextLine();
                    Print.printDetails(DataBase.getAddressBook(bookName));
                    AddressBookDetails newContact = UserInput.userInputFromConsole();
                    addressBookService.addData(bookName, newContact);
                    break;
                case 3:
                    System.out.println("Enter Address Book Name:");
                    bookName = sc.nextLine();
                    Print.printDetails(DataBase.getAddressBook(bookName));
                    System.out.println("Enter First Name of contact to update:");
                    String firstName = sc.nextLine();
                    System.out.println("Enter Last Name of contact to update:");
                    String lastName = sc.nextLine();
                    AddressBookDetails updatedContact = UserInput.userInputFromConsole();
                    addressBookService.updateAddressBook(bookName, firstName, lastName, updatedContact);
                    break;
                case 4:
                    System.out.println("Enter Address Book Name:");
                    bookName = sc.nextLine();
                    Print.printDetails(DataBase.getAddressBook(bookName));
                    System.out.println("Enter First Name of contact to delete:");
                    firstName = sc.nextLine();
                    System.out.println("Enter Last Name of contact to delete:");
                    lastName = sc.nextLine();
                    addressBookService.deleteRecord(bookName, firstName, lastName);
                    break;
                case 5:
                    return;
            }
        }
    }
}
