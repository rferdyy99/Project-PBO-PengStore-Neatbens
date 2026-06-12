package frame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferdy
 */
public class Customer {
    private String fullname;
    private String address;
    private String email;
    private String password; // Peringatan: Di aplikasi nyata, ini harusnya hash password
    private String nomerTelpon;
    private String role;
    public Customer(String fullname, String email,String password, String nomerTelpon, String role ) {
        this.fullname = fullname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.nomerTelpon = nomerTelpon ;
        this.role = role ;
    }

    // Getters
    public String getFullname() {
        return fullname;
    }
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
     public String getNomertelpon() {
        return nomerTelpon;
    }
      public String getRole() {
        return role;
    }

}
