package AddressBook;

import java.util.Map;

public class AddressBookService {
    // Making First Name as key and other contact details as value
    Map<String, AddressBookDetails> dtoMap = DataBase.dtoMap;
    public void addData(AddressBookDetails dto){
        DataBase.dtoMap.put(dto.getFirstName(), dto);
    }
}