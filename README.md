# README - TP2DPBO2024C2
Saya Mohammad Faridz Fathin mengerjakan TP2 dalam mata kuliah DPBO untuk keberkahanNya maka saya tidak akan melakukan kecurangan seperti yang telah dispesifikasikan
# Desain Program

## Gambaran Umum
Program ini adalah sebuah aplikasi desktop sederhana yang digunakan untuk mengelola data mahasiswa. Aplikasi ini dibangun menggunakan bahasa pemrograman Java dan antarmuka grafis Java Swing. Program ini memiliki fitur utama untuk menambah, mengubah, dan menghapus data mahasiswa pada database db_mahasiswa.

## Komponen-Komponen
- **Komponen GUI**: 
  - Kolom teks untuk memasukkan NIM mahasiswa dan nama.
  - Kotak combo untuk memilih jurusan mahasiswa.
  - Tombol radio untuk memilih jenis kelamin mahasiswa.
  - Tombol untuk menambahkan, memperbarui, dan menghapus catatan mahasiswa.
  - Tabel untuk menampilkan catatan mahasiswa yang ada.
- **Koneksi Database**: 
  - Program berinteraksi dengan database untuk menyimpan dan mengambil catatan mahasiswa.
- **Penanganan Acara**: 
  - Pendengar acara diimplementasikan untuk menangani interaksi pengguna seperti klik tombol dan pemilihan baris tabel.

## Teknologi yang Digunakan
- **Java Swing**: Digunakan untuk membangun antarmuka pengguna grafis.
- **JDBC (Java Database Connectivity)**: Digunakan untuk terhubung ke database dan berinteraksi dengannya.


## Kelas: Menu
- **Metode**:
  - `main(String[] args)`: Metode utama untuk memulai aplikasi.
  - `setTable()`: Menginisialisasi dan mengembalikan model tabel dengan catatan mahasiswa yang ada.
  - `insertData()`: Memasukkan catatan mahasiswa baru ke dalam database.
  - `updateData()`: Memperbarui catatan mahasiswa yang ada dalam database.
  - `deleteData()`: Menghapus catatan mahasiswa dari database.
  - `clearForm()`: Mengatur ulang semua kolom input dan kontrol pada formulir.

- **Pendengar Acara**:
  - `addUpdateButton ActionListener`: Menangani penambahan dan pembaruan catatan mahasiswa.
  - `deleteButton ActionListener`: Menangani penghapusan catatan mahasiswa.
  - `cancelButton ActionListener`: Menangani pengosongan kolom formulir.

## Kelas: Database
- **Metode**:
  - `selectQuery(String sql)`: Menjalankan kueri select pada database dan mengembalikan hasil set.
  - `crudQuery(String sql)`: Menjalankan kueri insert, update, atau delete pada database.

## Kelas: Mahasiswa
- Mewakili sebuah entitas mahasiswa dengan atribut seperti NIM, nama, jenis kelamin, dan jurusan.

Dokumentasi ini memberikan gambaran tentang desain program, alirannya, dan fungsionalitas kelas dan metode kunci. Untuk dokumentasi implementasi yang lebih rinci, lihat komentar di dalam kode sumber.

## Alur Program

1. **Memulai Aplikasi**:
   - Pengguna membuka aplikasi.
   - Jendela aplikasi ditampilkan dengan formulir untuk memasukkan data mahasiswa dan tabel untuk menampilkan data yang sudah ada.
   - Untuk add dan update data, tidak boleh ada data yang kosong.

2. **Tambah Data Mahasiswa**:
   - Pengguna mengisi formulir dengan NIM, nama, memilih jenis kelamin, dan jurusan mahasiswa.
   - Pengguna menekan tombol "Add/Update" untuk menambahkan data baru.
   - Mahasiswa yang diinput tidak boleh memiliki nim yang sama. 
   - Data mahasiswa ditambahkan ke database MySQL.
   - Tabel diperbarui untuk menampilkan data yang baru ditambahkan.

3. **Ubah Data Mahasiswa**:
   - Pengguna mengklik baris data pada tabel yang ingin diubah.
   - Data yang dipilih akan muncul di formulir untuk diedit.
   - Pengguna mengubah data yang diinginkan pada formulir.
   - Nim mahasiswa baru yang diupdate tidak boleh memiliki nim yang sama dengan yang sudah ada dengan yang lain. 
   - Pengguna menekan tombol "Add/Update" untuk menyimpan perubahan.
   - Data mahasiswa diupdate di database MySQL.
   - Tabel diperbarui untuk menampilkan data yang telah diubah.

4. **Hapus Data Mahasiswa**:
   - Pengguna mengklik baris data pada tabel yang ingin dihapus.
   - Pengguna menekan tombol "Delete" untuk menghapus data.
   - Pengguna mendapat konfirmasi untuk menghapus data.
   - Data mahasiswa dihapus dari database MySQL.
   - Tabel diperbarui untuk menampilkan data yang telah dihapus.

5. **Batalkan Operasi**:
   - Pengguna menekan tombol "Cancel" untuk membatalkan operasi yang sedang dilakukan.
   - Formulir dikosongkan kembali dan kembali ke mode tambah data.

6. **Menampilkan Data**:
   - Data mahasiswa yang disimpan di database MySQL ditampilkan dalam tabel.
   - Setiap baris tabel menampilkan NIM, nama, jenis kelamin, dan jurusan mahasiswa.

7. **Interaksi Lanjutan**:
   - Pengguna dapat terus menambah, mengubah, dan menghapus data mahasiswa sesuai kebutuhan.
   - Data yang diinput oleh pengguna akan disimpan dan dikelola secara efisien dalam database MySQL.

8. **Mengakhiri Aplikasi**:
   - Pengguna menutup aplikasi.
   - Koneksi database ditutup.
## Dokumentasi

### Tampilan Antarmuka Pengguna
Program akan menampilkan jendela dengan tabel untuk menampilkan data mahasiswa, serta input form untuk menambah, mengupdate, dan menghapus data.

[![SR](https://github.com/fridzfth/TP2DPBO2024C2/blob/d76cf0244c565525d8bc16562ea866c49da19d9a/Screeenshots%20%20Screenrecords/Screenshot%202024-03-19%20185040.png)](https://github.com/fridzfth/TP2DPBO2024C2/blob/d76cf0244c565525d8bc16562ea866c49da19d9a/Screeenshots%20%20Screenrecords/Screenrecord.mkv)
