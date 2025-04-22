public class PruebaPuertaCoche {
    public static void main(String[] args) {
        // Crear una puerta de coche con alarma
        PuertaCoche puerta = new PuertaCoche("Puerta delantera izquierda", 25.5, 350.0, true);
        
        System.out.println("=== INFORMACIÓN INICIAL DE LA PUERTA ===");
        puerta.mostrarAtributos();
        System.out.println();
        
        System.out.println("=== SECUENCIA DE PRUEBA 1: ABRIR Y CERRAR ===");
        puerta.abrir();  // Debería funcionar
        puerta.mostrarAtributos();
        System.out.println();
        
        puerta.cerrar();  // Debería funcionar
        puerta.mostrarAtributos();
        System.out.println();
        
        System.out.println("=== SECUENCIA DE PRUEBA 2: BLOQUEAR Y DESBLOQUEAR ===");
        puerta.bloquear();  // Debería bloquear y activar alarma
        puerta.mostrarAtributos();
        System.out.println();
        
        puerta.abrir();  // No debería abrir porque está bloqueada
        System.out.println();
        
        puerta.desbloquear();  // Debería desbloquear
        puerta.mostrarAtributos();
        System.out.println();
        
        System.out.println("=== SECUENCIA DE PRUEBA 3: MANEJO DE ALARMA ===");
        puerta.activarAlarma();  // Activar alarma manualmente
        puerta.mostrarAtributos();
        System.out.println();
        
        puerta.abrir();  // No debería abrir porque la alarma está activada
        System.out.println();
        
        puerta.desactivarAlarma();  // Desactivar alarma
        puerta.mostrarAtributos();
        System.out.println();
        
        puerta.abrir();  // Ahora debería poder abrir
        puerta.mostrarAtributos();
        System.out.println();
        
        System.out.println("=== SECUENCIA DE PRUEBA 4: COMPORTAMIENTO REALISTA ===");
        puerta.cerrar();  // Primero cerramos
        puerta.bloquear();  // Bloqueamos (esto activa la alarma automáticamente)
        puerta.mostrarAtributos();
        System.out.println();
        
        System.out.println("Simulando llegada del conductor:");
        puerta.desbloquear();  // Desbloqueamos
        puerta.desactivarAlarma();  // Desactivamos alarma
        puerta.abrir();  // Ahora podemos abrir
        puerta.mostrarAtributos();
        System.out.println();
        
        // Crear una puerta sin alarma para comparar
        System.out.println("=== PUERTA SIN ALARMA ===");
        PuertaCoche puertaSinAlarma = new PuertaCoche("Puerta trasera derecha", 22.0, 250.0, false);
        puertaSinAlarma.mostrarAtributos();
        System.out.println();
        
        puertaSinAlarma.activarAlarma();  // Debería indicar que no tiene alarma
        puertaSinAlarma.cerrar();
        puertaSinAlarma.bloquear();  // No debería activar alarma
        puertaSinAlarma.mostrarAtributos();
    }
}