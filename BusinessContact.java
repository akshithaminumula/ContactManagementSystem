package contactmanagementsystem;

public class BusinessContact extends Contact{
	 private String company;

	    public BusinessContact(String name,
	                           String phone,
	                           String email,
	                           Address address,
	                           String company) {

	        super(name, phone, email, address);
	        this.company = company;
	    }

	    @Override
	    public String toString() {
	        return super.toString() +
	                "\nCompany : " + company;
	    }
	    public String getCompany() {
	        return company;
	    }
}
