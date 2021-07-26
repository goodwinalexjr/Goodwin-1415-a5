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
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class removeitemTest extends ApplicationTest {

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
    void remove() {

        ListOfInventory listOfInventory = new ListOfInventory("Test", "ABCDEFAAAA", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);
        InventoryList.getSelectionModel().select(0);

        removeitem ri = new removeitem();
        int actual = ri.remove(loi, InventoryList);
        int expected = 0;

        assertEquals(actual, expected);
    }
}