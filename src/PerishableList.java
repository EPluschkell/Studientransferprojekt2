import java.util.Comparator;

public class PerishableList extends ItemList<PerishableFood>{

    public PerishableList(){
        super();
    }
    
    public void sortByMHD() {
        itemList.sort(new Comparator<PerishableFood>() {
            @Override
            public int compare(PerishableFood item1, PerishableFood item2) {
                return item1.getBestBeforeDate().compareTo(item2.getBestBeforeDate());
            }
        });
    }
}