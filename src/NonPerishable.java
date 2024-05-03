import java.time.LocalDate;

public class NonPerishable extends Item{


    public NonPerishable(String name, int quantity){
        super(name,quantity,LocalDate.MAX);
    }
    public NonPerishable(){
        super("defaultNonP",100, LocalDate.MAX);
    }
}
