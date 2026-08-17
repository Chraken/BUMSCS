import java.util.*; 

public class ContactManager { 

    public static void main(String[] args) { 

        HashMap<String, Contact> contacts = new HashMap<>(); 

        // Step 4: Add contacts (Pass full names to match keys)
        contacts.put("Alice Lovelace", new Contact("Alice Lovelace", "123-456-7890"));
        contacts.put("Joe Lovelace", new Contact("Joe Lovelace", "123-456-7892"));
        contacts.put("Bob Builder", new Contact("Bob Builder", "123-456-7893"));
        contacts.put("Charlie Brown", new Contact("Charlie Brown", "123-456-7894"));
        contacts.put("Daisy Ridley", new Contact("Daisy Ridley", "123-456-7895"));

        // Step 5: Look up a contact (Existing)
        Contact found = contacts.get("Alice Lovelace");
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Contact not found.");
        }

        // Step 5: Look up a contact (Non-existing test)
        Contact missing = contacts.get("Grace Hopper");
        if (missing != null) {
            System.out.println("Found: " + missing);
        } else {
            System.out.println( "Test 2: Contact not found.");
        }

        // Step 6: Print sorted list
        System.out.println("\n=== All Contacts ===");
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        
        // Sorting using the required lambda expression from Step 6
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}