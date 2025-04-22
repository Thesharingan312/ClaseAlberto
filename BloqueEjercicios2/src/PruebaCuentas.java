public class PruebaCuentas {
    public static void main(String[] args) {
        // Creamos algunos clientes
        Persona cliente1 = new Persona("Juan", "García López", "12345678A");
        Persona cliente2 = new Persona("María", "Rodríguez Sánchez", "98765432B");
        
        // Creamos las cuentas
        CuentaCorriente cc = new CuentaCorriente(cliente1, 100001);
        CuentaAhorro ca = new CuentaAhorro(cliente2, 200001, 0.02); // 2% de interés inicial
        
        System.out.println("=== INFORMACIÓN INICIAL DE LAS CUENTAS ===");
        System.out.println(cc);
        System.out.println("\n" + ca);
        
        System.out.println("\n=== OPERACIONES CON CUENTA CORRIENTE ===");
        cc.ingresar(2000);
        cc.retirar(500);
        cc.retirar(1500); // Debería fallar por superar el máximo
        cc.actualizarSaldo();
        
        System.out.println("\n=== OPERACIONES CON CUENTA AHORRO ===");
        ca.ingresar(1000);
        ca.retirar(200);
        ca.retirar(900); // Debería fallar por no mantener el saldo mínimo
        ca.setInteres(0.03); // Cambiamos el interés al 3%
        ca.actualizarSaldo();
        
        System.out.println("\n=== INFORMACIÓN FINAL DE LAS CUENTAS ===");
        System.out.println(cc);
        System.out.println("\n" + ca);
    }
}