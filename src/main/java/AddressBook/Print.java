package AddressBook;
import java.util.Map;

public class Print {

    public static void printDetails(Map<String, AddressBookDetails> dtoMap) {
        // Display the contact list of address book
        for(Map.Entry<String, AddressBookDetails> entry : dtoMap.entrySet()) {
            System.out.println("Contact Details of " +  entry.getValue().getFirstName() + " " + entry.getValue().toString());
        }

    }
}