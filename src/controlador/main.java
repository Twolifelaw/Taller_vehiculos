package controlador;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import modelo.Auto;
import modelo.Camion;
import modelo.Concesionario;
import modelo.Moto;
import modelo.Vehiculo;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {// main
        Concesionario concesionario = new Concesionario();// se crea la clase para poder llamar los metodos
        Scanner entrada = new Scanner(System.in);
      
        int opcion;

        do {// Listo o Menu
            System.out.println(":) Bienvenido al menú de vehículos : ");
            System.out.println("1 Registrar vehiculo");
            System.out.println("2 Buscar vehiculo.");
            System.out.println("3 Listar vehiculos disponibles y vendidos");
            System.out.println("4 Vender vehiculo");
            System.out.println("5 Mostrar cantidad de vehiculos");
            System.out.println("6 Actualizar datos del vehiculo");
            System.out.println("7 Total de ventas");
            System.out.println("8 Eliminar vehiculo");
            System.out.println("9 salir");

            opcion = entrada.nextInt();

            switch (opcion) {

                case 1:// Registro de vehiculos.
                    System.out.println(// opcion por si quiere regresar al menu.
                            "Si desea regresar al menú principal, ingrese 'menu' de lo contrario ingrese 'no'");
                    String volverMenu = entrada.next();

                    if (volverMenu.equalsIgnoreCase("menu")) {
                        System.out.println("Volviendo al menú principal...");
                        break; // Salir del case 1 y volver al menú principal
                    } else {
                        System.out.println("Elegible: ");
                        System.out.println("1 motos");
                        System.out.println("2 autos");
                        System.out.println("3 camiones");
                        int opcion_vehiculos = entrada.nextInt();
                        if (opcion_vehiculos != 1 && opcion_vehiculos != 2 && opcion_vehiculos != 3) {// validación para
                                                                                                      // que no pueda
                                                                                                      // tomar otro
                                                                                                      // valor.
                            System.out.println("error al ingresar");
                        } else {
                            if (opcion_vehiculos == 1) {

                                Moto nueva_moto = new Moto();
                                ingresarAtributosComunes(entrada, nueva_moto);
                                double cilindraje = ingresarNumero(entrada, "Ingrese el cilindraje:");
                                nueva_moto.setCilindraje(cilindraje);
                                double tamTanque = ingresarNumero(entrada, "Ingrese el tamaño del tanque:");
                                nueva_moto.setTam_tanque(tamTanque);
                                concesionario.registrarVehiculos(nueva_moto);

                            } else if (opcion_vehiculos == 2) {

                                Auto nuevo_auto = new Auto();
                                ingresarAtributosComunes(entrada, nuevo_auto);
                                int num_puertas = (int) ingresarNumero(entrada, "Ingrese el numero de puertas:");
                                nuevo_auto.setNum_puertas(num_puertas);
                                boolean is_gasolina_auto = isGasolina(entrada, "El auto es a gasolina?");
                                nuevo_auto.setGasolina(is_gasolina_auto);
                                concesionario.registrarVehiculos(nuevo_auto);

                            } else if (opcion_vehiculos == 3) {

                                Camion nuevo_camion = new Camion();
                                ingresarAtributosComunes(entrada, nuevo_camion);
                                double cap_carga = ingresarNumero(entrada, "Ingrese la cpacidad de carga del camion:");
                                nuevo_camion.setCap_carga(cap_carga);
                                concesionario.registrarVehiculos(nuevo_camion);

                            }

                        }

                    }
                    break;// Fin de registro.

                case 2:// busqueda de vehiculos.
                    System.out.println(
                            "Si desea regresar al menú principal, ingrese 'menu' de lo contrario ingrese 'no'");
                    volverMenu = entrada.next();

                    if (volverMenu.equalsIgnoreCase("menu")) {// opcion por si quiere regresar al menu.
                        System.out.println("Volviendo al menú principal...");
                        break; // Salir del case 2 y volver al menú principal
                    } else {
                        System.out.println(
                                "ingrese el dato por el cual quiere buscar el vehiculo(Placa,Marca,Referencia,Modelo,Precio): ");
                        String clave = entrada.next();
                        concesionario.buscarVehiculo(clave);

                    }
                    break;// Fin de busqueda de vehiculo

                case 3:// Listar disponibles.
                    System.out.println(
                            "Si desea regresar al menú principal, ingrese 'menu' de lo contrario ingrese 'no'");
                    volverMenu = entrada.next();

                    if (volverMenu.equalsIgnoreCase("menu")) {// opcion por si quiere regresar al menu.
                        System.out.println("Volviendo al menú principal...");
                        break; // Salir del case 3 y volver al menú principal
                    } else {
                        concesionario.mostrarVehiculosPorTipo();
                        concesionario.mostrarVehiculosVendidosPorTipo();

                    }
                    break; // Fin de listar

                case 4:// Venta de vehiculo
                    System.out.println(
                            "Si desea regresar al menú principal, ingrese 'menu' de lo contrario ingrese 'no'");
                    volverMenu = entrada.next();

                    if (volverMenu.equalsIgnoreCase("menu")) {// opcion por si quiere regresar al menu.
                        System.out.println("Volviendo al menú principal...");
                        break; // Salir del case 4 y volver al menú principal
                    } else {
                        System.out.println("Ingrese la placa del vehiculo a vender: ");
                        String placa_venta = entrada.next();
                        concesionario.venderVehiculo(placa_venta);

                    }
                    break;// FIn de ventas

                case 5:// Muestra el stock de vehiculos y los vehiculos vendidos por su tipo
                    System.out.println(
                            "Si desea regresar al menú principal, ingrese 'menu' de lo contrario ingrese 'no'");
                    volverMenu = entrada.next();

                    if (volverMenu.equalsIgnoreCase("menu")) {// opcion por si quiere regresar al menu.
                        System.out.println("Volviendo al menú principal...");
                        break; // Salir del case 5 y volver al menú principal
                    } else {
                        concesionario.mostrarVehiculoStock();
                        concesionario.mostrarVehiculosVendidos();

                    }
                    break;// FIn de mostrar stock

                case 6:// Actualizar datos del vehiculo

                    System.out.println(
                            "Si desea regresar al menú principal, ingrese 'menu' de lo contrario ingrese 'no'");
                    volverMenu = entrada.next();

                    if (volverMenu.equalsIgnoreCase("menu")) {// opcion por si quiere regresar al menu.
                        System.out.println("Volviendo al menú principal...");
                        break; // Salir del case 6 y volver al menú principal
                    } else {
                        System.out.println("Ingrese la placa del vehiculo a actualizar: ");
                        String placa_actualizar = entrada.next();
                        concesionario.actualizarDatosVehiculo(placa_actualizar);

                    }
                    break;// FIn de actualizar datos

                case 7:// Muestra de las ventas totales.
                    System.out.println(
                            "Si desea regresar al menú principal, ingrese 'menu' de lo contrario ingrese 'no'");
                    volverMenu = entrada.next();

                    if (volverMenu.equalsIgnoreCase("menu")) {
                        System.out.println("Volviendo al menú principal...");
                        break; // Salir del case 7 y volver al menú principal
                    } else {
                        System.out.println("las ventas totales son: " + concesionario.ventasTotales());
                    }
                    break;// Fin de ventas totales.

                case 8:// Eliminar vehiculo.
                    System.out
                            .println("Si desea regresar al menú principal, ingrese 'menu' de lo contrario ingrese'no'");
                    volverMenu = entrada.next();

                    if (volverMenu.equalsIgnoreCase("menu")) {
                        System.out.println("Volviendo al menú principal...");
                        break; // Salir del case 8 y volver al menú principal
                    } else {
                        System.out.println("Ingrese la placa del vehiculo a eliminar: ");
                        String placa_eliminar = entrada.next();
                        concesionario.eliminarVehiculo(placa_eliminar);
                    }

                    break; // Fin de eliminar vehiculo

                case 9:
                    System.out.println("!Hasta luego!");// terminar programa
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 9);// Numero para acabar programa.

        entrada.close(); // Cierra el Scanner al final
    }

    /**
     * Metodo para ingresar numeros por teclado y a la vez validar que estos solo
     * sean numericos.
     * 
     * @param entrada
     * @param mensaje
     * @return
     */

    public static double ingresarNumero(Scanner entrada, String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return entrada.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese solo números válidos.");
                entrada.next(); // Limpia el buffer de entrada
            }
        }
    }

    /**
     * Metodo para ingrersar los atributos comunes entre todos los vehiculos.
     * 
     * @param entrada
     * @param vehiculo
     */

    public static void ingresarAtributosComunes(Scanner entrada, Vehiculo vehiculo) {
        System.out.println("Ingrese la placa:");
        vehiculo.setPlaca(entrada.next());

        System.out.println("Ingrese la marca:");
        vehiculo.setMarca(entrada.next());

        System.out.println("Ingrese la referencia:");
        vehiculo.setReferencia(entrada.next());

        System.out.println("Ingrese el modelo:");
        vehiculo.setModelo(entrada.next());

        double precio = ingresarNumero(entrada, "Ingrese el precio:");
        vehiculo.setPrecio(precio);

        int numRuedas = (int) ingresarNumero(entrada, "Ingrese el número de ruedas:");
        vehiculo.setNum_ruedas(numRuedas);
    }

    /**
     * Metodo para verificar el ingreso de si or no por teclado.
     * 
     * @param entrada
     * @param mensaje
     * @return
     */

    public static boolean isGasolina(Scanner entrada, String mensaje) {
        while (true) {
            System.out.println(mensaje + " (si/no):");
            String respuesta = entrada.next();

            if (respuesta.equalsIgnoreCase("si")) {
                return true;
            } else if (respuesta.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.err.println("Respuesta inválida. Por favor, ingrese 'si' o 'no'.");
            }
        }
    }
}
