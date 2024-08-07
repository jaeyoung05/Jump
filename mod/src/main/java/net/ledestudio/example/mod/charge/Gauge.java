package net.ledestudio.example.mod.charge;

public class Gauge {

    private double gauge;

    public double getGauge() {
        return gauge;
    }

    public void setGauge(double gauge) {
        this.gauge = gauge;
        if (gauge >= 10){
            this.gauge = 10;
        } else {
            this.gauge = gauge;
        }
    }

    public void gaugeUp(){
        setGauge(getGauge() + 0.1);
    }


}
