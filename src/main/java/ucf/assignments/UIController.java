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


        FilteredList<ListOfInventory> filter = new FilteredList<ListOfInventory>(loi, b -> true);
        hiddensearch.setText(field);

        hiddensearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(listofinventory -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lcf = newValue.toLowerCase();

                if (listofinventory.getName().toLowerCase().indexOf(lcf) != -1) {
                    return true;
                } else if (listofinventory.getSerialNumber().toLowerCase().indexOf(lcf) != -1) {
                    return true;
                } else if (listofinventory.getValue().toLowerCase().indexOf(lcf) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<ListOfInventory> sort = new SortedList<>(filter);
        sort.comparatorProperty().bind(InventoryList.comparatorProperty());

        InventoryList.setItems(sort);

    }

    public void Add_Button_Clicked(ActionEvent actionEvent) {
        addFunction();

    }



    public void Remove_Button_Clicked(ActionEvent actionEvent) {
    }

    public void Search_Button_Clicked(ActionEvent actionEvent) {
    }

    public void Clear_Button_Clicked(ActionEvent actionEvent) {
    }

    public void addFunction(){
        DecimalFormat df = new DecimalFormat("#.00");


        if(Value_text.getText().isBlank()){
            //error for a blank space
            System.out.println("Blank space in value");

        }
        else if(Value_text.textProperty().getValue().matches("[0-9 + .]+")){

            String value_texts = Value_text.getText();
            try {

                    values = Double.parseDouble(value_texts);

                if(Name_text.getText().length()==1 || Name_text.getText().length() > 256){
                    System.out.println("Name needs to be between 2 and 256 characters");
                    System.out.println(Name_text.getText().length());
                }

                else{
                    if(Name_text.getText().isBlank()) {
                        System.out.println("Blank Space in Name");
                    }
                    else {
                        if(Serial_Number_Text.getText().isBlank()){
                            System.out.println("Serial number is blank");
                        }
                        else {
                            if(Serial_Number_Text.textProperty().getValue().matches("[0-9 + A-z]+")){
                                if(Serial_Number_Text.textProperty().length().getValue().equals(10)){
                                    SerialNumberCheck snc = new SerialNumberCheck();
                                    if(snc.serialnumberchecker(loi,Serial_Number_Text) == 1) {
                                        String val = String.valueOf(df.format(values));
                                        ListOfInventory listofinventorty = new ListOfInventory("$" + val, Serial_Number_Text.getText(), Name_text.getText());
                                        loi.addAll(listofinventorty);
                                    }
                                    else{
                                        System.out.println("Serial Numbers Matching");
                                    }
                                }
                                else{
                                    System.out.println("Serial number format needs to be 10 numbers and letters");
                                    System.out.println(Serial_Number_Text.textProperty().length().getValue());
                                }
                            }
                            else{
                                System.out.println("Serial Number can only be 0-9 and A-Z");
                            }


                        }
                    }
                }

            }catch(NumberFormatException nfe) {
                System.out.println("Number is inccorectly formatted");
            }

        }
        else{
            //error has letters and is not just numeric
            System.out.println("Value is non numeric");
        }
    }
}
