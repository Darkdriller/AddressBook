package AddressBook;
import java.util.List;
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
    public static void printCityDictionary() {
        System.out.println("City Dictionary:");
        for (Map.Entry<String, List<AddressBookDetails>> entry : DataBase.cityToPersons.entrySet()) {
            System.out.println("City: " + entry.getKey());
            entry.getValue().forEach(person -> System.out.println(" - " + person));
        }
    }

    // Method to print state dictionary
    public static void printStateDictionary() {
        System.out.println("State Dictionary:");
        for (Map.Entry<String, List<AddressBookDetails>> entry : DataBase.stateToPersons.entrySet()) {
            System.out.println("State: " + entry.getKey());
            entry.getValue().forEach(person -> System.out.println(" - " + person));
        }
    }

}