package controllers;

import controllers.common.Controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Pelanggan;
import services.PelangganService;

public class PelangganController extends Controller {
    @FXML private TextField namaPelangganTxt, emailPelangganTxt, teleponPelangganTxt;
    @FXML private TableView<Pelanggan> pelangganTbl;
    @FXML private TableColumn namaCol, emailCol, teleponCol;
    @FXML private Button addPelangganBtn;

    private PelangganService service = new PelangganService();
    private int selectedId;

    @FXML
    public void initialize()
    {
        tableSetup();

        loadData();
    }

    @FXML
    private void onAddPelanggan()
    {
        try
        {
            Pelanggan pelanggan = instantiateModel();
            service.addPelanggan(pelanggan);

            onSuccess();

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @FXML
    private void onDeletePelanggan()
    {
        if(selectedId <= 0)
        {
            showAlert(Alert.AlertType.WARNING, "Belum pilih", "Pilih seorang pelanggan");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Yakin mau hapus?");
        alert.showAndWait().ifPresent(response -> {
            try{
                if(response == ButtonType.OK)
                {
                    service.deletePelanggan(selectedId);
                    onSuccess();
                }
            }
            catch (Exception e) {
                showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
            }
        });
    }

    @FXML
    private void onEditPelanggan()
    {
        if(selectedId <= 0)
        {
            showAlert(Alert.AlertType.WARNING, "Belum pilih", "Pilih seorang pelanggan");
            return;
        }
        Pelanggan p = instantiateModel();
        p.setPelangganId(selectedId);
        try{
            service.editPelanggan(p);
            onSuccess();
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @Override @FXML
    protected void clearField()
    {
        namaPelangganTxt.clear();
        emailPelangganTxt.clear();
        teleponPelangganTxt.clear();
    }

    @Override
    protected Pelanggan instantiateModel()
    {
        String n =  namaPelangganTxt.getText();
        String e =  emailPelangganTxt.getText();
        String t =  teleponPelangganTxt.getText();

        Pelanggan pelanggan = new Pelanggan(n,e,t);
        return pelanggan;
    }

    @Override
    protected void loadData()
    {
        try {
            ObservableList<Pelanggan> pelanggans = FXCollections.observableArrayList(service.getAllPelanggan());
            pelangganTbl.setItems(pelanggans);
        }
        catch (Exception e){
            showAlert(Alert.AlertType.ERROR, "Gagal", e.getMessage());
        }
    }

    @Override
    protected void tableSetup()
    {
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        teleponCol.setCellValueFactory(new PropertyValueFactory<>("telepon"));

        pelangganTbl.getSelectionModel().selectedItemProperty().addListener(
                ((observableValue, oldValue, newValue) -> {
                    if(newValue != null)
                    {
                        selectedId = newValue.getPelangganId();
                        namaPelangganTxt.setText(newValue.getNama());
                        emailPelangganTxt.setText(newValue.getEmail());
                        teleponPelangganTxt.setText(newValue.getTelepon());
                    }
                })
        );
    }
}
