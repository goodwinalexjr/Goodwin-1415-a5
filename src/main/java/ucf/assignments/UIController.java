/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Goodwin
 */


package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
        add();


    }


    public void Remove_Button_Clicked(ActionEvent actionEvent) throws IOException {
        removeitem ri = new removeitem();
        int test = ri.remove(loi, InventoryList);

        errormesage em = new errormesage();
        em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);
    }

    public void Search_Button_Clicked(ActionEvent actionEvent) {
        FilteredList<ListOfInventory> filter = new FilteredList<ListOfInventory>(loi, b -> true);

        filter.setPredicate(listOfInventory -> {
            String lcf = search.getText().toLowerCase();

            if (listOfInventory.getValue().toLowerCase().indexOf(lcf) != -1) {
                return true;
            } else if (listOfInventory.getValue().toLowerCase().indexOf(lcf) != -1) {
                return true;
            } else {
                return false;
            }

        });

        SortedList<ListOfInventory> sort = new SortedList<ListOfInventory>(filter);
        sort.comparatorProperty().bind(InventoryList.comparatorProperty());
        InventoryList.setItems(sort);
        search.setText("");

    }

    public void Clear_Button_Clicked(ActionEvent actionEvent) {
        InventoryList.setItems(loi);
    }

    public void Edit_SerialNumber_Clicked(ActionEvent actionEvent) throws IOException {
        EditClass ec = new EditClass();
        int test = ec.editSerialNumber(loi, Serial_Number_Text, InventoryList);
        if (test == 0) {
        } else {
            errormesage em = new errormesage();
            em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);
        }
    }

    public void Edit_Value_Clicked(ActionEvent actionEvent) throws IOException {
        EditClass ec = new EditClass();
        int test = ec.editValue(loi, Value_text, InventoryList);
        if (test == 0) {
        } else {
            errormesage em = new errormesage();
            em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);
        }
    }

    public void Edit_Name_Clicked(ActionEvent actionEvent) throws IOException {
        EditClass ec = new EditClass();
        int test = ec.editName(loi, Name_text, InventoryList);
        if (test == 0) {
        } else {
            errormesage em = new errormesage();
            em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);
        }
    }

    public int add() throws IOException {
        AddClass ac = new AddClass();
        int test = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        errormesage em = new errormesage();
        em.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);

        return test;
    }

    public void Save_TSV_Clicked(ActionEvent actionEvent) throws IOException {
        Stage save = new Stage();
        FileChooser fc = new FileChooser();
        fc.setTitle("Save");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("tab-separated value file", "*.txt"));
        File file = fc.showSaveDialog(save);

        if (file != null) {
            export.saveTSV(InventoryList.getItems(), file);
        }
    }

    public void Save_HTML_Clicked(ActionEvent actionEvent) throws IOException {
        Stage save = new Stage();
        FileChooser fc = new FileChooser();
        fc.setTitle("Save");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Hypertext Markup Language", "*.html"));
        File file = fc.showSaveDialog(save);
        if (file != null) {
            export.saveHTML(InventoryList.getItems(), file);
        }
    }

    public void Save_JSON_Clicked(ActionEvent actionEvent) throws IOException {
        Stage save = new Stage();
        FileChooser fc = new FileChooser();
        fc.setTitle("Save");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JavaScript Object Notation", "*.json"));
        File file = fc.showSaveDialog(save);
        if (file != null) {
            export.saveJSON(InventoryList.getItems(), file);
        }
    }

    public void Load_TSV_Clicked(ActionEvent actionEvent) throws FileNotFoundException {

        Stage load = new Stage();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("tab-separated value file", "*.txt"));
        fc.setTitle("Load");
        File file = fc.showOpenDialog(load);
        System.out.println(file.toString());
        if (file != null) {

            ObservableList<ListOfInventory> alllist;
            alllist = InventoryList.getItems();
            loi.removeAll(alllist);
            Scanner myobj = new Scanner(file);

            while (myobj.hasNext()) {

                String Name = myobj.next();

                String SerialNumber = myobj.next();

                String Value = myobj.next();


                System.out.print(Name + " " + SerialNumber + " " + Value + "\n");
                ListOfInventory todolist = new ListOfInventory(Value, SerialNumber, Name);

                loi.addAll(todolist);

            }
            InventoryList.setItems(loi);
        }
    }

    public void Load_HTML_Clicked(ActionEvent actionEvent) throws FileNotFoundException {
        Stage load = new Stage();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Hypertext Markup Language", "*.html"));
        fc.setTitle("Load");
        File file = fc.showOpenDialog(load);
        System.out.println(file.toString());
        if (file != null) {

            ObservableList<ListOfInventory> alllist;
            alllist = InventoryList.getItems();
            loi.removeAll(alllist);
            Scanner myobj = new Scanner(file);

            while (myobj.hasNext()) {

                for (int i = 0; i < 12; i++) {
                    myobj.nextLine();
                }
                myobj.nextLine();
                String test = "";
                for (int i = 0; i < 1000; i++) {

                    test = myobj.next();
                    String Name = myobj.next();
                    test = myobj.next();
                    test = myobj.next();
                    String SerialNumber = myobj.next();
                    myobj.next();
                    myobj.next();
                    String Value = myobj.next();
                    myobj.next();
                    test = myobj.next();
                    test = myobj.next();
                    System.out.print(Name + " " + SerialNumber + " " + Value + "\n");
                    ListOfInventory todolist = new ListOfInventory(Value, SerialNumber, Name);

                    loi.addAll(todolist);
                    if (test.matches("</table>")) {
                        break;
                    }
                }
                myobj.nextLine();
                myobj.nextLine();
                myobj.nextLine();
                myobj.nextLine();


            }
            InventoryList.setItems(loi);
        }
    }

    public void Load_JSON_Clicked(ActionEvent actionEvent) throws FileNotFoundException {
        Stage load = new Stage();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JavaScript Object Notation", "*.json"));
        fc.setTitle("Load");
        File file = fc.showOpenDialog(load);
        System.out.println(file.toString());
        if (file != null) {

            ObservableList<ListOfInventory> alllist;
            alllist = InventoryList.getItems();
            loi.removeAll(alllist);
            Scanner myobj = new Scanner(file);

            while (myobj.hasNext()) {

                myobj.nextLine();
                for (int i = 0; i < 1000; i++) {
                    String test = myobj.nextLine();
                    test = myobj.next();
                    test = myobj.next();
                    String Name = myobj.next();
                    test = myobj.next();
                    test = myobj.next();
                    test = myobj.next();
                    String SerialNumber = myobj.next();
                    test = myobj.next();
                    test = myobj.next();
                    test = myobj.next();
                    String Value = myobj.next();
                    test = myobj.next();
                    test = myobj.next();
                    System.out.print(Name + " " + SerialNumber + " " + Value + "\n");
                    ListOfInventory todolist = new ListOfInventory(Value, SerialNumber, Name);

                    loi.addAll(todolist);
                    if (test.matches("}")) {
                        break;
                    }
                    test = myobj.next();

                }
                myobj.next();


            }
            InventoryList.setItems(loi);
        }
    }
}