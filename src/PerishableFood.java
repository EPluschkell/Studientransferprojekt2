import java.time.LocalDate;

public class PerishableFood extends Item{

    private Boolean isOpen;

    private Boolean isGram;

    private Boolean isExpired;

    public PerishableFood(String name, int quantity, LocalDate bestBefore, Boolean isGram){
        super(name, quantity,bestBefore);
        this.isGram=isGram;
        this.isOpen = false;
        calculateExpiredStatus();
    }

    public PerishableFood(){
        super("default",500,LocalDate.now());
        this.isGram=true;
        this.isOpen = false;
        calculateExpiredStatus();
    }

    public void Open(){
        isOpen=true;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void calculateExpiredStatus(){
        isExpired = daysBetweenDates(LocalDate.now(), bestBeforeDate)<0;
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
            return name + " mit Ablaufdatum "+ bestBeforeDate +" ist abgelaufen. "+ quantity +unit+", "+isOpenString;
        } else if (timeLeft == 0) {
            return name + " mit Ablaufdatum "+ bestBeforeDate +" läuft heute ab. "+ quantity +unit+", "+isOpenString;
        }
        return name + " mit Ablaufdatum "+ bestBeforeDate +", "+timeLeft+" Tage übrig. "+ quantity +unit+", "+isOpenString;
    }

}
