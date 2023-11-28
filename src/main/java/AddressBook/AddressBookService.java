package AddressBook;

import java.util.Map;

public class AddressBookService {
    // Adds a new contact to the specified address book
    public void addData(String addressBookName, AddressBookDetails dto) {
        Map<String, AddressBookDetails> addressBook = DataBase.getAddressBook(addressBookName);
        addressBook.put(dto.getFirstName() + " " + dto.getLastName(), dto);
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
