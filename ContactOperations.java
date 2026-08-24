package contactmanagementsystem;

public interface ContactOperations {
	void addContact(Contact contact)
            throws DuplicateContactException, InvalidContactException;

    void viewContacts();

    void searchContact(String name);

    void updateContact(String name)
            throws InvalidContactException;

    void deleteContact(String name);
}
