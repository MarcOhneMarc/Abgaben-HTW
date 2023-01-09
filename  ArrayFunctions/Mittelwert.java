public class Mittelwert {

    public ArrayFunctions arrayFunctions;
    private double mittelwert;
    private double min;
    private double max;

    public Mittelwert(double mittelwert, double min, double max){
        this.mittelwert = mittelwert;
        this.min = min;
        this.max = max;
        System.out.println(mittelwert + " " + min + " " + max);

    }

    public double getMittelwert(){
        return mittelwert;
    }

    public double getMin(){
        return min;
    }

    public double getMax(){
        return max;
    }

}
