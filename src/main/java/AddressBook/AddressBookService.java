package AddressBook;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

public class AddressBookService {
    // Method to check for duplicates within a single address book
    private boolean isDuplicateContact(String addressBookName, AddressBookDetails contact) {
        Map<String, AddressBookDetails> addressBook = DataBase.getAddressBook(addressBookName);
        return addressBook.values().stream().anyMatch(contact::equals);
    }

    // Updated addData method to check for duplicate before adding a new contact
    public void addData(String addressBookName, AddressBookDetails dto) {
        if (!isDuplicateContact(addressBookName, dto)) {
            Map<String, AddressBookDetails> addressBook = DataBase.getAddressBook(addressBookName);
            addressBook.put(dto.getFirstName() + " " + dto.getLastName(), dto);
            DataBase.updateDictionaries();
        } else {
            System.out.println("Addition Not done: Reason Duplicate!");
        }
    }

    // Updates a contact in the specified address book
    public void updateAddressBook(String addressBookName, String firstName, String lastName, AddressBookDetails newDetails) {
        Map<String, AddressBookDetails> addressBook = DataBase.getAddressBook(addressBookName);
        String key = firstName + " " + lastName;
        if (addressBook.containsKey(key)) {
            addressBook.put(key, newDetails);
            DataBase.updateDictionaries();
        } else {
            System.out.println("Contact not found in address book.");
        }
    }
    // Deletes a contact from the specified address book
    public void deleteRecord(String addressBookName, String firstName, String lastName) {
        Map<String, AddressBookDetails> addressBook = DataBase.getAddressBook(addressBookName);
        addressBook.remove(firstName + " " + lastName);
        DataBase.updateDictionaries();
    }

    //Searches by City Or state
    public List<AddressBookDetails> searchByCityOrState(String city, String state) {
        return DataBase.getAllAddressBooks().entrySet().stream()
                .flatMap(entry -> entry.getValue().values().stream())
                .filter(details -> details.getCity().equals(city) || details.getState().equals(state))
                .collect(Collectors.toList());
    }

    // Method to sort persons by name
    public List<AddressBookDetails> sortPersonsByName(String addressBookName) {
        return DataBase.getAddressBook(addressBookName).values().stream()
                .sorted(Comparator.comparing(AddressBookDetails::getFirstName)
                        .thenComparing(AddressBookDetails::getLastName))
                .collect(Collectors.toList());
    }
    // Method to sort persons by city
    public List<AddressBookDetails> sortPersonsByCity(String addressBookName) {
        return DataBase.getAddressBook(addressBookName).values().stream()
                .sorted(Comparator.comparing(AddressBookDetails::getCity))
                .collect(Collectors.toList());
    }

    // Method to sort persons by state
    public List<AddressBookDetails> sortPersonsByState(String addressBookName) {
        return DataBase.getAddressBook(addressBookName).values().stream()
                .sorted(Comparator.comparing(AddressBookDetails::getState))
                .collect(Collectors.toList());
    }

    // Method to sort persons by zip
    public List<AddressBookDetails> sortPersonsByZip(String addressBookName) {
        return DataBase.getAddressBook(addressBookName).values().stream()
                .sorted(Comparator.comparing(AddressBookDetails::getZipNo))
                .collect(Collectors.toList());
    }



}
