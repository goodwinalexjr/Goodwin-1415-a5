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

class SerialNumberCheckTest extends ApplicationTest {
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
    void serialnumberchecker() {

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "ABCDEFAAAA", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);
        InventoryList.getSelectionModel().select(0);

        SerialNumberCheck snc = new SerialNumberCheck();
        int actual = snc.serialnumberchecker(loi, Serial_Number_Text);
        int expected = 1;

        assertEquals(expected, actual);
    }

    @Test
    void serialnumbercheckerfail() {

        TextField Serial_Number_Text = new TextField("ABCDEFAAAA");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "ABCDEFAAAA", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);
        InventoryList.getSelectionModel().select(0);

        SerialNumberCheck snc = new SerialNumberCheck();
        int actual = snc.serialnumberchecker(loi, Serial_Number_Text);
        int expected = 0;

        assertEquals(expected, actual);
    }
}