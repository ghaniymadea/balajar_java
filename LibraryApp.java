package belajar_2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

class Buku {
    String id, judul, pengarang, kategori;
    int tahunTerbit;

    public Buku(String id, String judul, String pengarang, int tahunTerbit, String kategori) {
        this.id = id;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.kategori = kategori;
    }
}

class Peminjaman {
    String namaPeminjam, idBuku;
    LocalDate tanggalPinjam, tanggalKembali;

    public Peminjaman(String nama, LocalDate pinjam, LocalDate kembali, String idBuku) {
        this.namaPeminjam = nama;
        this.tanggalPinjam = pinjam;
        this.tanggalKembali = kembali;
        this.idBuku = idBuku;
    }
}

public class LibraryApp extends JFrame {
    ArrayList<Buku> daftarBuku = new ArrayList<>();
    ArrayList<Peminjaman> daftarPinjam = new ArrayList<>();
    DefaultTableModel bukuModel, pinjamModel;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public LibraryApp() {
        setTitle("Aplikasi Perpustakaan");
        setSize(800, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        // ====================== Tab Buku ======================
        JPanel bukuPanel = new JPanel(new BorderLayout());
        JPanel inputBuku = new JPanel(new GridLayout(6, 2, 5, 5));
        JTextField idField = new JTextField();
        JTextField judulField = new JTextField();
        JTextField pengarangField = new JTextField();
        JTextField tahunField = new JTextField();
        JTextField kategoriField = new JTextField();

        inputBuku.add(new JLabel("ID Buku:"));
        inputBuku.add(idField);
        inputBuku.add(new JLabel("Judul:"));
        inputBuku.add(judulField);
        inputBuku.add(new JLabel("Pengarang:"));
        inputBuku.add(pengarangField);
        inputBuku.add(new JLabel("Tahun Terbit:"));
        inputBuku.add(tahunField);
        inputBuku.add(new JLabel("Kategori:"));
        inputBuku.add(kategoriField);

        JButton tambahBuku = new JButton("Tambah Buku");
        inputBuku.add(tambahBuku);

        bukuModel = new DefaultTableModel(new String[]{"ID", "Judul", "Pengarang", "Tahun", "Kategori"}, 0);
        JTable bukuTable = new JTable(bukuModel);

        tambahBuku.addActionListener(e -> {
            String id = idField.getText().trim();
            String judul = judulField.getText().trim();
            String pengarang = pengarangField.getText().trim();
            String tahunStr = tahunField.getText().trim();
            String kategori = kategoriField.getText().trim();

            if (id.isEmpty() || judul.isEmpty() || pengarang.isEmpty() || tahunStr.isEmpty() || kategori.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
                return;
            }

            int tahun;
            try {
                tahun = Integer.parseInt(tahunStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Tahun harus berupa angka.");
                return;
            }

            Buku buku = new Buku(id, judul, pengarang, tahun, kategori);
            daftarBuku.add(buku);
            bukuModel.addRow(new Object[]{id, judul, pengarang, tahun, kategori});

            idField.setText(""); judulField.setText(""); pengarangField.setText(""); tahunField.setText(""); kategoriField.setText("");
        });

        bukuPanel.add(inputBuku, BorderLayout.NORTH);
        bukuPanel.add(new JScrollPane(bukuTable), BorderLayout.CENTER);
        tabs.add("Data Buku", bukuPanel);

        // ====================== Tab Peminjaman ======================
        JPanel pinjamPanel = new JPanel(new BorderLayout());
        JPanel inputPinjam = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField namaField = new JTextField();
        JTextField pinjamField = new JTextField();
        JTextField kembaliField = new JTextField();
        JTextField idBukuPinjamField = new JTextField();

        inputPinjam.add(new JLabel("Nama Peminjam:"));
        inputPinjam.add(namaField);
        inputPinjam.add(new JLabel("Tanggal Pinjam:"));
        inputPinjam.add(pinjamField);
        inputPinjam.add(new JLabel("Tanggal Kembali:"));
        inputPinjam.add(kembaliField);
        inputPinjam.add(new JLabel("ID Buku:"));
        inputPinjam.add(idBukuPinjamField);

        JButton tambahPinjam = new JButton("Tambah Peminjaman");
        inputPinjam.add(tambahPinjam);

        pinjamModel = new DefaultTableModel(new String[]{"Nama", "Pinjam", "Kembali", "ID Buku"}, 0);
        JTable pinjamTable = new JTable(pinjamModel);

        tambahPinjam.addActionListener(e -> {
            String nama = namaField.getText().trim();
            String pinjamStr = pinjamField.getText().trim();
            String kembaliStr = kembaliField.getText().trim();
            String idBuku = idBukuPinjamField.getText().trim();

            if (nama.isEmpty() || pinjamStr.isEmpty() || kembaliStr.isEmpty() || idBuku.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi.");
                return;
            }

            LocalDate tglPinjam, tglKembali;
            try {
                tglPinjam = LocalDate.parse(pinjamStr, formatter);
                tglKembali = LocalDate.parse(kembaliStr, formatter);
                if (tglKembali.isBefore(tglPinjam)) {
                    JOptionPane.showMessageDialog(this, "Tanggal kembali tidak boleh sebelum tanggal pinjam.");
                    return;
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Format tanggal salah. Gunakan yyyy-MM-dd.");
                return;
            }

            boolean idValid = daftarBuku.stream().anyMatch(b -> b.id.equals(idBuku));
            if (!idValid) {
                JOptionPane.showMessageDialog(this, "ID Buku tidak ditemukan dalam daftar.");
                return;
            }

            Peminjaman peminjaman = new Peminjaman(nama, tglPinjam, tglKembali, idBuku);
            daftarPinjam.add(peminjaman);
            pinjamModel.addRow(new Object[]{nama, tglPinjam.toString(), tglKembali.toString(), idBuku});

            namaField.setText(""); pinjamField.setText(""); kembaliField.setText(""); idBukuPinjamField.setText("");
        });

        pinjamPanel.add(inputPinjam, BorderLayout.NORTH);
        pinjamPanel.add(new JScrollPane(pinjamTable), BorderLayout.CENTER);
        tabs.add("Data Peminjaman", pinjamPanel);

        add(tabs);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryApp());
    }
}
