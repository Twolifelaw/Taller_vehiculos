package modelo;

public class Camion extends Vehiculo {

    /**
     * Atributos Camion
     */

    private double cap_carga;

    /**
     * Constructor vacio.
     */
    public Camion() {
    }

    /**
     * Constructor definiendo atributos.
     * 
     * @param placa
     * @param marca
     * @param referencia
     * @param modelo
     * @param precio
     * @param num_ruedas
     * @param cap_carga
     */

    public Camion(String placa, String marca, String referencia, String modelo, double precio, int num_ruedas,
            double cap_carga) {
        super(placa, marca, referencia, modelo, precio, num_ruedas);
        this.cap_carga = cap_carga;
    }

    /**
     * Metodo para imprimir.
     */

    @Override
    public String toString() {
        return super.toString() + // Llama al toString de la superclase (Vehiculo)
                ", capacidad de carga: " + cap_carga + ", Kl";
    }

    /**
     * Getters and Setters.
     * 
     * @return
     */

    public double getCap_carga() {
        return cap_carga;
    }

    public void setCap_carga(double cap_carga) {
        this.cap_carga = cap_carga;
    }

}
