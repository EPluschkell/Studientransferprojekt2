public class NonPerishable extends Item{


    public NonPerishable(String name, int quantity){
        super(name,quantity);
    }
    public NonPerishable(){
        super("defaultNonP",100);
    }

    @Override
    public String toString() {
        return getName()+" hat noch "+getQuantity()+" gramm.";
    }
}
