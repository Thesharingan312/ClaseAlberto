public class CuentaCorriente extends Cuenta {
    private final double INTERES = 0.015; // 1.5% de interés fijo
    private final double RETIRO_MAXIMO = 1000.0;
    
    // Constructor parametrizado
    public CuentaCorriente(Persona cliente, Integer numeroCuenta) {
        super(cliente, numeroCuenta);
    }
    
    // Implementación del método retirar
    @Override
    public boolean retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser positiva");
            return false;
        }
        
        if (cantidad > RETIRO_MAXIMO) {
            System.out.println("No se puede retirar más de " + RETIRO_MAXIMO + "€ en una cuenta corriente");
            return false;
        }
        
        if (cantidad > saldo) {
            System.out.println("Saldo insuficiente. Saldo actual: " + saldo + "€");
            return false;
        }
        
        saldo -= cantidad;
        System.out.println("Se han retirado " + cantidad + "€. Saldo actual: " + saldo + "€");
        return true;
    }
    
    // Implementación del método actualizarSaldo
    @Override
    public void actualizarSaldo() {
        double interesGenerado = saldo * INTERES;
        saldo += interesGenerado;
        System.out.println("Saldo actualizado con interés del " + (INTERES * 100) + "%. Nuevo saldo: " + saldo + "€");
    }
    
    @Override
    public String toString() {
        return "CUENTA CORRIENTE\n" + super.toString() + 
               "\nInterés fijo: " + (INTERES * 100) + "%" +
                "\nRetiro máximo permitido: " + RETIRO_MAXIMO + "€";
    }
}