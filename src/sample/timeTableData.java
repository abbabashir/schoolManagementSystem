package sample;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class timeTableData {
    final StringProperty Monday;
    final StringProperty Tuesday;
    final StringProperty Wednesday;
    final StringProperty Thursday;
    final StringProperty Friday;
    final StringProperty Saturday;

    public timeTableData(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday){
        this.Monday = new SimpleStringProperty(monday);
        this.Tuesday = new SimpleStringProperty(tuesday);
        this.Wednesday = new SimpleStringProperty(wednesday);
        this.Thursday = new SimpleStringProperty(thursday);
        this.Friday = new SimpleStringProperty(friday);
        this.Saturday = new SimpleStringProperty(saturday);
    }

    public String getMonday() {
        return Monday.get();
    }

    public StringProperty mondayProperty() {
        return Monday;
    }

    public void setMonday(String monday) {
        this.Monday.set(monday);
    }

    public String getTuesday() {
        return Tuesday.get();
    }

    public StringProperty tuesdayProperty() {
        return Tuesday;
    }

    public void setTuesday(String tuesday) {
        this.Tuesday.set(tuesday);
    }

    public String getWednesday() {
        return Wednesday.get();
    }

    public StringProperty wednesdayProperty() {
        return Wednesday;
    }

    public void setWednesday(String wednesday) {
        this.Wednesday.set(wednesday);
    }

    public String getThursday() {
        return Thursday.get();
    }

    public StringProperty thursdayProperty() {
        return Thursday;
    }

    public void setThursday(String thursday) {
        this.Thursday.set(thursday);
    }

    public String getFriday() {
        return Friday.get();
    }

    public StringProperty fridayProperty() {
        return Friday;
    }

    public void setFriday(String friday) {
        this.Friday.set(friday);
    }

    public String getSaturday() {
        return Saturday.get();
    }

    public StringProperty saturdayProperty() {
        return Saturday;
    }

    public void setSaturday(String saturday) {
        this.Saturday.set(saturday);
    }
}
