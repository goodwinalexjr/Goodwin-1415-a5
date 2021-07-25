/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Goodwin
 */


package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

public class ListOfInventory {

    //name for each inventory
    //serial number for each item
    //value for each item

    //crate it like I did in part 2 of assignment 4

    private SimpleStringProperty name;
    private SimpleStringProperty serialNumber;
    private SimpleStringProperty value;

    public ListOfInventory(String name, String serialNumber, String value) {
        this.name = new SimpleStringProperty(name);
        this.serialNumber = new SimpleStringProperty(serialNumber);
        this.value = new SimpleStringProperty(value);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSerialNumber() {
        return serialNumber.get();
    }

    public SimpleStringProperty serialNumberProperty() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber.set(serialNumber);
    }

    public String getValue() {
        return value.get();
    }

    public SimpleStringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }
}
