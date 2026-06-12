package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    // Detail koneksi ke database Anda
    private static final String DB_URL = "jdbc:mysql://localhost:3306/penjualanps";
    private static final String USER = "root";
    private static final String PASS = "";

    // Constructor dibuat private agar tidak bisa dibuat objeknya
    private Koneksi() {}

    /**
     * Method ini sekarang bertindak sebagai pabrik.
     * Ia selalu membuat dan mengembalikan koneksi BARU setiap kali dipanggil.
     */
    public static Connection getKoneksi() throws SQLException {
        // Hapus semua logika 'if (koneksi == null)' dan variabel statis
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}