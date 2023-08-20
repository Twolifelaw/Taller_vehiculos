package modelo;

public class Moto extends Vehiculo {

    /**
     * Atributos de moto
     */
    private double tam_tanque;
    private double cilindraje;

    /**
     * Constructo vacio.
     */
    public Moto() {
    }

    /**
     * Constructor con atrubutos definidos.
     * 
     * @param placa
     * @param marca
     * @param referencia
     * @param modelo
     * @param precio
     * @param num_ruedas
     * @param cilindraje
     * @param tam_tanque
     */

     public Moto(String placa, String marca, String referencia, String modelo, double precio, int num_ruedas,
            double cilindraje, double tam_tanque) {
        super(placa, marca, referencia, modelo, precio, num_ruedas);
        this.cilindraje = cilindraje;
        this.tam_tanque = tam_tanque;
    }
        
    /**
     * Metodo para imprimir.
     */

    @Override
    public String toString() {
        return super.toString() + // Llama al toString de la superclase (Vehiculo)
                ", Cilindraje: " + cilindraje + ", tamaño tanque: " + tam_tanque;
    }

    /**
     * Getters and Settersb
     * 
     * @return
     */

    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public double getTam_tanque() {
        return tam_tanque;
    }

    public void setTam_tanque(double tam_tanque) {
        this.tam_tanque = tam_tanque;
    }

}
