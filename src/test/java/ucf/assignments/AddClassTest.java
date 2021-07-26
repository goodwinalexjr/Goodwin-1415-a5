/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Goodwin
 */


package ucf.assignments;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AddClassTest extends ApplicationTest {

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
    public void addTest(){

        TextField Value_text = new TextField("22");

        TextField Name_text = new TextField("test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 0;

        assertEquals(expected, actual);

    }

    @Test
    public void addTesterror1(){

        TextField Value_text = new TextField("");

        TextField Name_text = new TextField("test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 1;

        assertEquals(expected, actual);

    }

    @Test
    public void addTesterror2(){

        TextField Value_text = new TextField("22");

        TextField Name_text = new TextField("T");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 2;

        assertEquals(expected, actual);

    }

    @Test
    public void addTesterror3(){

        TextField Value_text = new TextField("22");

        TextField Name_text = new TextField("");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 3;

        assertEquals(expected, actual);

    }

    @Test
    public void addTesterror4(){

        TextField Value_text = new TextField("22");

        TextField Name_text = new TextField("test");

        TextField Serial_Number_Text = new TextField("");

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 4;

        assertEquals(expected, actual);

    }

    @Test
    public void addTesterror5(){

        TextField Value_text = new TextField("22");

        TextField Name_text = new TextField("Test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "XXXXXXXXXX", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 5;

        assertEquals(expected, actual);

    }

    @Test
    public void addTesterror6(){

        TextField Value_text = new TextField("22");

        TextField Name_text = new TextField("Test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX2");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "XXXXXXXXXX", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 6;

        assertEquals(expected, actual);

    }

    @Test
    public void addTesterror7(){

        TextField Value_text = new TextField("22");

        TextField Name_text = new TextField("Test");

        TextField Serial_Number_Text = new TextField("@#34567891");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "XXXXXXXXXX", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 7;

        assertEquals(expected, actual);

    }

    @Test
    public void addTesterror8(){

        TextField Value_text = new TextField("22.22.");

        TextField Name_text = new TextField("Test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "XXXXXXXXXX", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 8;

        assertEquals(expected, actual);

    }

    @Test
    public void addTesterror9(){

        TextField Value_text = new TextField("22A");

        TextField Name_text = new TextField("Test");

        TextField Serial_Number_Text = new TextField("XXXXXXXXXX");

        ListOfInventory listOfInventory = new ListOfInventory("Test", "XXXXXXXXXX", "34.50");
        loi.addAll(listOfInventory);
        TableView<ListOfInventory> InventoryList = new TableView<ListOfInventory>();
        InventoryList.setItems(loi);

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 9;

        assertEquals(expected, actual);

    }
}