/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Goodwin
 */


package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class EditClass {

    DecimalFormat df = new DecimalFormat("#.00");

    public int editSerialNumber(ObservableList<ListOfInventory> loi, TextField Serial_Number_Text, TableView<ListOfInventory> InventoryList) {

        ListOfInventory listOfInventory = InventoryList.getSelectionModel().getSelectedItem();


        if (listOfInventory.getSerialNumber().isBlank()) {
            return 11;

        }
        else{
            if (Serial_Number_Text.getText().isBlank()) {
                return 4;
            } else {
                if (Serial_Number_Text.textProperty().getValue().matches("[0-9 + A-z]+")) {
                    if (Serial_Number_Text.textProperty().length().getValue().equals(10)) {
                        SerialNumberCheck snc = new SerialNumberCheck();
                        if (snc.serialnumberchecker(loi, Serial_Number_Text) == 1) {
                            listOfInventory.setSerialNumber(Serial_Number_Text.getText());
                            Serial_Number_Text.setText("");
                            return 0;
                        } else {
                            return 5;
                        }
                    } else {
                        return 6;
                    }
                } else {
                    return 7;
                }
            }
        }
    }




    public int editName(ObservableList<ListOfInventory> loi, TextField Name_text, TableView<ListOfInventory> InventoryList) {

        ListOfInventory listOfInventory = InventoryList.getSelectionModel().getSelectedItem();

        if (listOfInventory.getName().isBlank()) {
            return 11;

        }
        else{
            if(Name_text.getText().isBlank()){
                return 3;
            }
            else{
                if(Name_text.getText().length()==1 || Name_text.getText().length() > 256){
                    return 2;
                }
                else{
                    listOfInventory.setValue(Name_text.getText());
                    Name_text.setText("");
                    return 0;
                }
            }
        }

    }

    public int editValue(ObservableList<ListOfInventory> loi, TextField Value_text, TableView<ListOfInventory> InventoryList) {

        ListOfInventory listOfInventory = InventoryList.getSelectionModel().getSelectedItem();
        if (listOfInventory.getValue().isBlank()) {
            return 11;

        } else {
            if (Value_text.getText().isBlank()) {
                return 1;
            } else {
                String value_texts = Value_text.getText();
                double values = 0;
                if (Value_text.textProperty().getValue().matches("[0-9 + .]+")) {
                    try {
                        values = Double.parseDouble(value_texts);
                        String val = String.valueOf(df.format(values));
                        listOfInventory.setName("$" + val);
                        Value_text.setText("");
                        return 0;

                    } catch (NumberFormatException nfe) {
                        return 8;
                    }
                } else {
                    return 9;
                }
            }
        }
    }

}

