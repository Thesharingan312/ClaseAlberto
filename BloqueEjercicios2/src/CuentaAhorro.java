public class CuentaAhorro extends Cuenta {
    private double interes; // Interés variable
    private final double SALDO_MINIMO = 300.0; // Saldo mínimo necesario
    
    // Constructor parametrizado
    public CuentaAhorro(Persona cliente, Integer numeroCuenta, double interes) {
        super(cliente, numeroCuenta);
        this.interes = interes;
        this.saldo = SALDO_MINIMO; // Inicializa con el saldo mínimo
    }
    
    // Getter y Setter para el interés
    public double getInteres() {
        return interes;
    }
    
    public void setInteres(double interes) {
        this.interes = interes;
        System.out.println("Interés cambiado al " + (interes * 100) + "%");
    }
    
    // Implementación del método retirar
    @Override
    public boolean retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser positiva");
            return false;
        }
        
        // Verificamos que después de retirar, el saldo no sea menor que el mínimo
        if ((saldo - cantidad) < SALDO_MINIMO) {
            System.out.println("No se puede retirar. Debe mantener un saldo mínimo de " + SALDO_MINIMO + "€");
            return false;
        }
        
        saldo -= cantidad;
        System.out.println("Se han retirado " + cantidad + "€. Saldo actual: " + saldo + "€");
        return true;
    }
    
    // Implementación del método actualizarSaldo
    @Override
    public void actualizarSaldo() {
        double interesGenerado = saldo * interes;
        saldo += interesGenerado;
        System.out.println("Saldo actualizado con interés del " + (interes * 100) + "%. Nuevo saldo: " + saldo + "€");
    }
    
    @Override
    public String toString() {
        return "CUENTA AHORRO\n" + super.toString() + 
               "\nInterés variable: " + (interes * 100) + "%" +
                "\nSaldo mínimo requerido: " + SALDO_MINIMO + "€";
    }
}