package Models;


public class Timer {

    private int hours, minutes, seconds;

    public void setHours(int hours) {
        this.hours = hours;
    }
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }
    public void setSeconds(int seconds)
    {
        this.seconds = seconds;
    }

    public int getHours(){
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
