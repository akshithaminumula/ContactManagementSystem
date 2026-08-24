package contactmanagementsystem;

	import java.util.Scanner;

	public class Main {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);
	        ContactManager manager = new ContactManager();

	        while (true) {

	            System.out.println("\n===== Contact Management System =====");
	            System.out.println("1. Add Personal Contact");
	            System.out.println("2. Add Business Contact");
	            System.out.println("3. View Contacts");
	            System.out.println("4. Search Contact");
	            System.out.println("5. Update Contact");
	            System.out.println("6. Delete Contact");
	            System.out.println("7. Exit");

	            System.out.print("Enter Choice: ");

	            int choice = sc.nextInt();
	            sc.nextLine();

	            try {

	                switch (choice) {

	                    case 1:

	                        System.out.print("Name: ");
	                        String pname = sc.nextLine();

	                        System.out.print("Phone: ");
	                        String pphone = sc.nextLine();

	                        System.out.print("Email: ");
	                        String pemail = sc.nextLine();

	                        System.out.print("City: ");
	                        String pcity = sc.nextLine();

	                        System.out.print("State: ");
	                        String pstate = sc.nextLine();

	                        System.out.print("Relation: ");
	                        String relation = sc.nextLine();

	                        manager.addContact(
	                                new PersonalContact(
	                                        pname,
	                                        pphone,
	                                        pemail,
	                                        new Address(pcity, pstate),
	                                        relation));

	                        break;

	                    case 2:

	                        System.out.print("Name: ");
	                        String bname = sc.nextLine();

	                        System.out.print("Phone: ");
	                        String bphone = sc.nextLine();

	                        System.out.print("Email: ");
	                        String bemail = sc.nextLine();

	                        System.out.print("City: ");
	                        String bcity = sc.nextLine();

	                        System.out.print("State: ");
	                        String bstate = sc.nextLine();

	                        System.out.print("Company: ");
	                        String company = sc.nextLine();

	                        manager.addContact(
	                                new BusinessContact(
	                                        bname,
	                                        bphone,
	                                        bemail,
	                                        new Address(bcity, bstate),
	                                        company));

	                        break;

	                    case 3:
	                        manager.viewContacts();
	                        break;

	                    case 4:
	                        System.out.print("Enter Name: ");
	                        manager.searchContact(sc.nextLine());
	                        break;

	                    case 5:
	                        System.out.print("Enter Name: ");
	                        manager.updateContact(sc.nextLine());
	                        break;

	                    case 6:
	                        System.out.print("Enter Name: ");
	                        manager.deleteContact(sc.nextLine());
	                        break;

	                    case 7:
	                        System.out.println("Thank You!");
	                        return;

	                    default:
	                        System.out.println("Invalid Choice.");
	                }

	            } catch (DuplicateContactException e) {

	                System.out.println("Error: " + e.getMessage());

	            } catch (InvalidContactException e) {

	                System.out.println("Error: " + e.getMessage());
	            }
	        }
	    }
	}

