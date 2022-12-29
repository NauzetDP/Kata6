package kata6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType (XmlAccessType.FIELD)
public class User {
        
    private int id;
    private String name;
    private String username;

    public Address getAddress() {
        return address;
    }
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
    
    public User(int id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }
    
    public User() {
        
    }
    
    @Override
    public String toString() {
        return "Id:" + Integer.toString(id) + ", Nombre:" + name + ", Nombre de usuario:" + username +
               ", Email:" + email + ", Dirección:" + address + ", Teléfono:" + phone + ", Página web:" + website +
               ", Compañía:" + company;
    }
}