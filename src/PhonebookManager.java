/**
 * Manages the phonebook as a singly linked list.
 */
public class PhonebookManager {
    private ListNode head;

    public PhonebookManager() {
        head = null;
    }

    /**
     * Adds an entry to the phonebook.
     * 
     * @param name        the name of the person
     * @param address     the address of the person
     * @param city        the city of the person
     * @param phoneNumber the phone number of the person
     */
    public void addEntry(String name, String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(name, address, city, phoneNumber);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Prints the phonebook entries in a formatted manner.
     */
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.println("Name: " + current.name + ", Address: " + current.address + 
                               ", City: " + current.city + ", Phone Number: " + current.phoneNumber);
            current = current.next;
        }
    }

    /**
     * Sorts the phonebook entries alphabetically by name.
     */
    public void sortEntries() {
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped = true;
        while (swapped) {
            swapped = false;
            ListNode current = head;
            ListNode previous = null;

            while (current.next != null) {
                if (current.name.compareTo(current.next.name) > 0) {
                    ListNode temp = current.next;
                    current.next = temp.next;
                    temp.next = current;

                    if (previous == null) {
                        head = temp;
                    } else {
                        previous.next = temp;
                    }

                    swapped = true;
                    previous = temp;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        }
    }

    /**
     * Modifies an entry in the phonebook.
     * 
     * @param oldName     the name of the person to be modified
     * @param newName     the new name of the person
     * @param newAddress  the new address of the person
     * @param newCity     the new city of the person
     * @param newPhoneNumber the new phone number of the person
     */
    public void modifyEntry(String oldName, String newName, String newAddress, String newCity, String newPhoneNumber) {
        ListNode current = head;
        while (current != null) {
            if (current.name.equals(oldName)) {
                current.name = newName;
                current.address = newAddress;
                current.city = newCity;
                current.phoneNumber = newPhoneNumber;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Deletes an entry from the phonebook.
     * 
     * @param name the name of the person to be deleted
     */
    public void deleteEntry(String name) {
        if (head == null) {
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    /**
     * Moves an entry from Bellingham to Seattle phonebook.
     * 
     * @param name the name of the person to be moved
     */
    public void moveEntry(String name) {
        ListNode current = head;
        while (current != null) {
            if (current.name.equals(name) && current.city.equals("Bellingham")) {
                current.city = "Seattle";
                return;
            }
            current = current.next;
        }
    }
}
