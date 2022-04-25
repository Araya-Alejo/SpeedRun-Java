package parcial1;

public class DDJJIngresoFertilizante {

    private int anioDeclaracion;
    private int mesDeclaracion;
    private double montoXIngreso;
    private String empresa;
    private long cuitEmpresa;
    private String[][] detallesFertilizantes;

    public DDJJIngresoFertilizante() {
    }

    public DDJJIngresoFertilizante(int anioDeclaracion, int mesDeclaracion, double montoXIngreso, String empresa, long cuitEmpresa, String[][] detallesFertilizantes) {
        this.anioDeclaracion = anioDeclaracion;
        this.mesDeclaracion = mesDeclaracion;
        this.montoXIngreso = montoXIngreso;
        this.empresa = empresa;
        this.cuitEmpresa = cuitEmpresa;
        this.detallesFertilizantes = detallesFertilizantes;
    }

    
    
    public int getAnioDeclaracion() {
        return anioDeclaracion;
    }

    public void setAnioDeclaracion(int anioDeclaracion) {
        this.anioDeclaracion = anioDeclaracion;
    }

    public int getMesDeclaracion() {
        return mesDeclaracion;
    }

    public void setMesDeclaracion(int mesDeclaracion) {
        this.mesDeclaracion = mesDeclaracion;
    }

    public double getMontoXIngreso() {
        return montoXIngreso;
    }

    public void setMontoXIngreso(double montoXIngreso) {
        this.montoXIngreso = montoXIngreso;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public long getCuitEmpresa() {
        return cuitEmpresa;
    }

    public void setCuitEmpresa(long cuitEmpresa) {
        this.cuitEmpresa = cuitEmpresa;
    }

    public String[][] getDetallesFertilizantes() {
        return detallesFertilizantes;
    }

    public void setDetallesFertilizantes(String[][] detallesFertilizantes) {
        this.detallesFertilizantes = detallesFertilizantes;
    }
    
    

}
