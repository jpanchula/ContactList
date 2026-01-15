public class Friend extends Person {
    private String address;

    public Friend(String firstName, String lastName, String phoneNumber, String address) {
        super(firstName, lastName, phoneNumber);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return super.toString() + " Address: " + address;
    }
}
