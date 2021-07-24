package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class UIController implements Initializable {


    @FXML
    public TableView<ListOfInventory> InventoryList;
    @FXML
    public TableColumn<ListOfInventory, String> Name;
    @FXML
    public TableColumn<ListOfInventory, String> Value;
    @FXML
    public TableColumn<ListOfInventory, String> Serial_Number;
    @FXML
    public TextField Value_text;
    @FXML
    public TextField Serial_Number_Text;
    @FXML
    public TextField Name_text;
    @FXML
    public TextField search;
    @FXML
    public TextField hiddensearch;

    String field = null;
    public double values = 0;
    public final ObservableList<ListOfInventory> loi = FXCollections.observableArrayList();



    //set up a sorted list and also the cell factory to be able to be displayed
    //once that is set up can start on the add button
    //will set it up by using FilteredList and SortedList
    public void initialize(URL location, ResourceBundle resources) {



        Name.setCellValueFactory(new PropertyValueFactory<ListOfInventory, String>("name"));
        Value.setCellValueFactory(new PropertyValueFactory<ListOfInventory, String>("value"));
        Serial_Number.setCellValueFactory(new PropertyValueFactory<ListOfInventory, String>("serialNumber"));



    }

    public void Add_Button_Clicked(ActionEvent actionEvent) throws IOException {
        AddClass ac = new AddClass();
        int test = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);
        String errormsg = "";

        switch(test){
            case 0:
                break;
            case 1:
                errormsg = "Value needs to be filled.";
                break;
            case 2:
                errormsg = "Name needs to be between 2 and 256 characters. You have " + Name_text.getText().length() + " characters.";
                break;
            case 3:
                errormsg = "Name needs to be filled.";
                break;
            case 4:
                errormsg = "Serial Number needs to be filled";
                break;
            case 5:
                errormsg = "The serial Number is Already entered";
                break;
            case 6:
                errormsg = "Serial number format needs to be 10 numbers and letters. You have " + Serial_Number_Text.getText().length() + " characters.";
                break;
            case 7:
                errormsg = "Serial Number can only be 0-9 and A-Z/a-z";
                break;
            case 8:
                errormsg = "You may have a extra . in Value";
                break;
            case 9:
                errormsg = "Value must be currency";
                break;

        }
        if(errormsg.matches("")){
            InventoryList.setItems(loi);
            Name_text.setText("");
            Serial_Number_Text.setText("");
            Value_text.setText("");
        }
        else{

            FXMLLoader load = new FXMLLoader(getClass().getResource("errormsg.fxml"));
            Parent page = (Parent) load.load();
            Stage stage = new Stage();
            errorcontroller ec = load.getController();
            ec.text(errormsg);
            stage.setScene(new Scene(page));
            stage.setTitle("Error");
            stage.show();

        }


    }


    public void Remove_Button_Clicked(ActionEvent actionEvent) {
        removeitem ri = new removeitem();
        int test = ri.remove(loi, InventoryList);
        System.out.println(test);

    }

    public void Search_Button_Clicked(ActionEvent actionEvent) {
    }

    public void Clear_Button_Clicked(ActionEvent actionEvent) {
    }

}