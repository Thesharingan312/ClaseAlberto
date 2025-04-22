public abstract class Cuenta {
    protected Integer numeroCuenta;
    protected double saldo;
    protected Persona cliente;
    
    // Constructor parametrizado
    public Cuenta(Persona cliente, Integer numeroCuenta) {
        this.cliente = cliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0.0; // Saldo inicial a cero
    }
    
    // Getters y Setters
    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }
    
    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public Persona getCliente() {
        return cliente;
    }
    
    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }
    
    // Método para ingresar dinero
    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Se ha ingresado " + cantidad + "€. Saldo actual: " + saldo + "€");
        } else {
            System.out.println("La cantidad a ingresar debe ser positiva");
        }
    }
    
    // Método abstracto para retirar dinero
    public abstract boolean retirar(double cantidad);
    
    // Método para actualizar el saldo
    public abstract void actualizarSaldo();
    
    @Override
    public String toString() {
        return "Cuenta número: " + numeroCuenta + 
                "\nCliente: " + cliente + 
                "\nSaldo: " + saldo + "€";
    }
}