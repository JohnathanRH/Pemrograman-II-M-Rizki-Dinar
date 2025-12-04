package controllers;

import controllers.common.Controller;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Buku;
import models.Pelanggan;
import models.Penjualan;
import services.BukuService;
import services.PelangganService;
import services.PenjualanService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class PenjualanController extends Controller {
    @FXML private Label totalHargaLbl;
    @FXML private TextField jumlahTxt;
    @FXML private DatePicker tanggalPicker;
    @FXML private TableView<Penjualan> penjualanTbl;
    @FXML private TableColumn jumlahCol, totalHargaCol, tanggalCol;
    @FXML private TableColumn<Penjualan, Float> hargaCol;
    @FXML private TableColumn<Penjualan, String> bukuCol, emailPelangganCol;
    @FXML private ChoiceBox<String> pelangganCBox, bukuCBox;

    private HashMap<String, Pelanggan> pelangganMap = new HashMap<>();
    private HashMap<String, Buku> bukuMap = new HashMap<>();

    private int selectedPenjualanId;
    private Pelanggan selectedPelanggan;
    private Buku selectedBuku;

    PelangganService pelangganService = new PelangganService();
    BukuService bukuService = new BukuService();
    PenjualanService service = new PenjualanService();

    @FXML
    public void initialize()
    {
        tableSetup();

        loadData();
        loadChoices();
    }

    @FXML
    private void onAddPenjualan()
    {
        Penjualan penjualan = instantiateModel();

        try{
            service.addPenjualan(penjualan);
            onSuccess();
        }
        catch (NumberFormatException nfe) {
            showAlert(Alert.AlertType.ERROR, "Gagal", "Jumlah atau Total harga harus bernilai angka");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void onEditPenjualan()
    {
        Penjualan penjualan = instantiateModel();
        penjualan.setPenjualanId(selectedPenjualanId);

        try {
            service.editPenjualan(penjualan);
            onSuccess();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }


    @FXML
    private void onDeletePenjualan()
    {
        try
        {
            service.deletePenjualan(selectedPenjualanId);
            onSuccess();
        } catch (Exception e)
        {
            showAlert(Alert.AlertType.ERROR, "Gagal!", e.getMessage());
        }
    }

    @FXML
    private void onJumlahTxtInput()
    {
        if(!jumlahTxt.getText().isEmpty() && !jumlahTxt.getText().equals(null))
        {
            try
            {
                float total = calculateTotal();
                totalHargaLbl.setText(String.valueOf(total));
            } catch (Exception e) {
                showAlert(Alert.AlertType.WARNING, "Warning!", e.getMessage());
            }
        }
    }

    private float calculateTotal() throws Exception
    {
        if (selectedBuku == null){
            throw new Exception("Pilih buku dulu");
        }
        int jumlah = Integer.parseInt(jumlahTxt.getText());
        float total = selectedBuku.getHarga() * jumlah;
        return total;
    }

    @Override
    protected void loadData()
    {
        try{
            ObservableList<Penjualan> penjualans = FXCollections.observableArrayList(service.getAllPenjualan());
            penjualanTbl.setItems(penjualans);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void loadChoices()
    {
        ObservableList<String> pelanggans = FXCollections.observableArrayList();
        ObservableList<String> bukus = FXCollections.observableArrayList();

        try{
            pelangganService.getAllPelanggan().forEach(pelanggan -> {
                pelangganMap.put(pelanggan.getNama(), pelanggan);
                pelanggans.add(pelanggan.getNama());
            });
            bukuService.getAllBuku().forEach(buku -> {
               bukuMap.put(buku.getJudul(), buku);
               bukus.add(buku.getJudul());
            });

            pelangganCBox.setItems(pelanggans);
            bukuCBox.setItems(bukus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void translateToObj()
    {
        selectedPelanggan = pelangganMap.get(pelangganCBox.getValue());
        selectedBuku = bukuMap.get(bukuCBox.getValue());
    }

    @FXML
    private void onBukuChosen()
    {
        selectedBuku = bukuMap.get(bukuCBox.getValue());
    }

    @FXML
    private void onPelangganChosen()
    {
        selectedPelanggan = pelangganMap.get(pelangganCBox.getValue());
    }

    @Override
    protected void clearField()
    {

    }

    @Override
    protected Penjualan instantiateModel()
    {
        translateToObj();
        int jumlah = Integer.parseInt(jumlahTxt.getText());
        float totalHarga = jumlah * selectedBuku.getHarga();
        Date tanggal = Date.valueOf(tanggalPicker.getValue());

        Penjualan penjualan = new Penjualan(
                jumlah,
                totalHarga,
                tanggal,
                selectedBuku,
                selectedPelanggan
        );

        return penjualan;
    }

    @Override
    protected void tableSetup()
    {
        // Connect view column to Penjualan model
        jumlahCol.setCellValueFactory(new PropertyValueFactory<>("jumlah"));
        totalHargaCol.setCellValueFactory(new PropertyValueFactory<>("totalHarga"));
        tanggalCol.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        hargaCol.setCellValueFactory(cellData ->
                new SimpleFloatProperty(cellData.getValue().getBuku().getHarga()).asObject()
        );
        bukuCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getBuku().getJudul())
        );
        emailPelangganCol.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getPelanggan().getEmail())
        );

        // Logic to retrieve selected data from tableview
        penjualanTbl.getSelectionModel().selectedItemProperty().addListener(
                ((observable, oldValue, newValue) ->{
                    if(newValue != null)
                    {
                        selectedPenjualanId = newValue.getPenjualanId();
                        pelangganCBox.setValue(newValue.getPelanggan().getNama());
                        bukuCBox.setValue(newValue.getBuku().getJudul());
                        jumlahTxt.setText(String.valueOf(newValue.getJumlah()));
                        try { totalHargaLbl.setText(String.valueOf(calculateTotal())); }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        tanggalPicker.setValue(newValue.getTanggal().toLocalDate());
                    }
                })
        );
    }
}
