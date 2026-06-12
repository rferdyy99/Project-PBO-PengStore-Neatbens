package frame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import frame.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.List;      // 
import java.sql.Statement;
/**
 *
 * @author ferdy
 */
public class CustomerService {
     private static CustomerService instance;
    private CustomerService() {}
    public static synchronized CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService();
        }
        return instance;
    }
 
    // Menggunakan parameter baru sesuai kelas Customer Anda
    public boolean registerCustomer(String fullname, String email, String password, String nomerTelpon ) {
        // UBAH: Sesuaikan nama tabel dan kolom
        String sql = "INSERT INTO data_login(fullname, email, password, nomertelepon, role ) VALUES(?,?,?,?,?)";
 try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fullname);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, nomerTelpon);
            pstmt.setString(5, "customer" ); 
            
            
            
            
            pstmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Gagal registrasi: " + e.getMessage());
            return false;
        }
    }

    // Login sekarang menggunakan email
    public Customer validateLogin(String email, String password) {
        // UBAH: Sesuaikan nama tabel dan kolom
        String sql = "SELECT * FROM data_login WHERE email = ?";
        
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String storedPassword = rs.getString("password");
                if (password.equals(storedPassword)) {
                    // UBAH: Ambil data dari kolom yang benar
                    return new Customer(
                        rs.getString("fullname"), 
                        rs.getString("email"), 
                        storedPassword, // password
                        rs.getString("nomertelepon"),
                        rs.getString("role")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error saat validasi login: " + e.getMessage());
        }
        return null; // Login gagal
    }
public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        String sql = "SELECT * FROM data_login"; // Ambil semua kolom

        try (Connection conn = Koneksi.getKoneksi();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Buat objek Customer untuk setiap baris data
                Customer customer = new Customer(
                    rs.getString("fullname"),
                    rs.getString("email"),
                    "", // Password dikosongkan untuk keamanan, tidak perlu ditampilkan
                    rs.getString("nomertelepon"),
                    rs.getString("role")
                );
                customerList.add(customer); // Tambahkan ke list
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil semua data customer: " + e.getMessage());
        }
        return customerList;
    }
    public boolean deleteCustomer(String email) {
        String sql = "DELETE FROM data_login WHERE email = ?";
        
        try (Connection conn = Koneksi.getKoneksi();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            
            int rowsAffected = pstmt.executeUpdate();
            
            // Jika ada baris yang terpengaruh (berarti data terhapus), kembalikan true
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Gagal menghapus customer: " + e.getMessage());
            return false;
        }
    }
}



