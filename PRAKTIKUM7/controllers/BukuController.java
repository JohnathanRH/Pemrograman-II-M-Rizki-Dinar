package controllers;

import controllers.common.Controller;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Buku;
import services.BukuService;

public class BukuController extends Controller {
    @FXML private TextField judulBukuTxt, penulisBukuTxt, hargaBukuTxt, stokBukuTxt;
    @FXML private TableView<Buku> bukuTbl;
    @FXML private TableColumn judulCol, penulisCol, hargaCol, stokCol;

    private BukuService service = new BukuService();
    private int selectedId;

    @FXML
    public void initialize()
    {
        tableSetup();

        loadData();
    }

    @FXML
    public void onAddBuku()
    {
        try{
            Buku buku = instantiateModel();
            service.addBuku(buku);
            onSuccess();
        }
        catch (NumberFormatException nfe)
        {
            showAlert(Alert.AlertType.ERROR, "Gagal", "Harga atau Stok harus berupa angka");
        }
        catch (Exception e){
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @FXML
    public void onEditBuku()
    {
        if(selectedId == 0){
            showAlert(Alert.AlertType.WARNING, "Warning!", "Pilih data buku nya dulu");
            return;
        }
        Buku buku = instantiateModel();
        buku.setBukuId(selectedId);
        try{
            service.editBuku(buku);
            onSuccess();
        } catch (Exception e){
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @FXML
    public void onDeleteBuku()
    {
        if(selectedId == 0){
            showAlert(Alert.AlertType.WARNING, "Warning!", "Pilih data buku nya dulu");
            return;
        }
        try {
            service.deleteBuku(selectedId);
            onSuccess();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @Override
    protected void loadData()
    {
        try{
            ObservableList<Buku> bukus = FXCollections.observableArrayList(service.getAllBuku());
            bukuTbl.setItems(bukus);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @Override
    protected Buku instantiateModel()
    {
        Buku buku = new Buku(
                judulBukuTxt.getText(),
                penulisBukuTxt.getText(),
                Float.parseFloat(hargaBukuTxt.getText()),
                Integer.parseInt(stokBukuTxt.getText())
        );
        return buku;
    }

    @Override
    protected void clearField()
    {
        selectedId = 0;
        judulBukuTxt.clear();
        penulisBukuTxt.clear();
        hargaBukuTxt.clear();
        stokBukuTxt.clear();
    }

    @Override
    protected void tableSetup()
    {
        judulCol.setCellValueFactory(new PropertyValueFactory<>("judul"));
        penulisCol.setCellValueFactory(new PropertyValueFactory<>("penulis"));
        hargaCol.setCellValueFactory(new PropertyValueFactory<>("harga"));
        stokCol.setCellValueFactory(new PropertyValueFactory<>("stok"));

        bukuTbl.getSelectionModel().selectedItemProperty().addListener(
            (observableValue, oldValue, newValue) -> {
                if (newValue != null)
                {
                    selectedId = newValue.getBukuId();
                    judulBukuTxt.setText(newValue.getJudul());
                    penulisBukuTxt.setText(newValue.getPenulis());
                    hargaBukuTxt.setText(Float.toString(newValue.getHarga()));
                    stokBukuTxt.setText(Integer.toString(newValue.getStok()));
                }
            }
        );
    }
}
