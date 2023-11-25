package AddressBook;

import java.util.Map;

public class AddressBookService {
    // Making First Name and last name as key and other contact details as value
    Map<String, AddressBookDetails> dtoMap = DataBase.dtoMap;
    public void addData(AddressBookDetails dto){
        DataBase.dtoMap.put(dto.getFirstName() + dto.getLastName() , dto);
    }

    public void updateAddressBook(AddressBookDetails addressBookDeets) {
        Map<String, AddressBookDetails> dtoMap = DataBase.dtoMap;
        if(dtoMap.containsKey(addressBookDeets.getFirstName())){
            DataBase.dtoMap.put(addressBookDeets.getFirstName() + addressBookDeets.getLastName(), addressBookDeets);
        } else
            addData(addressBookDeets);
    }

    public void deleteRecord(AddressBookDetails addressBookDTO) {
        if(DataBase.dtoMap.containsKey(addressBookDTO.getFirstName())){
            DataBase.dtoMap.remove(addressBookDTO.getFirstName());
            System.out.println(DataBase.dtoMap.size());
        } else
            System.out.println("No such Data Found!!");
    }
}