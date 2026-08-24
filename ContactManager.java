package contactmanagementsystem;

import java.sql.*;
import java.util.Scanner;

public class ContactManager implements ContactOperations {

    private void validatePhone(String phone) throws InvalidContactException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidContactException(
                    "Phone number must contain exactly 10 digits.");
        }
    }

    @Override
    public void addContact(Contact contact)
            throws DuplicateContactException, InvalidContactException {

        validatePhone(contact.getPhone());

        String sql = "INSERT INTO contacts(name, phone, email, city, state, type, relation_name, company) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, contact.getName());
            ps.setString(2, contact.getPhone());
            ps.setString(3, contact.getEmail());
            ps.setString(4, contact.getAddress().getCity());
            ps.setString(5, contact.getAddress().getState());

            if (contact instanceof PersonalContact) {
                ps.setString(6, "Personal");
                ps.setString(7, ((PersonalContact) contact).getRelation());
                ps.setString(8, null);
            } else if (contact instanceof BusinessContact) {
                ps.setString(6, "Business");
                ps.setString(7, null);
                ps.setString(8, ((BusinessContact) contact).getCompany());
            }

            ps.executeUpdate();
            System.out.println("Contact Saved Successfully.");

        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DuplicateContactException("Phone number already exists.");
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    @Override
    public void viewContacts() {
        String sql = "SELECT * FROM contacts";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("------------------------");
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Phone   : " + rs.getString("phone"));
                System.out.println("Email   : " + rs.getString("email"));
                System.out.println("City    : " + rs.getString("city"));
                System.out.println("State   : " + rs.getString("state"));
                System.out.println("Type    : " + rs.getString("type"));

                if ("Personal".equals(rs.getString("type"))) {
                    System.out.println("Relation: " + rs.getString("relation_name"));
                } else {
                    System.out.println("Company : " + rs.getString("company"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    @Override
    public void searchContact(String name) {
        String sql = "SELECT * FROM contacts WHERE name=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Email: " + rs.getString("email"));
            } else {
                System.out.println("Contact Not Found.");
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    @Override
    public void updateContact(String name) throws InvalidContactException {

        Scanner sc = new Scanner(System.in);

        System.out.print("New Phone: ");
        String phone = sc.nextLine();

        validatePhone(phone);

        System.out.print("New Email: ");
        String email = sc.nextLine();

        String sql = "UPDATE contacts SET phone=?, email=? WHERE name=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, phone);
            ps.setString(2, email);
            ps.setString(3, name);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Updated Successfully.");
            else
                System.out.println("Contact Not Found.");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteContact(String name) {

        String sql = "DELETE FROM contacts WHERE name=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Deleted Successfully.");
            else
                System.out.println("Contact Not Found.");

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}