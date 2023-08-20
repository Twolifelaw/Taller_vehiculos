package modelo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import controlador.main;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Concesionario {

    /**
     * Arraylis que contiene la informacion de cada tipo de vehiculo
     */

    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArrayList<Vehiculo> vehiculos_vendidos = new ArrayList<>();
    private static double venta_totales = 0;
    private int contadorMotos;

    /**
     * Metodo para registrar vehiculos.
     * 
     * @param vehiculo
     */

    public void registrarVehiculos(Vehiculo vehiculo) {
        // Verificar si la placa ya existe
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca())) {
                System.out.println("No se puede registrar el vehículo. Ya existe una placa con el mismo número.");
                return;
            }
        }

        vehiculos.add(vehiculo);
        System.out.println("Se registró correctamente!");
    }

    /**
     * Metodo para buscar vehiculos.
     * 
     * @param clave
     */

    public void buscarVehiculo(String clave) {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");

        } else {
            for (Vehiculo vehiculo : vehiculos) {// Compara los daos de vehiculo con palabra clave para encontrar el
                                                 // vehiculo.
                if (vehiculo.getPlaca().equalsIgnoreCase(clave) ||
                        vehiculo.getMarca().equalsIgnoreCase(clave) ||
                        vehiculo.getReferencia().equalsIgnoreCase(clave) ||
                        vehiculo.getModelo().equalsIgnoreCase(clave)) {
                    System.out.println("!Vehiculo encontrado! - Tipo: " + vehiculo.getClass().getSimpleName());
                    if (vehiculo instanceof Moto) {// Muestra los datos segun el vehiculo mediante un instanceof
                        Moto moto = (Moto) vehiculo;
                        System.out.println(moto.toString()); // Imprime los atributos específicos de Moto
                    } else if (vehiculo instanceof Auto) {
                        Auto auto = (Auto) vehiculo;
                        System.out.println(auto.toString()); // Imprime los atributos específicos de Auto
                    } else if (vehiculo instanceof Camion) {
                        Camion camion = (Camion) vehiculo;
                        System.out.println(camion.toString()); // Imprime los atributos específicos de Camión
                    }

                    return;
                } else {
                    try {
                        double valorNumerico = Double.parseDouble(clave);// convierte la palabra clave en double para
                                                                         // poder buscarla.
                        if (Math.abs(vehiculo.getPrecio() - valorNumerico) < 0.01) {
                            System.out.println("!Vehiculo encontrado! - Tipo: " + vehiculo.getClass().getSimpleName());
                            if (vehiculo instanceof Moto) {
                                Moto moto = (Moto) vehiculo;
                                System.out.println(moto.toString()); // Imprime los atributos específicos de Moto
                            } else if (vehiculo instanceof Auto) {
                                Auto auto = (Auto) vehiculo;
                                System.out.println(auto.toString()); // Imprime los atributos específicos de Auto
                            } else if (vehiculo instanceof Camion) {
                                Camion camion = (Camion) vehiculo;
                                System.out.println(camion.toString()); // Imprime los atributos específicos de Camión
                            }
                            return; // Sale del método después de encontrar el vehículo
                        }
                    } catch (NumberFormatException e) {
                        // No hace nada, simplemente continúa con la iteración
                    }
                }
            }
            System.out.println("No se pudo encontrar el vehiculo. Intente de nuevo");

        }

    }

    /**
     * Muestra los vehiculos que estan listados segun su tipo.
     */

    public void mostrarVehiculosPorTipo() {
        if (vehiculos.isEmpty()) {// verifica si el arreglo esta vacio.
            System.out.println("No hay vehiculos registrados");
        } else {
            System.out.println("Listado de vehículos por tipo:");
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println("Tipo: " + vehiculo.getClass().getSimpleName());
                // muestra los datos de cada tipo de vehiculo segun su tipo.
                if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                    System.out.println(moto.toString()); // Usa el toString() de Moto
                } else if (vehiculo instanceof Auto) {
                    Auto auto = (Auto) vehiculo;
                    System.out.println(auto.toString()); // Usa el toString() de Auto
                } else if (vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;
                    System.out.println(camion.toString()); // Usa el toString() de Camion
                }

            }

        }

    }

    /**
     * Metodo para mostrar lista de vehiculos vendidos.
     */

    public void mostrarVehiculosVendidosPorTipo() {
        if (vehiculos_vendidos.isEmpty()) {// verifica si el arreglo esta vacio.
            System.out.println("No hay vehiculos vendidos registrados");
        } else {
            System.out.println("Listado de vehículos vendidos por tipo:");
            for (Vehiculo vehiculo : vehiculos_vendidos) {
                System.out.println("Tipo: " + vehiculo.getClass().getSimpleName());

                if (vehiculo instanceof Moto) {
                    Moto moto = (Moto) vehiculo;
                    System.out.println(moto.toString()); // Usa el toString() de Moto
                } else if (vehiculo instanceof Auto) {
                    Auto auto = (Auto) vehiculo;
                    System.out.println(auto.toString()); // Usa el toString() de Auto
                } else if (vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;
                    System.out.println(camion.toString()); // Usa el toString() de Camion
                }

            }

        }
    }

    /**
     * Metodo para vender vehiculos.
     * 
     * @param placa
     */

    public void venderVehiculo(String placa) { // 4. Vender vehiculo y dejar un registro del vehiculo que se vendio.
        if (vehiculos.isEmpty()) {// verifica si el arreglo esta vacio.
            System.out.println("No hay vehiculos registrados.");

        } else {
            Vehiculo vehiculo_vendido = null;
            for (Vehiculo vehiculo : vehiculos) {// Si encuentra las placas, vevhiculo toma el valor del vehiculo
                                                 // encontrado.
                if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {// a su vez monto toma el valor de el vehiculo y luego
                                                                  // las ventas totales toma ese valor y se lo suma.
                    vehiculo_vendido = vehiculo;
                    double monto = vehiculo.getPrecio();
                    venta_totales += monto;
                    break;
                }
            }

            if (vehiculo_vendido != null) {// aqui el vehiculo vendio se retira de vehiculos y se agrega al arraylist de
                                           // vehiculos vendidos.
                vehiculos.remove(vehiculo_vendido);
                vehiculos_vendidos.add(vehiculo_vendido);
                System.out.println("Tipo: " + vehiculo_vendido.getClass().getSimpleName());
                System.out.println("vehiculo vendido: " + vehiculo_vendido.toString());
            } else {
                System.out.println("No se encontro el vehiculo con las placas especificadas.");
            }

        }

    }

    /**
     * Muestra los vehiculos en stock segun su tipo.
     */

    public void mostrarVehiculoStock() {// 5. mostrar el stock de vehiculos.
        int contador_motos = 0;
        int contador_autos = 0;
        int contador_camiones = 0;
        for (Vehiculo vehiculo : vehiculos) {// si el tipo de vehiculo se encuentra dentro del arraylist los contadores
                                             // por su tipo se van sumando.
            if (vehiculo instanceof Moto) {
                contadorMotos++;
            } else if (vehiculo instanceof Auto) {
                contador_autos++;
            } else if (vehiculo instanceof Camion) {
                contador_camiones++;
            }
        }
        System.out.println("Cantidad de motos en stock: " + contadorMotos);
        System.out.println("Cantidad de autos en stock: " + contador_autos);
        System.out.println("Cantidad de camiones en stock: " + contador_camiones);
    }

    /**
     * Muestra los vehiculos vendidos segun su tipo.
     */

    public void mostrarVehiculosVendidos() {// mostrar la cantida de autos vendidos.
        int contadorMotos = 0;
        int contadorAutos = 0;
        int contadorCamiones = 0;

        for (Vehiculo vehiculo : vehiculos_vendidos) {// si el tipo de vehiculo se encuentra dentro los contadores por
                                                      // su tipo se van sumando.
            if (vehiculo instanceof Moto) {
                contadorMotos++;
            } else if (vehiculo instanceof Auto) {
                contadorAutos++;
            } else if (vehiculo instanceof Camion) {
                contadorCamiones++;
            }
        }

        System.out.println("Cantidad de motos vendidas: " + contadorMotos);
        System.out.println("Cantidad de autos vendidos: " + contadorAutos);
        System.out.println("Cantidad de camiones vendidos: " + contadorCamiones);
    }

    /**
     * Actualiza los datos del vehiculo segun su tipo pide mas.
     * 
     * @param placa
     */

    public void actualizarDatosVehiculo(String placa) {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");

        } else {
            Scanner entrada = new Scanner(System.in);
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {// Si el vehiculo existe inicia el metodo de
                                                                  // actualizar datos
                    System.out.println("Datos actuales del vehículo:");
                    System.out.println(vehiculo.toString());

                    // Actualización de atributos generales
                    System.out.println("Ingrese la placa a actualizar:");
                    String nueva_placa = entrada.next();
                    vehiculo.setPlaca(nueva_placa);

                    System.out.println("Ingrese la marca a actualizar:");
                    String nueva_marca = entrada.next();
                    vehiculo.setMarca(nueva_marca);

                    System.out.println("Ingrese la referencia a actualizar:");
                    String nueva_referencia = entrada.next();
                    vehiculo.setReferencia(nueva_referencia);

                    System.out.println("Ingrese el modelo a actualizar:");
                    String nuevo_modelo = entrada.next();
                    vehiculo.setModelo(nuevo_modelo);

                    double nuevo_precio = main.ingresarNumero(entrada, "ingrese el precio a actualizar");
                    vehiculo.setPrecio(nuevo_precio);

                    // Actualización de atributos adicionales según el tipo de vehículo
                    if (vehiculo instanceof Moto) {
                        Moto moto = (Moto) vehiculo;
                        double cilindraje = main.ingresarNumero(entrada, "Ingrese el cilindraje de la moto:");
                        moto.setCilindraje(cilindraje);

                        double tamTanque = main.ingresarNumero(entrada, "Ingrese el tamaño del tanque de la moto:");
                        moto.setTam_tanque(tamTanque);

                    } else if (vehiculo instanceof Auto) {
                        Auto auto = (Auto) vehiculo;
                        int numPuertas = (int) main.ingresarNumero(entrada, "Ingrese el número de puertas del auto:");
                        auto.setNum_puertas(numPuertas);

                        boolean is_gasolina = main.isGasolina(entrada, "ingrese la actualizacion de combustible: ");
                        auto.setGasolina(is_gasolina);

                    } else if (vehiculo instanceof Camion) {
                        Camion camion = (Camion) vehiculo;
                        double capCarga = main.ingresarNumero(entrada, "Ingrese la capacidad de carga del camión:");
                        camion.setCap_carga(capCarga);
                    }

                    System.out.println("Datos del vehículo actualizados:");
                    System.out.println(vehiculo.toString());

                }
            }

            System.out.println("No se pudo encontrar el vehículo con las placas especificadas.");

        }

    }

    /**
     * Muestra las ventas totales.
     * 
     * @return
     */

    public double ventasTotales() {// 7. Mostrar ventas totales.
        return venta_totales;
    }

    /**
     * Metodo para eliminar vehiculo.
     * 
     * @param placa
     */

    public void eliminarVehiculo(String placa) {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");

        } else {
            Vehiculo vehiculo_encontrado = null;
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {// vehiculoEncontrado toma el valor del
                                                                  // vehiculo
                    vehiculo_encontrado = vehiculo;
                    break;
                }

            }
            if (vehiculo_encontrado != null) {// se elimina el vehiculo encontrado de vehiculos.
                vehiculos.remove(vehiculo_encontrado);
                System.out.println("vehiculo eliminado" + vehiculo_encontrado.toString());
            } else {
                System.out.println("No se encontró un vehiculo con la placa especificada.");
            }

        }

    }

}
