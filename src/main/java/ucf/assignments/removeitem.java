package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class removeitem {

    public int remove(ObservableList<ListOfInventory> loi, TableView<ListOfInventory> InventoryList ){


        ObservableList<ListOfInventory> removeitems;
        removeitems = InventoryList.getSelectionModel().getSelectedItems();

        ;

            if(InventoryList.getItems().removeAll(removeitems)){
                return 0;
            }
            else{
                return 10;
            }

    }
}
