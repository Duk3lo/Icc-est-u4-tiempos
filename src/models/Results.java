package models;

public class Results {

    private int sampleSize;
    private String functionName;
    private double timeResult;

    public Results(int sampleSize, String functionName, double timeResult) {
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

    @Override
    public String toString(){
        return "La funcion " + functionName + " ejecutada: " + sampleSize +" veces, tuvo una duracion de: "+ timeResult + " segundos";
    }
}
