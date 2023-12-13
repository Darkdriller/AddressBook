package AddressBook;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public void loadFromCSV(String addressBookName, String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : records) {
                AddressBookDetails contact = new AddressBookDetails(
                        record.get("FirstName"),
                        record.get("LastName"),
                        record.get("Address"),
                        record.get("City"),
                        record.get("State"),
                        record.get("Zip"),
                        record.get("Phone"),
                        record.get("Email"));
                DataBase.getAddressBook(addressBookName).put(contact.getFirstName() + " " + contact.getLastName(), contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveToCSV(String addressBookName, String filePath) {
        List<AddressBookDetails> contacts = new ArrayList<>(DataBase.getAddressBook(addressBookName).values());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("FirstName", "LastName", "Address", "City", "State", "Zip", "Phone", "Email"))) {
            for (AddressBookDetails contact : contacts) {
                csvPrinter.printRecord(contact.getFirstName(), contact.getLastName(),
                        contact.getAddress(), contact.getCity(),
                        contact.getState(), contact.getZipNo(),
                        contact.getMobileNo(), contact.getEmailId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
