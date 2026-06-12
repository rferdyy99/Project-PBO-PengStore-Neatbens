-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 17 Jun 2025 pada 21.45
-- Versi server: 10.6.7-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `penjualanps`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `tanggal masuk` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_login`
--

CREATE TABLE `data_login` (
  `id` int(20) NOT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nomertelepon` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT 'Customer'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_login`
--

INSERT INTO `data_login` (`id`, `fullname`, `email`, `password`, `nomertelepon`, `role`) VALUES
(1, 'ferdy', 'ferdy@adm.com', 'ferdy', '081', 'admin'),
(2, 'ferdy', 'ferdy@cust.com', 'ferdy', '123', 'customer'),
(3, 'a', 'a', 'a', '1', 'customer');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kaset`
--

CREATE TABLE `kaset` (
  `id` int(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `harga` int(20) NOT NULL,
  `stok` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kaset`
--

INSERT INTO `kaset` (`id`, `nama`, `harga`, `stok`) VALUES
(1, 'tekken', 10000, 10),
(2, 'tsubasa', 20000, 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `laporan_keuangan`
--

CREATE TABLE `laporan_keuangan` (
  `id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(255) NOT NULL,
  `pemasukan` double NOT NULL,
  `pengeluaran` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemesanan`
--

CREATE TABLE `pemesanan` (
  `id_barang` int(11) NOT NULL,
  `nama_barang` varchar(255) NOT NULL,
  `stok` int(11) DEFAULT 0,
  `harga_beli` decimal(10,2) DEFAULT 0.00,
  `harga_jual` decimal(10,2) NOT NULL,
  `supplier` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pemesanan`
--

INSERT INTO `pemesanan` (`id_barang`, `nama_barang`, `stok`, `harga_beli`, `harga_jual`, `supplier`) VALUES
(1, 'FC 25', 0, 300.00, 500.00, 'MaestroGaming'),
(3, 'Tekken 7', 20, 300.00, 500.00, 'MaestroGaming'),
(4, 'Captain Tsubasa', 10, 300.00, 600.00, 'Bimagame'),
(5, 'DVC 3', 15, 300.00, 500.00, 'Bimagame'),
(6, 'Call of duty', 20, 300.00, 500.00, 'Gamingshop'),
(7, 'Wukong', 15, 200.00, 400.00, 'Gamingshop');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `id` int(11) NOT NULL,
  `nama_game` varchar(100) DEFAULT NULL,
  `harga` int(50) DEFAULT NULL,
  `nama_pembeli` varchar(100) DEFAULT NULL,
  `alamat` varchar(200) DEFAULT NULL,
  `metode_pembayaran` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`id`, `nama_game`, `harga`, `nama_pembeli`, `alamat`, `metode_pembayaran`, `status`) VALUES
(40, 'FC 25', 500000, 'd', 'a', 'qris', 'menunggu pembayaran'),
(41, 'FC 25', 500000, 'a', 'a', 'qris', 'menunggu pembayaran'),
(42, 'FC 25', 500000, 's', 's', 'qris', 'menunggu pembayaran'),
(43, 'FC 25', 500000, 'b', 'b', 'qris', 'menunggu pembayaran'),
(44, 'FC 25', 500000, 'ferdy', 'surabaya', 'qris', 'menunggu pembayaran');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesanan`
--

CREATE TABLE `pesanan` (
  `id_pesanan` int(20) NOT NULL,
  `nama_game` varchar(100) NOT NULL,
  `nama_pembeli` varchar(100) NOT NULL,
  `alamat_pengiriman` varchar(150) NOT NULL,
  `status_pembelian` varchar(50) NOT NULL DEFAULT 'Menunggu pembayaran'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `data_login`
--
ALTER TABLE `data_login`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `kaset`
--
ALTER TABLE `kaset`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `laporan_keuangan`
--
ALTER TABLE `laporan_keuangan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`id_barang`),
  ADD UNIQUE KEY `nama_barang` (`nama_barang`);

--
-- Indeks untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `data_login`
--
ALTER TABLE `data_login`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `kaset`
--
ALTER TABLE `kaset`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `pemesanan`
--
ALTER TABLE `pemesanan`
  MODIFY `id_barang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
