public class Frigorifico extends Electrodomestico implements MuestraInformacion {
    private double temperatura;
    
    // Constructor
    public Frigorifico(double c, String m, double t) {
        // Llamamos al constructor de la clase padre
        super(c, m);
        this.temperatura = t;
    }
    
    // Implementación del método toString
    @Override
    public String toString() {
        // Utilizamos el método toString de la clase padre y añadimos la temperatura
        return super.toString() + " Temperatura: " + temperatura + "°C";
    }
    
    // Implementación del método muestra de la interfaz MuestraInformacion
    @Override
    public String muestra() {
        return "La temperatura actual del frigorífico " + getModelo() + " es: " + temperatura + "°C";
    }
    
    // Getters y setters para temperatura
    public double getTemperatura() {
        return temperatura;
    }
    
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}