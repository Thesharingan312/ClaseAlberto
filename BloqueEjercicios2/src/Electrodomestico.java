public class Electrodomestico {
    private double consumo;
    private String modelo;
    
    public Electrodomestico(double c, String m) {
        consumo = c;
        modelo = m;
    }
    
    public String toString() {
        return "Modelo: " + modelo + " Consumo: " + consumo;
    }
    
    // Getters añadidos para acceder a los atributos desde las subclases
    public double getConsumo() {
        return consumo;
    }
    
    public String getModelo() {
        return modelo;
    }
}