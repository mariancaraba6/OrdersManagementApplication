package Model;

public class Clients {
    private int clientId;
    private String clientName;
    private String address;
    private String email;
    private int age;

    public Clients() {

    }

    public Clients(int clientId, String clientName, String address, String email, int age) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.address = address;
        this.email = email;
        this.age = age;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Clients{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
