package FINAL_FEBRERO;

public class ProductoManufacturado {

    private int codigo;
    private String denominacion;
    private int tiempoFabricacion;
    private String[][] insumos[][];
    private double margenGanancia;

    public ProductoManufacturado() {
    }

    public ProductoManufacturado(int codigo, String denominacion, int tiempoFabricacion, String[][][][] insumos, double margenGanancia) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.tiempoFabricacion = tiempoFabricacion;
        this.insumos = insumos;
        this.margenGanancia = margenGanancia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getTiempoFabricacion() {
        return tiempoFabricacion;
    }

    public void setTiempoFabricacion(int tiempoFabricacion) {
        this.tiempoFabricacion = tiempoFabricacion;
    }

    public String[][][][] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[][][][] insumos) {
        this.insumos = insumos;
    }

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }
    
    

}
