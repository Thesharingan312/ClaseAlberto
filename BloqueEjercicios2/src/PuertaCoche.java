public class PuertaCoche extends ComponenteDeCoche implements PuertaBloqueable, Alarma {
    private boolean estaBloqueada;
    private boolean estaAbierta;
    private boolean alarmaActivada;
    
    // Constructor
    public PuertaCoche(String descripcion, double peso, double coste, boolean tieneAlarma) {
        super(descripcion, peso, coste, tieneAlarma);
        this.estaBloqueada = false;
        this.estaAbierta = false;
        this.alarmaActivada = false;
    }
    
    // Implementación de Puerta
    @Override
    public void abrir() {
        if (estaBloqueada) {
            System.out.println("No se puede abrir la puerta porque está bloqueada.");
            return;
        }
        
        if (alarmaActivada && alarma) {
            System.out.println("No se puede abrir la puerta porque la alarma está activada.");
            return;
        }
        
        if (!estaAbierta) {
            estaAbierta = true;
            System.out.println("Puerta abierta.");
        } else {
            System.out.println("La puerta ya estaba abierta.");
        }
    }
    
    @Override
    public void cerrar() {
        if (estaAbierta) {
            estaAbierta = false;
            System.out.println("Puerta cerrada.");
        } else {
            System.out.println("La puerta ya estaba cerrada.");
        }
    }
    
    // Implementación de PuertaBloqueable
    @Override
    public void bloquear() {
        if (estaAbierta) {
            System.out.println("No se puede bloquear una puerta abierta. Cierre la puerta primero.");
            return;
        }
        
        if (!estaBloqueada) {
            estaBloqueada = true;
            System.out.println("Puerta bloqueada.");
            
            // Al bloquear, se activa la alarma automáticamente
            if (alarma && !alarmaActivada) {
                activarAlarma();
            }
        } else {
            System.out.println("La puerta ya estaba bloqueada.");
        }
    }
    
    @Override
    public void desbloquear() {
        if (estaBloqueada) {
            estaBloqueada = false;
            System.out.println("Puerta desbloqueada.");
        } else {
            System.out.println("La puerta ya estaba desbloqueada.");
        }
    }
    
    // Implementación de Alarma
    @Override
    public boolean estaAlarmaActivada() {
        return alarmaActivada;
    }
    
    @Override
    public void activarAlarma() {
        if (!alarma) {
            System.out.println("Este componente no tiene alarma.");
            return;
        }
        
        if (!alarmaActivada) {
            alarmaActivada = true;
            System.out.println("Alarma activada.");
        } else {
            System.out.println("La alarma ya estaba activada.");
        }
    }
    
    @Override
    public void desactivarAlarma() {
        if (!alarma) {
            System.out.println("Este componente no tiene alarma.");
            return;
        }
        
        if (alarmaActivada) {
            alarmaActivada = false;
            System.out.println("Alarma desactivada.");
        } else {
            System.out.println("La alarma ya estaba desactivada.");
        }
    }
    
    // Métodos adicionales
    public boolean estaAbierta() {
        return estaAbierta;
    }
    
    public boolean estaBloqueada() {
        return estaBloqueada;
    }
    
    // Sobrescribir el método mostrarAtributos para incluir los estados específicos de la puerta
    @Override
    public void mostrarAtributos() {
        super.mostrarAtributos();
        System.out.println("Estado: " + (estaAbierta ? "Abierta" : "Cerrada"));
        System.out.println("Bloqueada: " + (estaBloqueada ? "Sí" : "No"));
        if (alarma) {
            System.out.println("Alarma: " + (alarmaActivada ? "Activada" : "Desactivada"));
        }
    }
}