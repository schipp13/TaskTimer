package Models;


public class Timer {

    private String hours, minutes, seconds;

    public Timer(String hours, String minutes, String seconds)
    {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        
        
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
    public void setMinutes(String minutes){
        this.minutes = minutes;
    }
    public void setSeconds(String seconds) { this.seconds = seconds; }

    public String getHours(){
        return hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getSeconds() {
        return seconds;
    }
    
}
