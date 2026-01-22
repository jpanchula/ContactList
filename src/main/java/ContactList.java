import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Asks the user for the type of contact to add and adds a new Person to contacts with entered attributes
    public void addContact() {
        // Initialize variables necessary for input
        Scanner s = new Scanner(System.in);
        int input = 0;
        String firstName;
        String lastName;
        String phoneNumber;

        // Ask the user what type of contact they are adding
        System.out.println("Please select a type of contact to add: ");
        System.out.println("1. Student");
        System.out.println("2. Friend");
        while (input < 1 || input > 2) {
            input = s.nextInt();
        }
        s.nextLine();
        System.out.println("Please fill in the following information.");
        System.out.println("First name: ");
        firstName = s.nextLine();
        System.out.println("Last name: ");
        lastName = s.nextLine();
        System.out.println("Phone number: ");
        phoneNumber = s.nextLine();
        if (input == 1) {
            System.out.println("Grade: ");
            Person p = new Student(firstName, lastName, phoneNumber, s.nextInt());
            contacts.add(p);
        }
        else {
            System.out.println("Address: ");
            Person p = new Friend(firstName, lastName, phoneNumber, s.nextLine());
            contacts.add(p);
        }
    }

    public void printContacts() {
        for (Person p : contacts) {
            System.out.println(p);
        }
    }

    // 0 = sort by first name, 1 = sort by last name, 2 = sort by phone number
    public void sort(int sortBy) {
        // Bubble sort nested loop
        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - 1 - i; j++) {
                // Variable to store lexicographic difference
                int compare = getCompare(sortBy, j);
                // If the lexicographic difference is positive
                if (compare > 0) {
                    // Swap the values at j and j + 1
                    Person temp = contacts.get(j + 1);
                    contacts.set(j + 1, contacts.get(j));
                    contacts.set(j, temp);
                }
            }
        }
    }

    // Get the lexicographic difference between two Strings depending on sortBy
    public int getCompare(int sortBy, int j) {
        // If sorting by first name
        if (sortBy == 0) {
            // Return the lexicographic difference between the first names
            return contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName());
        }
        // If sorting by last name
        else if (sortBy == 1) {
            // Return the lexicographic difference between the last names
            return contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName());
        }
        // If sorting by phone number
        else {
            // Return the lexicographic difference between the phone numbers
            return contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName());
        }
    }

    // Returns the first person found with the entered first name
    public Person searchByFirstName(String firstName) {
        for (Person p : contacts) {
            if (p.getFirstName().equals(firstName))
                return p;
        }
        return null;
    }

    // Returns the first person found with the entered last name
    public Person searchByLastName(String lastName) {
        for (Person p : contacts) {
            if (p.getLastName().equals(lastName))
                return p;
        }
        return null;
    }

    // Returns the first person found with the entered phone number
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber))
                return p;
        }
        return null;
    }

    // Lists all contacts of type Student
    public void listStudents() {
        for (Person p : contacts) {
            if (p instanceof Student)
                System.out.println(p);
        }
    }

    // Prints the menu options
    public void printMenuOptions() {
        System.out.println("Menu: ");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By Phone Number");
        System.out.println("0. Exit");
    }

    // Allows the user to interact with the contacts
    public void run() {
        Scanner s = new Scanner(System.in);
        // Loop until the user enters 0
        while (true) {
            // Get user input
            printMenuOptions();
            int input = s.nextInt();
            while (input < 0 || input > 8) {
                input = s.nextInt();
            }
            s.nextLine();
            switch (input) {
                // Add a contact
                case 1:
                    addContact();
                    break;
                // List by first name
                case 2:
                    // Sort by first name and print
                    sort(0);
                    printContacts();
                    break;
                // List by last name
                case 3:
                    // Sort by last name and print
                    sort(1);
                    printContacts();
                    break;
                // List by phone number
                case 4:
                    // Sort by phone number and print
                    sort(2);
                    printContacts();
                    break;
                // List only students
                case 5:
                    listStudents();
                    break;
                // Search by first name
                case 6:
                    // Get a name
                    System.out.println("Enter a name:");
                    String firstName = s.nextLine();
                    // Find the person
                    Person p1 = searchByFirstName(firstName);
                    // Display the person found
                    if (p1 == null)
                        System.out.println(firstName + " is not in the list.");
                    else
                        System.out.println(p1);
                    break;
                // Search by last name
                case 7:
                    // Get a name
                    System.out.println("Enter a name:");
                    String lastName = s.nextLine();
                    // Find the person
                    Person p2 = searchByLastName(lastName);
                    // Display the person found
                    if (p2 == null)
                        System.out.println(lastName + " is not in the list.");
                    else
                        System.out.println(p2);
                    break;
                // Search by phone number:
                case 8:
                    // Get a phone number
                    System.out.println("Enter a phone number:");
                    String phoneNumber = s.nextLine();
                    // Find the person
                    Person p3 = searchByPhoneNumber(phoneNumber);
                    // Display the person found
                    if (p3 == null)
                        System.out.println("#" + phoneNumber + " is not in the list.");
                    else
                        System.out.println(p3);
                    break;
                // Exit
                case 0:
                    return;
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        ContactList c = new ContactList();
        c.run();
    }
}
