/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Goodwin
 */


package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class errormesage {

    public String errormessagepopup(ObservableList<ListOfInventory> loi, int test, TextField Value_text, TextField Name_text, TextField Serial_Number_Text, TableView<ListOfInventory> InventoryList) throws IOException {
        String errormsg = "";

        switch(test){
            case 0:
                break;
            case 1:
                errormsg = "Value needs to be filled.";
                break;
            case 2:
                errormsg = "Name needs to be between 2 and 256 characters. You have " + Name_text.getText().length() + " characters.";
                break;
            case 3:
                errormsg = "Name needs to be filled.";
                break;
            case 4:
                errormsg = "Serial Number needs to be filled";
                break;
            case 5:
                errormsg = "The serial Number is Already entered";
                break;
            case 6:
                errormsg = "Serial number format needs to be 10 numbers and letters. You have " + Serial_Number_Text.getText().length() + " characters.";
                break;
            case 7:
                errormsg = "Serial Number can only be 0-9 and A-Z/a-z";
                break;
            case 8:
                errormsg = "You may have a extra . in Value";
                break;
            case 9:
                errormsg = "Value must be currency";
                break;
            case 10:
                errormsg = "Please select an item to remove";
                break;
            case 11:
                errormsg = "Please select an item to edit";
                break;

        }
        if(errormsg.matches("")){
            InventoryList.setItems(loi);
            Name_text.setText("");
            Serial_Number_Text.setText("");
            Value_text.setText("");
            return "";
        }
        else{

            FXMLLoader load = new FXMLLoader(getClass().getResource("errormsg.fxml"));
            Parent page = (Parent) load.load();
            Stage stage = new Stage();
            errorcontroller ec = load.getController();
            ec.text(errormsg);
            stage.setScene(new Scene(page));
            stage.setTitle("Error");
            stage.show();
            return errormsg;

        }
    }
}
