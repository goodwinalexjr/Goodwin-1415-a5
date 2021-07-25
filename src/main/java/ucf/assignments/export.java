/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Alex Goodwin
 */


package ucf.assignments;

import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class export {

    public static void saveTSV(ObservableList<ListOfInventory> loi, File file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        for (ListOfInventory list : loi) {
            bw.write(list.getValue() + "\t" + list.getSerialNumber() + "\t" + list.getName() + "\t");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void saveHTML(ObservableList<ListOfInventory> loi, File file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        bw.write("<!DOCKTYPE html>");
        bw.newLine();
        bw.write("<html>");
        bw.newLine();
        bw.write("<body>");
        bw.newLine();
        bw.newLine();
        bw.write("<h2>Inventory List</h2>");
        bw.newLine();
        bw.newLine();
        bw.write("<table style=\"width:50%\">");
        bw.newLine();
        bw.write("<tr>");
        bw.newLine();
        bw.write("<th>Name</th>");
        bw.newLine();
        bw.write("<th>Serial Number</th>");
        bw.newLine();
        bw.write("<th>Value</th>");
        bw.newLine();
        bw.write("</tr>");
        bw.newLine();
        for (ListOfInventory list : loi) {
            bw.write("<tr>");
            bw.newLine();
            bw.write("<td> " + list.getValue() + " </td>");
            bw.newLine();
            bw.write("<td> " + list.getSerialNumber() + " </td>");
            bw.newLine();
            bw.write("<td> " + list.getName() + " </td>");
            bw.newLine();
            bw.write("</tr>");
            bw.newLine();
        }
        bw.write("</table>");
        bw.newLine();
        bw.newLine();
        bw.write("</body>");
        bw.newLine();
        bw.write("</html>");

        bw.flush();
        bw.close();
    }

    public static void saveJSON(ObservableList<ListOfInventory> loi, File file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        bw.write("[");
        bw.newLine();
        int i = 0;
        for (ListOfInventory list : loi) {
            i++;
            System.out.println(loi.size());
            bw.write("\t{");
            bw.newLine();
            bw.write("\t\t\"Name\":\t\" " + list.getValue() + " \",");
            bw.newLine();
            bw.write("\t\t\"SerialNumber\":\t\" " + list.getSerialNumber() + " \",");
            bw.newLine();
            bw.write("\t\t\"Value\":\t\" " + list.getName() + " \"");
            bw.newLine();
            if (i == loi.size()) {
                bw.write("\t}");
                bw.newLine();
            } else {
                bw.write("\t},");
                bw.newLine();
            }
        }

        bw.write("]");

        bw.flush();
        bw.close();
    }
}
