/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ferdy
 */ 
import java.math.BigDecimal; // Untuk menyimpan harga dengan presisi yang baik

public class GameItem {

    // 1. Variabel Anggota (Fields)
    // Ini adalah tempat kita menyimpan semua informasi tentang satu game.
    // Kita buat 'private' agar nilainya tidak bisa diubah sembarangan dari luar kelas ini.
    private int id;                 // Nomor ID unik game dari database
    private String nama;            // Nama game yang akan ditampilkan
    private BigDecimal hargab;
    private BigDecimal hargaj;        // Harga jual game (menggunakan BigDecimal untuk uang)
    private String namaFileGambar;  // Nama file untuk gambar sampul (misal: "fc25.png")
    private int stok;               // Jumlah stok game saat ini

    // 2. Konstruktor (Constructor)
    // Ini adalah "resep" untuk membuat objek GameItem baru.
    // Saat kita mau buat GameItem baru, kita harus kasih semua informasi ini.
    public GameItem(int idGame, String namaGame, BigDecimal hargabeliGame, BigDecimal hargajualGame, String fileGambar, int jumlahStok) {
        this.id = idGame;                 // 'this.id' merujuk ke variabel 'id' milik kelas GameItem ini.
                                          // 'idGame' adalah nilai yang kita masukkan saat membuat objek.
        this.nama = namaGame;
        this.hargab = hargabeliGame;
        this.hargaj = hargajualGame;
        this.namaFileGambar = fileGambar;
        this.stok = jumlahStok;
    }

    // 3. Metode Getter (untuk mengambil nilai)
    // Karena variabel di atas private, kita butuh cara untuk melihat nilainya dari luar.
    // Metode getter inilah caranya.

    public int getId() {
        return id; // Mengembalikan nilai ID game
    }

    public String getNama() {
        return nama; // Mengembalikan nama game
    }

    public BigDecimal getHargab() {
        return hargab; // Mengembalikan harga game
    }

    public BigDecimal getHargaj() {
        return hargaj; // Mengembalikan harga game
    }
    public String getNamaFileGambar() {
        return namaFileGambar; // Mengembalikan nama file gambar
    }

    public int getStok() {
        return stok; // Mengembalikan jumlah stok
    }

    // 4. Metode toString() - Ini PENTING untuk ComboBox!
    // JComboBox akan otomatis menggunakan metode ini untuk menampilkan teks
    // untuk setiap item di dalam daftar pilihannya.
    @Override // Ini tanda bahwa kita mengganti metode toString() standar
    public String toString() {
        // Kita ingin ComboBox menampilkan nama game diikuti jumlah stoknya
        return this.nama + " (Stok: " + this.stok + ")";
        // Contoh hasilnya: "FC 25 (Stok: 10)"
    }
}
