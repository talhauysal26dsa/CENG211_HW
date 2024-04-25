package entitiesLayer;

public class Date {
	private int day;
    private int month;
    private int year;

    public Date(String dateString) {
        String[] dateParts = dateString.split("/");
        if (dateParts.length != 3) {
            throw new IllegalArgumentException("Invalid date format. Please provide day.month.year");
        }

        this.day = Integer.parseInt(dateParts[0]);
        this.month = Integer.parseInt(dateParts[1]);
        this.year = Integer.parseInt(dateParts[2]);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%d", day, month, year);
    }


}
