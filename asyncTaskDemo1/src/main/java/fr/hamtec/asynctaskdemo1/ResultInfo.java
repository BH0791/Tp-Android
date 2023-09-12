package fr.hamtec.asynctaskdemo1;

public class ResultInfo {
    private boolean completed;
    private long workTimeInMillis;
    
    public ResultInfo(boolean completed, long workTimeInMillis) {
        this.completed = completed;
        this.workTimeInMillis = workTimeInMillis;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public long getWorkTimeInMillis() {
        return workTimeInMillis;
    }
    
    public String getMessage() {
        if(this.completed)  {
            return "Complete in " + this.workTimeInMillis +" milliseconds";
        }
        return "Failed or cancelled";
    }
}
