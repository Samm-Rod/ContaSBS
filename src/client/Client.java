
package client;

import java.util.Date;

public  class Client {
    private String name;
    private String contact;
    private String email;
    private String address;
    private String salary;
    private int numPeop;
    private Date timestamp;

    private static int counter = 1;

    public Client(String name, String contact, String email, String address, String salary) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.numPeop = Client.counter;
        this.timestamp = new Date(); // TIMESTAMP
        Client.counter += 1;
    }

    public Client() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public int getNumPeop() {
        return numPeop;
    }

    public void setNumPeop(int numPeop) {
        this.numPeop = numPeop;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                ", numPeop=" + numPeop +
                ", timestamp=" + timestamp +
                '}';
    }
}
