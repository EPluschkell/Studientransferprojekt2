import java.util.ArrayList;
import java.util.Comparator;

public abstract class ItemList<T extends Item> {

    protected ArrayList<T> itemList;

    public ItemList() {
        this.itemList = new ArrayList<>();
    }

    public void add(T item){
        itemList.add(item);
    }

    public void remove(T item){
        itemList.remove(item);
    }

    public void sortByName() {
        itemList.sort(new Comparator<T>() {
            @Override
            public int compare(T item1, T item2) {
                return item1.getName().compareTo(item2.getName());
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (T t : itemList) {
            text.append("\n").append(t.toString());
        }
        return text.toString();
    }
}

