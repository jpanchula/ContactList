import java.util.ArrayList;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person p) {
        contacts.add(p);
    }

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    // 0 = sort by first name, 1 = sort by last name, 2 = sort by phone number
    public void sort(int sortBy) {

    }
}
