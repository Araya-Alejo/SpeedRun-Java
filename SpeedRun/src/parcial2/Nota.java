
package parcial2;

import java.util.Scanner;

public class Nota {
    
    static Scanner sc = new Scanner(System.in);
    
    private String fechaExamen ;
    private String valorNota ;

    public Nota() {
    }

    public Nota(String fechaExamen, String valorNota) {
        this.fechaExamen = fechaExamen;
        this.valorNota = valorNota;
    }

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getValorNota() {
        return valorNota;
    }

    public void setValorNota(String valorNota) {
        this.valorNota = valorNota;
    }
    
    
    
}
