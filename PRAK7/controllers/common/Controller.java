package controllers.common;

import javafx.scene.control.Alert;

public abstract class Controller {

    protected abstract void tableSetup();
    protected abstract void loadData();
    protected abstract void clearField();
    protected abstract Object instantiateModel();

    protected void showAlert(Alert.AlertType type, String title, String content)
    {
        Alert a = new Alert(type);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(content);
        a.show();
    }

    protected void onSuccess()
    {
        loadData();
        clearField();
        showAlert(Alert.AlertType.CONFIRMATION, "Sukses!", "Operasi berhasil!");
    }
}
