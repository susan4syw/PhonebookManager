/**
 * Test class to demonstrate the functionality of the PhonebookManager.
 */
public class TestClass {
    public static void main(String[] args) {
        PhonebookManager manager = new PhonebookManager();
        manager.addEntry("John Doe", "123 Maple St", "Bellingham", "123-456-7890");
        manager.addEntry("Jane Smith", "456 Oak St", "Seattle", "987-654-3210");
        manager.addEntry("Alice Johnson", "789 Pine St", "Bellingham", "555-555-5555");

        System.out.println("Phonebook Entries:");
        manager.printList();

        System.out.println("\nModifying John Doe's Entry:");
        manager.modifyEntry("John Doe", "John Doe", "123 Maple St", "Seattle", "123-456-7890");
        manager.printList();

        System.out.println("\nDeleting Jane Smith's Entry:");
        manager.deleteEntry("Jane Smith");
        manager.printList();

        System.out.println("\nSorting Phonebook Entries:");
        manager.sortEntries();
        manager.printList();

        System.out.println("\nMoving Alice Johnson to Seattle:");
        manager.moveEntry("Alice Johnson");
        manager.printList();
    }
}







