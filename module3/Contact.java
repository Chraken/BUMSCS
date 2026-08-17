public class Contact {
    private String name;
    private String phone;
    //constructor that takes both private values & initializes them
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    //getter for name
    public String getName() {
    return name;
    }
    //getter for phone
    public String getPhone() {
        return phone;
    }
    //string representation of the contact
    public String toString() {
        return name + " | " + phone;
    }
}