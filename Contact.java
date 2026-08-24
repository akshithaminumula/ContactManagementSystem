package contactmanagementsystem;

public class Contact extends Person {

    private String email;
    private Address address;

    public Contact(String name, String phone, String email, Address address) {
        super(name, phone);
        this.email = email;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void displayInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Name    : " + name +
               "\nPhone   : " + phone +
               "\nEmail   : " + email +
               "\nAddress : " + address;
    }
}
