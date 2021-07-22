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
    public final ObservableList<ListOfInventory> loi = FXCollections.observableArrayList();



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
        ListOfInventory listofinventorty = new ListOfInventory(Value_text.getText(), Serial_Number_Text.getText(), Name_text.getText());
        loi.addAll(listofinventorty);
    }



    public void Remove_Button_Clicked(ActionEvent actionEvent) {
    }

    public void Search_Button_Clicked(ActionEvent actionEvent) {
    }

    public void Clear_Button_Clicked(ActionEvent actionEvent) {
    }
}
