package ucf.assignments;

import javafx.beans.value.ObservableStringValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class errorcontroller implements Initializable {

    @FXML
    public TextArea errormsg_text;


    public void initialize(URL location, ResourceBundle resources) {

    }

    public void text(String error){
        errormsg_text.setText(error);
    }
}
