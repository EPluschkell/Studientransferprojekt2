public class Pantry {
    PerishableList perishableList;
    NonPerishableList nonPerishableList;

    public Pantry(){

    }

    public void addPerishable(PerishableFood food){
        perishableList.add(food);
    }

    public void addMisc(NonPerishable nonPerishable){
        nonPerishableList.add(nonPerishable);
    }
}
