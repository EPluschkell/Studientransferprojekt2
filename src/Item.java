import java.time.LocalDate;

public abstract class Item {
    String name;

    int quantity;

    LocalDate bestBeforeDate;

    public Item(String name, int quantity, LocalDate bestBefore){
        this.name=name;
        this.quantity=quantity;
        this.bestBeforeDate=bestBefore;
    }

}
