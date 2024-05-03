import java.util.ArrayList;

public class PerishableList extends ItemList{



    public PerishableList(){
        super();
    }

    public void add(PerishableFood perishableFood){
        itemList.add(perishableFood);
    }
}
