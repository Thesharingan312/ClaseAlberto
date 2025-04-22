public class ComponenteDeCoche {
    protected String descripcion;
    protected double peso;
    protected double coste;
    protected boolean alarma;
    
    // Constructor
    public ComponenteDeCoche(String descripcion, double peso, double coste, boolean alarma) {
        this.descripcion = descripcion;
        this.peso = peso;
        this.coste = coste;
        this.alarma = alarma;
    }
    
    // Método para mostrar los atributos
    public void mostrarAtributos() {
        System.out.println("Descripción: " + descripcion);
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Coste: " + coste + " €");
        System.out.println("Tiene alarma: " + (alarma ? "Sí" : "No"));
    }
    
    // Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public boolean tieneAlarma() {
        return alarma;
    }

    public void setAlarma(boolean alarma) {
        this.alarma = alarma;
    }
}