package AddressBook;

import java.util.Map;

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
        } else {
            System.out.println("Contact not found in address book.");
        }
    }
    // Deletes a contact from the specified address book
    public void deleteRecord(String addressBookName, String firstName, String lastName) {
        Map<String, AddressBookDetails> addressBook = DataBase.getAddressBook(addressBookName);
        addressBook.remove(firstName + " " + lastName);
    }

}
