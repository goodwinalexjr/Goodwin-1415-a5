/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Goodwin
 */


package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UIControllerTest extends ApplicationTest {

    public final ObservableList<ListOfInventory> loi = FXCollections.observableArrayList();
    @FXML
    public TableView InventoryList;
    @FXML
    public TextField Value_text;
    @FXML
    public TextField Name_text;
    @FXML
    public TextField Serial_Number_Text;
    @FXML
    public TableColumn Value;
    @FXML
    public TableColumn Serial_Number;
    @FXML
    public TableColumn Name;


    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("UITest.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Inventory");
        stage.setScene(scene);
        stage.show();
    }


    @Test
    void add() {
        Value_text.setText("22.50");
        Name_text.setText("JohnDeer");
        Serial_Number_Text.setText("XXXXXXXXXX");

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 0;

        assertEquals(expected, actual);
    }
}