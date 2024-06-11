import java.util.*;

class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phone);
    }

    public void printSortedPhoneBook() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        entries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Пример добавления контактов
        phoneBook.addContact("Alice", "123-456-7890");
        phoneBook.addContact("Bob", "987-654-3210");
        phoneBook.addContact("Alice", "234-567-8901");
        phoneBook.addContact("Charlie", "345-678-9012");
        phoneBook.addContact("Alice", "345-678-9012");
        phoneBook.addContact("Bob", "111-222-3333");

        // Вывод отсортированной телефонной книги
        phoneBook.printSortedPhoneBook();
    }
}
