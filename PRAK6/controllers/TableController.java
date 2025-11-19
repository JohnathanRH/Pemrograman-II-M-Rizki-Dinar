package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Mahasiswa;

import javafx.scene.control.TableColumn;
import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML private TableView<Mahasiswa> tbMhs;
    @FXML private TableColumn<Mahasiswa, String> nim;
    @FXML private TableColumn<Mahasiswa, String> nama;
    private ObservableList<Mahasiswa> dataMhs = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        dataMhs.add(new Mahasiswa(1, "John", "123"));
        dataMhs.add(new Mahasiswa(2, "Jane", "123"));
        dataMhs.add(new Mahasiswa(3, "Jono", "124123"));
        dataMhs.add(new Mahasiswa(4, "Agus", "1241234"));
        tbMhs.setItems(dataMhs);
    }

}
