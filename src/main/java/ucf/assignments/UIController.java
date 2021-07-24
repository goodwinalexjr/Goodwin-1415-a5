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

        errormesage em = new errormesage();
        em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);



    }


    public void Remove_Button_Clicked(ActionEvent actionEvent) throws IOException {
        removeitem ri = new removeitem();
        int test = ri.remove(loi, InventoryList);

        errormesage em = new errormesage();
        em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);
    }

    public void Search_Button_Clicked(ActionEvent actionEvent) {
    }

    public void Clear_Button_Clicked(ActionEvent actionEvent) {
    }

    public void Edit_SerialNumber_Clicked(ActionEvent actionEvent) throws IOException {
        EditClass ec = new EditClass();
        int test = ec.editSerialNumber(loi, Serial_Number_Text, InventoryList);
        if(test == 0){
        }
        else{
            errormesage em = new errormesage();
            em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);
        }
    }

    public void Edit_Value_Clicked(ActionEvent actionEvent) throws IOException {
        EditClass ec = new EditClass();
        int test = ec.editValue(loi, Value_text, InventoryList);
        if(test == 0){
        }
        else{
            errormesage em = new errormesage();
            em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);
        }
    }

    public void Edit_Name_Clicked(ActionEvent actionEvent) throws IOException {
        EditClass ec = new EditClass();
        int test = ec.editName(loi, Name_text, InventoryList);
        if(test == 0){
        }
        else{
            errormesage em = new errormesage();
            em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);
        }
    }
}