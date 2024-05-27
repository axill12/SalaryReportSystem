import java.time.LocalDate;

public class Record {

    private String ID;

    //For in housed employees it should be true, while for outsourced ones it should be false.
    private boolean inHouse;

    private LocalDate date;

    private float hours;

    private short hourlyRate;

    private short fixedCost;

    public Record (String ID, boolean inHouse, LocalDate date, float hours, short hourlyRate, short fixedCost) {
        this.ID = ID;
        this.inHouse = inHouse;
        this.date = date;
        this.hours = hours;
        this.hourlyRate = hourlyRate;
        this.fixedCost = fixedCost;
    }

    //It computes cost for one record.
    float costForRecord () {
        return hours * hourlyRate + fixedCost;
    }

    public String getID() {
        return ID;
    }

    public boolean isInHouse() {
        return inHouse;
    }

    public LocalDate getDate() {
        return date;
    }

    public float getHours() {
        return hours;
    }

    public short getHourlyRate() {
        return hourlyRate;
    }

    public short getFixedCost() {
        return fixedCost;
    }


}
