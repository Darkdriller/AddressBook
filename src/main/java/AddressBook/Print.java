package AddressBook;
import java.util.Map;

public class Print {

    public static void printDetails(Map<String, AddressBookDetails> dtoMap) {
        // Display the contact list of address book
        for(Map.Entry<String, AddressBookDetails> entry : dtoMap.entrySet()) {
            System.out.println("Contact Details of " +  entry.getValue().getFirstName() + " " + entry.getValue().toString());
        }
    }

    public static void printAllAddressBooks() {
        for (Map.Entry<String, Map<String, AddressBookDetails>> addressBookEntry : DataBase.addressBooks.entrySet()) {
            System.out.println("Address Book: " + addressBookEntry.getKey());
            printDetails(addressBookEntry.getValue());
            System.out.println();
        }
    }

}