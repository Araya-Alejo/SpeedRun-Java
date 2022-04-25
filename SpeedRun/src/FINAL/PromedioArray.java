package FINAL;

import java.util.Comparator;

public class PromedioArray implements Comparator<PromedioArray>{

    private String posición;
    private double promedio;

    public PromedioArray() {
    }

    public PromedioArray(String posición, double promedio) {
        this.posición = posición;
        this.promedio = promedio;
    }
    
    

    public String getPosición() {
        return posición;
    }

    public void setPosición(String posición) {
        this.posición = posición;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public int compare(PromedioArray t, PromedioArray t1) {

        if (t.getPromedio() < t1.getPromedio()) {
            return -1;
        } else if(t.getPromedio() > t1.getPromedio()){
            return 0;
        } else {
            return 1;
        }

    }

}
