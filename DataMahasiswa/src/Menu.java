import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Menu extends JFrame {
    public static void main(String[] args) {
        // Membuat instance dari kelas Menu
        Menu window = new Menu();

        // Mengatur ukuran window
        window.setSize(600, 600);

        // Menempatkan window di tengah layar
        window.setLocationRelativeTo(null);

        // Mengatur panel utama sebagai konten window
        window.setContentPane(window.mainPanel);

        // Mengatur warna latar belakang
        window.getContentPane().setBackground(new Color(118, 171, 174));

        // Menampilkan window
        window.setVisible(true);

        // Mengatur operasi default ketika window ditutup
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Indeks baris yang dipilih pada tabel
    private int selectedIndex = -1;

    // ArrayList untuk menyimpan data Mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;

    private Database database;

    // Komponen GUI
    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> jurusanCombobox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel jurusanLabel;
    private JRadioButton lakiRadio;
    private JRadioButton perempuanRadio;
    private ButtonGroup jenkelButtonGroup;


    // Konstruktor
    public Menu() {
        database = new Database();

        // Inisialisasi ButtonGroup untuk radio button jurusan
        jenkelButtonGroup = new ButtonGroup();

        lakiRadio.setBackground(new Color(118, 171, 174));
        perempuanRadio.setBackground(new Color(118, 171, 174));
        // Menambahkan radio button ke dalam ButtonGroup
        jenkelButtonGroup.add(lakiRadio);
        jenkelButtonGroup.add(perempuanRadio);

        // Mengatur model tabel
        mahasiswaTable.setModel(setTable());

        // Mengatur font untuk judul
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // Mengatur opsi pada combo box jurusan data
        String[] jurusanData = {"","Computer Science","Electrical Engineering","Mechanical Engineering","Civil Engineering","Chemical Engineering","Biomedical Engineering","Physics","Mathematics","Statistics","Biology","Chemistry","Environmental Science","Geology","Astronomy","Psychology","Sociology","Economics","Political Science","History","Philosophy","English Literature","Foreign Languages","Communication Studies","Art History","Music","Theater","Architecture","Urban Planning","Anthropology","Geography","Criminal Justice","Public Health","Nursing","Business Administration","Marketing","Finance","Accounting","Human Resource Management","Hospitality Management"};
        jurusanCombobox.setModel(new DefaultComboBoxModel<>(jurusanData));

        // Menyembunyikan tombol delete
        deleteButton.setVisible(false);

        // Event listener untuk tombol "Add/Update"
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // periksa form agar tidak ada data kosong
                if (!nimField.getText().isEmpty() && !namaField.getText().isEmpty() &&
                        !jurusanCombobox.getSelectedItem().toString().isEmpty() &&
                        !getSelectedJenkel().isEmpty()) {
                    if (selectedIndex == -1) {
                        insertData();
                    } else {
                        updateData();
                    }
                } else { // kalau data kosong
                    JOptionPane.showMessageDialog(null, "Maaf data input tidak boleh ada yang kosong","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Event listener untuk tombol "Delete"
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (selectedIndex >= 0) {
                    // Konfirmasi penghapusan
                    int option = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        deleteData();
                    }
                }
            }
        });

        // Event listener untuk tombol "Cancel"
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        // Event listener saat baris tabel diklik
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = mahasiswaTable.getSelectedRow();
                // siman value textfield, radio dan  como box
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 3).toString();
                String selectedJurusan = mahasiswaTable.getModel().getValueAt(selectedIndex, 4).toString();


                // ubah isi textfield, radio dan  como box
                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                setSelectedJenkel(selectedJenisKelamin);
                jurusanCombobox.setSelectedItem(selectedJurusan);

                //ubah add button menjadi update
                addUpdateButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });
    }

    // Method untuk mengatur radio button jenkel yang terpilih
    private void setSelectedJenkel(String selectedJurusan) {
        if (selectedJurusan.equals("Laki-laki")) {
            lakiRadio.setSelected(true);
        } else if (selectedJurusan.equals("Perempuan")) {
            perempuanRadio.setSelected(true);
        }
    }

    // Method untuk mendapatkan jenkel yang dipilih
    private String getSelectedJenkel() {
        if (lakiRadio.isSelected()) {
            return "Laki-laki";
        } else if (perempuanRadio.isSelected()) {
            return "Perempuan";
        } else {
            return "";
        }
    }

    // Method untuk mengatur model tabel
    public final DefaultTableModel setTable() {
        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Jurusan"};
        DefaultTableModel temp = new DefaultTableModel(null, column);
        try {
            // isi tabel dengan listMahasiswa
            ResultSet resultSet = database.selectQuery("Select * from mahasiswa");
            int i = 1;
            while (resultSet.next()){
                Object[] row = new Object[5];
                row[0] = i;
                i++;
                row[1] = resultSet.getString("NIM");
                row[2] = resultSet.getString("Nama");
                row[3] = resultSet.getString("JenisKelamin");
                row[4] =resultSet.getString("ProgramStudi");
                temp.addRow(row);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return temp;
    }

    // Method untuk menambah data
    public void insertData() {
        // ambil value dari textfield, radio dan combox
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jurusan = jurusanCombobox.getSelectedItem().toString();
        String jenisKelamin = getSelectedJenkel();

        // Cek apakah nim sudah ada dalam database
        if (isNimExist(nim)) {
            // Jika nim sudah ada, tampilkan pesan kesalahan
            JOptionPane.showMessageDialog(null, "NIM '"+ nim +"' sudah ada dalam database. Insert gagal.","Error",JOptionPane.ERROR_MESSAGE);
            return; // Keluar dari method insertData()
        }

        // Lakukan operasi insert
        String sql = "INSERT INTO mahasiswa VALUES (null,'" + nim + "','" + nama + "','" + jenisKelamin + "','" + jurusan + "');";
        database.crudQuery(sql);

        // update table
        mahasiswaTable.setModel(setTable());
        // bersihkan form
        clearForm();
        // feedback
        System.out.println("Insert Berhasil");
        JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
    }

    // Method untuk mengecek apakah nim sudah ada dalam database
    public boolean isNimExist(String nim) {
        // Lakukan query ke database untuk mencari nim
        String sql = "SELECT COUNT(*) FROM mahasiswa WHERE nim = '" + nim + "';";
        ResultSet rs = database.selectQuery(sql);
        try {
            // Jika hasil query mengembalikan baris lebih dari 0, artinya nim sudah ada
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Pastikan untuk menutup ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false; // Jika terjadi kesalahan, kembalikan false
    }


    // Method untuk memperbarui data
    // Method untuk memperbarui data berdasarkan ID
    public void updateData() {
        // Ambil ID dari baris yang dipilih di tabel
        int selectedRowIndex = mahasiswaTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(null, "Silakan pilih data yang ingin diupdate.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String id = mahasiswaTable.getModel().getValueAt(selectedRowIndex, 0).toString(); // Di sini diasumsikan ID berada pada kolom pertama (indeks 0)

        // Ambil data dari textfield, radio, dan combobox
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jurusan = jurusanCombobox.getSelectedItem().toString();
        String jenisKelamin = getSelectedJenkel();

        // Lakukan pengecekan apakah NIM sudah ada di database selain pada baris yang sedang diupdate
        String queryCheckNIM = "SELECT COUNT(*) FROM mahasiswa WHERE NIM='" + nim + "' AND id != '" + id + "'";
        int count = database.getCount(queryCheckNIM);
        if (count > 0) {
            JOptionPane.showMessageDialog(null, "NIM telah digunakan untuk mahasiswa lain.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lakukan operasi update
        String sql = "UPDATE mahasiswa SET NIM='" + nim + "', Nama='" + nama + "', JenisKelamin='" + jenisKelamin + "', ProgramStudi='" + jurusan + "' WHERE id='" + id + "'";
        database.crudQuery(sql);

        // Update tabel
        mahasiswaTable.setModel(setTable());

        // Bersihkan form
        clearForm();

        // Feedback
        System.out.println("Update Berhasil");
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah!");
    }



    // Method untuk menghapus data
    public void deleteData() {
        // Ambil ID dari baris yang dipilih di tabel
        int selectedRowIndex = mahasiswaTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(null, "Silakan pilih data yang ingin dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String id = mahasiswaTable.getModel().getValueAt(selectedRowIndex, 0).toString(); // Di sini diasumsikan ID berada pada kolom pertama (indeks 0)

        // Lakukan operasi penghapusan
        String sql = "DELETE FROM mahasiswa WHERE id='" + id + "'";
        database.crudQuery(sql);

        // Update tabel setelah penghapusan
        mahasiswaTable.setModel(setTable());

        // Bersihkan form
        clearForm();

        // Feedback
        System.out.println("Delete Berhasil");
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
    }


    // Method untuk mengosongkan form
    public void clearForm() {
        // ksoongkan semua textfield, radio dan  combox
        namaField.setText("");
        nimField.setText("");
        jurusanCombobox.setSelectedItem("");
        // ubah button update jadi add
        addUpdateButton.setText("Add");
        //sembunyikan delete
        deleteButton.setVisible(false);
        // ubah selection index menjadi -1 (no selection)
        selectedIndex = -1;
        // clear pilihan yang di Rbutton
        jenkelButtonGroup.clearSelection();
    }
}
