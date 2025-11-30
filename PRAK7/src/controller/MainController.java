package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Pelanggan;
import service.PelangganService;

public class MainController {
	@FXML private TextField txtNama, txtEmail, txtUmur;
    @FXML private TableView<Pelanggan> tblPelanggan;
    @FXML private TableColumn<Pelanggan, String> colNama;
    @FXML private TableColumn<Pelanggan, String> colEmail;
    @FXML private TableColumn<Pelanggan, Integer> colUmur;
    
    private PelangganService service = new PelangganService();
    private int selectedId = 0;
    
    @FXML
    public void initialize() {
        colNama.setCellValueFactory(cell -> cell.getValue().namaProperty());
        colEmail.setCellValueFactory(cell -> cell.getValue().emailProperty());
        colUmur.setCellValueFactory(cell -> cell.getValue().umurProperty().asObject());

        // B. Listener Tabel (Logika Inti Edit/Delete)
        // Saat user klik baris tabel, kita ambil datanya dan masukkan ke Form
        tblPelanggan.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    // 1. Isi form dengan data yang diklik
                    txtNama.setText(newValue.getNama());
                    txtEmail.setText(newValue.getEmail());
                    txtUmur.setText(String.valueOf(newValue.getUmur()));

                    selectedId = newValue.getPelangganId(); 
                }
            }
        );

        // C. Load data awal dari database
        loadData();
    }

    @FXML
    private void onAddPelanggan() {
        try {
            String nama = txtNama.getText();
            String email = txtEmail.getText();
            int umur = Integer.parseInt(txtUmur.getText());

            // Buat object baru
            Pelanggan pelanggan = new Pelanggan(nama, email, umur);

            // Kirim ke Service (Service yang akan validasi & simpan ke DAO)
            service.addPelanggan(pelanggan);

            onSuccess("Berhasil menambahkan data!");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", "Umur harus berupa angka!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @FXML
    private void onEditPelanggan() {
        // Cek apakah user sudah pilih data?
        if (selectedId == 0) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Silakan klik data di tabel dulu!");
            return;
        }

        try {
            String nama = txtNama.getText();
            String email = txtEmail.getText();
            int umur = Integer.parseInt(txtUmur.getText());

            // Buat object Pelanggan DENGAN ID yang sudah disimpan tadi
            Pelanggan pelanggan = new Pelanggan(selectedId, nama, email, umur);
            service.editPelanggan(pelanggan);

            onSuccess("Data berhasil diubah!");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", "Umur harus angka!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }


    @FXML
    private void onDeletePelanggan() {
        if (selectedId == 0) {
            showAlert(Alert.AlertType.WARNING, "Peringatan", "Pilih data yang mau dihapus dulu!");
            return;
        }

        // Konfirmasi Hapus
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Yakin hapus " + txtNama.getText() + "?");
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    // Panggil Service delete pakai ID rahasia tadi
                    service.deletePelanggan(selectedId);
                    onSuccess("Data berhasil dihapus!");
                } catch (Exception e) {
                    showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
                }
            }
        });
    }

    
    private void loadData() {
        try {
            // Ambil List dari Service, bungkus jadi ObservableList buat Tabel
            ObservableList<Pelanggan> list = FXCollections.observableArrayList(service.getAllPelanggan());
            tblPelanggan.setItems(list);
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    private void onSuccess(String msg) {
        showAlert(Alert.AlertType.INFORMATION, "Sukses", msg);
        clearForm();
        loadData(); // Refresh tabel biar data baru muncul
    }

    private void clearForm() {
        txtNama.clear();
        txtEmail.clear();
        txtUmur.clear();
        selectedId = 0; // Reset ID biar gak salah edit
        tblPelanggan.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.show();
    }
}
