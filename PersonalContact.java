package contactmanagementsystem;

public class PersonalContact extends Contact{
	private String relation;

    public PersonalContact(String name, String phone, String email,
                           Address address, String relation) {
        super(name, phone, email, address);
        this.relation = relation;
    }

    // Add this getter
    public String getRelation() {
        return relation;
    }

    @Override
    public String toString() {
        return super.toString() + "\nRelation: " + relation;
    }
}
