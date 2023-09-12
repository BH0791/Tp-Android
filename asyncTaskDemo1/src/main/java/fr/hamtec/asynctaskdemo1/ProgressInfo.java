package fr.hamtec.asynctaskdemo1;

public class ProgressInfo {
    private int progress;
    private String workingInfo;
    
    public ProgressInfo(int progress, String workingInfo) {
        this.progress = progress;
        this.workingInfo = workingInfo;
    }
    public int getProgress() {
        return progress;
    }
    
    public String getWorkingInfo() {
        return workingInfo;
    }
}
