import java.util.ArrayList;

public class Pantry {
    ArrayList<PerishableFood> perishableList;
    ArrayList<Item> miscellaneousList;

    public Pantry(){
        perishableList =new ArrayList<>();
        miscellaneousList =new ArrayList<>();
    }

    public void addPerishable(PerishableFood food){
        perishableList.add(food);
    }

    public void addMisc(Item item){
        miscellaneousList.add(item);
    }
}
