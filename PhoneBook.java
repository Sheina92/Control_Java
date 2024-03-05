import java.util.*;

public class PhoneBook {
    private HashMap<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }

    public void printContacts() {
        List<Map.Entry<String, List<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, List<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        
        System.out.println("Телефонная книга:");

        phoneBook.addContact("Ксения", "898989898");
        phoneBook.addContact("Максим", "121212121");
        phoneBook.addContact("Ольга", "131313131");
        phoneBook.addContact("Ксения", "242424242");
        phoneBook.addContact("Максим", "343434343");
        phoneBook.addContact("Альбина", "979797979");
        phoneBook.addContact("Максим", "232323232");

        phoneBook.printContacts();
    }
}
