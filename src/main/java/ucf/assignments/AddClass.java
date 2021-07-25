/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Goodwin
 */


package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class AddClass {

    public double values = 0;

    public int addFunction(ObservableList<ListOfInventory> loi, TextField Value_text, TextField Name_text, TextField Serial_Number_Text) {
        DecimalFormat df = new DecimalFormat("#.00");


        if (Value_text.getText().isBlank()) {
            //error for a blank space
            System.out.println("Blank space in value");
            return 1;

        } else if (Value_text.textProperty().getValue().matches("[0-9 + .]+")) {

            String value_texts = Value_text.getText();
            try {

                values = Double.parseDouble(value_texts);

                if (Name_text.getText().length() == 1 || Name_text.getText().length() > 256) {
                    System.out.println("Name needs to be between 2 and 256 characters");
                    System.out.println(Name_text.getText().length());
                    return 2;
                } else {
                    if (Name_text.getText().isBlank()) {
                        System.out.println("Blank Space in Name");
                        return 3;
                    } else {
                        if (Serial_Number_Text.getText().isBlank()) {
                            System.out.println("Serial number is blank");
                            return 4;
                        } else {
                            if (Serial_Number_Text.textProperty().getValue().matches("[0-9 + A-z]+")) {
                                if (Serial_Number_Text.textProperty().length().getValue().equals(10)) {
                                    SerialNumberCheck snc = new SerialNumberCheck();
                                    if (snc.serialnumberchecker(loi, Serial_Number_Text) == 1) {
                                        String val = String.valueOf(df.format(values));
                                        ListOfInventory listofinventorty = new ListOfInventory("$" + val, Serial_Number_Text.getText(), Name_text.getText());
                                        loi.addAll(listofinventorty);

                                        return 0;
                                    } else {
                                        System.out.println("Serial Numbers Matching");
                                        return 5;
                                    }
                                } else {
                                    System.out.println("Serial number format needs to be 10 numbers and letters");
                                    System.out.println(Serial_Number_Text.textProperty().length().getValue());
                                    return 6;
                                }
                            } else {
                                System.out.println("Serial Number can only be 0-9 and A-Z/a-z");
                                return 7;
                            }


                        }
                    }
                }

            } catch (NumberFormatException nfe) {
                System.out.println("Number is inccorectly formatted");
                return 8;
            }

        } else {
            //error has letters and is not just numeric
            System.out.println("Value is non numeric");
            return 9;
        }

    }
}

