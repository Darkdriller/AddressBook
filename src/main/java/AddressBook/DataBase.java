package AddressBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DataBase {
    public static Map<String, Map<String, AddressBookDetails>> addressBooks = new HashMap<>();

    public static Map<String, AddressBookDetails> getAddressBook(String name) {
        return addressBooks.computeIfAbsent(name, k -> new HashMap<>());
    }

    public static Set<String> getAllAddressBookNames() {
        return addressBooks.keySet();
    }

}
