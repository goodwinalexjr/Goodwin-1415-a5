package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

public class SerialNumberCheck {

    public static int serialnumberchecker(ObservableList<ListOfInventory> loi, TextField Serial_Number_Text){
        for(ListOfInventory listofinventory : loi){
            if(listofinventory.getSerialNumber().matches(Serial_Number_Text.getText())){
                return 0;
            }
            else{

            }
        }
        return 1;
    }

}
