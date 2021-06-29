package Models;

public class Timer {

    private String hours, minutes, seconds;

    public Timer(String Hours, String Minutes, String Seconds){

        this.hours = Hours;
        this.minutes = Minutes;
        this.seconds = Seconds;

    }

    public void setHours(String hours) {
        this.hours = hours;
    }
    public void setMinutes(String minutes){
        this.minutes = minutes;
    }
    public void setSeconds(String seconds) { this.seconds = seconds; }

    public  String getHours(){
        return hours;
    }

    public  String getMinutes() {
        return minutes;
    }

    public  String getSeconds() {
        return seconds;
    }
}
