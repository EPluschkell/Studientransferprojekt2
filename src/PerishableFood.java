import java.time.LocalDate;

public class PerishableFood extends Item{

    private Boolean isOpen;

    private Boolean isGram;

    private Boolean isExpired;

    private LocalDate bestBeforeDate;

    public PerishableFood(String name, int quantity, LocalDate bestBefore, Boolean isGram){
        super(name, quantity);
        this.bestBeforeDate=bestBefore;
        this.isGram=isGram;
        this.isOpen = false;
        calculateExpiredStatus();
    }
    
    // default constructor
    public PerishableFood(){
        super("default",500);
        this.bestBeforeDate=LocalDate.now();
        this.isGram=true;
        this.isOpen = false;
        calculateExpiredStatus();
    }

    public void openContainer(){
        isOpen=true;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public Boolean getGram() {
        return isGram;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void calculateExpiredStatus(){
        isExpired = daysBetweenDates(LocalDate.now(), bestBeforeDate)<0;
    }

    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }

    public static long daysBetweenDates(LocalDate date1, LocalDate date2) {
        // datum1  = heute, datum2 = mhd
        long Tage = date2.toEpochDay() - date1.toEpochDay();
        return Tage;
    }

    @Override
    public String toString(){
        String isOpenString = isOpen ? "Angebrochen" : "nicht Angebrochen";
        String unit = isGram ? "g" : "ml";
        long timeLeft = daysBetweenDates(LocalDate.now(), bestBeforeDate);

        if(timeLeft<0){
            return getName() + " mit Ablaufdatum "+ bestBeforeDate +" ist abgelaufen. "+ getQuantity() +unit+", "+isOpenString;
        } else if (timeLeft == 0) {
            return getName() + " mit Ablaufdatum "+ bestBeforeDate +" läuft heute ab. "+ getQuantity() +unit+", "+isOpenString;
        }
        return getName() + " mit Ablaufdatum "+ bestBeforeDate +", "+timeLeft+" Tage übrig. "+ getQuantity() +unit+", "+isOpenString;
    }

}
