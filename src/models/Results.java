package models;

public class Results {

    private int sampleSize;
    private String functionName;
    private int timeResult;

    public Results(int sampleSize, String functionName, int timeResult) {
        this.sampleSize = sampleSize;
        this.functionName = functionName;
        this.timeResult = timeResult;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public String getFunctionName() {
        return functionName;
    }
}
