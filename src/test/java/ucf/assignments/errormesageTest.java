/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Goodwin
 */


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

class errormesageTest extends ApplicationTest {

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
    void errormessagepopup() throws IOException {
        TextField Value_text = new TextField("22");

        TextField Name_text = new TextField("test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");
        int test = 0;

        ListOfInventory listOfInventory = new ListOfInventory("Test", "ABCDEFAAAA", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);
        InventoryList.getSelectionModel().select(0);
        errormesage er = new errormesage();
        String actual = er.errormessagepopup(loi, test, Value_text, Name_text, Serial_Number_Text, InventoryList);
        String expected = "";

        assertEquals(expected, actual);
    }
}