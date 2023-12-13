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

            System.out.println("Choose option: \n1. Add new Address Book \n2. Add Contact \n3. Update Contact \n4. Delete Contact \n5.Search By City or" +
                    "State \n6. Give State Dictionary \n7. Give City Dictionary \n8. Sort by Name \n9. Sort by City \n10. Sort by State \n11. Sort by Zip" +
                    " \n12. Write to CSV \n13. ReadFromCSV  \n14. Exit");
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
                    System.out.println("Enter Address Book Name:");
                    bookName = sc.nextLine();
                    Print.printDetails(DataBase.getAddressBook(bookName));
                    System.out.println("Enter City:");
                    String city = sc.nextLine();
                    System.out.println("Enter State:");
                    String state = sc.nextLine();
                    addressBookService.searchByCityOrState(city, state);
                    break;
                case 6:
                    System.out.println("Print State Dictionary");
                    Print.printStateDictionary();
                    break;
                case 7:
                    System.out.println("Print City Dictionary");
                    Print.printCityDictionary();
                    break;
                case 8:
                    System.out.print("Enter Address Book Name: ");
                    String addressBookName = sc.nextLine();
                    addressBookService.sortPersonsByName(addressBookName)
                            .forEach(System.out::println);
                    break;
                case 9:
                    System.out.print("Enter Address Book Name: ");
                    addressBookName = sc.nextLine();
                    addressBookService.sortPersonsByCity(addressBookName)
                            .forEach(System.out::println);
                    break;
                case 10:
                    System.out.print("Enter Address Book Name: ");
                    addressBookName = sc.nextLine();
                    addressBookService.sortPersonsByState(addressBookName)
                            .forEach(System.out::println);
                    break;
                case 11:
                    System.out.print("Enter Address Book Name: ");
                    addressBookName = sc.nextLine();
                    addressBookService.sortPersonsByZip(addressBookName)
                            .forEach(System.out::println);
                   break;
                case 12:
                    System.out.print("Enter Address Book Name: ");
                    addressBookName = sc.nextLine();
                    System.out.print("Enter CSV File Path to Save: ");
                    String filePath = sc.nextLine();
                    addressBookService.saveToCSV(addressBookName, filePath);
                    break;
                case 13:
                    System.out.print("Enter Address Book Name: ");
                    addressBookName = sc.nextLine();
                    System.out.print("Enter CSV File Path to Load: ");
                    filePath = sc.nextLine();
                    addressBookService.loadFromCSV(addressBookName, filePath);
                    break;
                case 14:
                    return;

            }
        }
    }
}
