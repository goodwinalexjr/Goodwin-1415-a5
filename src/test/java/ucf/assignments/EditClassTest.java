package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class EditClassTest extends ApplicationTest {

    public final ObservableList<ListOfInventory> loi = FXCollections.observableArrayList();



    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Inventory");
        stage.setScene(scene);
        stage.show();
    }

    @Test
    void editSerialNumber() {
        TextField Value_text = new TextField("22");

        TextField Name_text = new TextField("test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "ABCDEFAAAA", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);
        InventoryList.getSelectionModel().select(0);

        EditClass ec = new EditClass();
        int actual = ec.editSerialNumber(loi, Serial_Number_Text, InventoryList);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void editName() {

        TextField Name_text = new TextField("test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "ABCDEFAAAA", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);
        InventoryList.getSelectionModel().select(0);

        EditClass ec = new EditClass();
        int actual = ec.editName(loi, Name_text, InventoryList);
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void editValue() {

        TextField Name_text = new TextField("test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        TextField Value_text = new TextField("22");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "ABCDEFAAAA", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);
        InventoryList.getSelectionModel().select(0);

        EditClass ec = new EditClass();
        int actual = ec.editValue(loi,Value_text , InventoryList);
        int expected = 0;

        assertEquals(expected, actual);
    }
}