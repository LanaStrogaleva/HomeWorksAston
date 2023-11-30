import java.util.*;

public class PhoneBook {
    HashMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
        } else {
            HashSet<String> phonesSet = new HashSet<>(Arrays.asList(phone));
            phoneBook.put(name, phonesSet);
        }
    }

    public HashSet<String> get(String name) {
        return phoneBook.get(name);
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneBook=" + phoneBook +
                '}';
    }


}
