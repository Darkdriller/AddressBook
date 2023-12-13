package AddressBook;

import java.util.*;
import java.util.stream.Collectors;

public class DataBase {
    public static Map<String, Map<String, AddressBookDetails>> addressBooks = new HashMap<>();
    public static Map<String, List<AddressBookDetails>> cityToPersons = new HashMap<>();
    public static Map<String, List<AddressBookDetails>> stateToPersons = new HashMap<>();

    public static Map<String, AddressBookDetails> getAddressBook(String name) {
        return addressBooks.computeIfAbsent(name, k -> new HashMap<>());
    }

    public static Set<String> getAllAddressBookNames() {
        return addressBooks.keySet();
    }

    public static Map<String, Map<String, AddressBookDetails>> getAllAddressBooks() {
        return  addressBooks;
    }

    public static void updateDictionaries() {
        cityToPersons = addressBooks.values().stream()
                .flatMap(map -> map.values().stream())
                .collect(Collectors.groupingBy(person -> person.getCity().toLowerCase()));

        stateToPersons = addressBooks.values().stream()
                .flatMap(map -> map.values().stream())
                .collect(Collectors.groupingBy(person -> person.getState().toLowerCase()));
    }

    // Method to get persons by city
    public static List<AddressBookDetails> getPersonsByCity(String city) {
        return cityToPersons.getOrDefault(city.toLowerCase(), new ArrayList<>());
    }

    // Method to get persons by state
    public static List<AddressBookDetails> getPersonsByState(String state) {
        return stateToPersons.getOrDefault(state.toLowerCase(), new ArrayList<>());
    }
}
