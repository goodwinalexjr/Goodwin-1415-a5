package ucf.assignments;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AddClassTest extends ApplicationTest {

    public final ObservableList<ListOfInventory> loi = FXCollections.observableArrayList();
    @FXML
    TextField Value_text = new TextField();
    @FXML
    TextField Name_text = new TextField();
    @FXML
    TextField Serial_Number_Text = new TextField();

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

        Value_text.setText("22.50");
        Name_text.setText("JohnDeer");
        Serial_Number_Text.setText("XXXXXXXXXX");

        AddClass ac = new AddClass();
        int actual = ac.addFunction(loi, Value_text, Name_text, Serial_Number_Text);

        int expected = 0;

        assertEquals(expected, actual);

    }

}