import java.util.ArrayList;
import java.util.Comparator;

public abstract class ItemList {

    protected ArrayList<Item> itemList;
    
    public ItemList() {
        this.itemList = new ArrayList<>();
    }

    public void add(Item item){
        itemList.add(item);
    }

    public void remove(Item item){
        itemList.remove(item);
    }

    public void sortByName() {
        itemList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.name.compareTo(item2.name);
            }
        });
    }

        public void sortByMHD() {
            itemList.sort(new Comparator<Item>() {
                @Override
                public int compare(Item item1, Item item2) {
                    return item1.bestBeforeDate.compareTo(item2.bestBeforeDate);
                }
            });
        }
    }

