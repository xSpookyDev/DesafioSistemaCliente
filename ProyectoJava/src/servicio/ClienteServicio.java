package servicio;

import modelo.CategoríaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

import java.util.*;

public class ClienteServicio {
    private List<Cliente> listaDeClientes;
    Scanner entrada;
    Utilidad utilidad;

    public ClienteServicio() {
        this.listaDeClientes = new ArrayList<>();
        this.entrada = new Scanner(System.in);
        this.utilidad = new Utilidad();
    }

    public void establecerListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }

    public void mostrarClientes(List<Cliente> listaClientes) {
        if (listaDeClientes.isEmpty()) {
            Utilidad.mostrarMensaje("No hay clientes para mostrar.");
        } else {
            for (Cliente cliente : listaDeClientes) {
                Utilidad.mostrarMensaje("-------------Datos del Cliente------------- ");
                Utilidad.mostrarMensaje(cliente.toString());
                Utilidad.mostrarMensaje("-------------------------------------------");
            }
        }
    }

    public void añadirCliente(String run, String nombre, String apellido, String años) {
        if (run == null || nombre == null || apellido == null || años == null) {
            throw new IllegalArgumentException("Ninguno de los campos puede ser nulo");
        }
        Cliente cliente = new Cliente();
        cliente.setRunCliente(run);
        cliente.setNombreCliente(nombre);
        cliente.setApellidoCliente(apellido);
        cliente.setAniosCliente(años);
        cliente.setNombreCategoria(CategoríaEnum.Activo);
        listaDeClientes.add(cliente);
    }

    public void añadirCliente() {
        Utilidad.mostrarMensaje("-------------Crear Cliente------------- ");
        try {
            Utilidad.mostrarMensaje("Ingresa el RUN del cliente: ");
            String run = entrada.nextLine();
            Utilidad.mostrarMensaje("Ingresa el Nombre del cliente: ");
            String nombre = entrada.nextLine();
            Utilidad.mostrarMensaje("Ingresa el Apellido del cliente: ");
            String apellido = entrada.nextLine();
            Utilidad.mostrarMensaje("Ingresa los años del cliente: ");
            String años = entrada.nextLine();
            añadirCliente(run, nombre, apellido, años);
            Utilidad.mostrarMensaje("--------------------------------------- ");
        } catch (InputMismatchException e) {
            Utilidad.mostrarMensaje("Error: Debe ingresar un número. Intente de nuevo.");
            entrada.nextLine();
        }
    }

    public void modificarClientes() {
        Utilidad.mostrarMensaje("-------------Modificar Cliente------------- ");
        Utilidad.mostrarMensaje("Seleccione qué desea hacer: ");
        Utilidad.mostrarMensaje("1.- Cambiar el estado del cliente");
        Utilidad.mostrarMensaje("2.- Editar datos del cliente");
        Utilidad.mostrarMensaje("Ingrese opción: ");
        try {
            int opcion = entrada.nextInt();
            entrada.nextLine();
            Utilidad.mostrarMensaje("----------------------------------------");
            if (opcion == 1) {
                cambiarEstadoDelCliente();
            } else if (opcion == 2) {
                modificarDatosDelCliente();
            } else {
                Utilidad.mostrarMensaje("Opción no válida, intente con un número entre 1 y 2.");
            }
        } catch (InputMismatchException e) {
            Utilidad.mostrarMensaje("Error: Debe ingresar un número. Intente de nuevo.");
            entrada.nextLine();
        }
    }

    public void cambiarEstadoDelCliente(){
        System.out.print("Ingrese RUN del Cliente a modificar: ");
        try {
            String runCliente = entrada.nextLine();
            Optional<Cliente> clienteOpt = listaDeClientes.stream()
                    .filter(cliente -> cliente.getRunCliente().equals(runCliente))
                    .findFirst();
            if (clienteOpt.isPresent()) {
                Cliente cliente = clienteOpt.get();
                Utilidad.mostrarMensaje("-----Actualizando estado del Cliente----");
                Utilidad.mostrarMensaje("El estado actual del cliente es: " + cliente.getNombreCategoria());
                Utilidad.mostrarMensaje("1.- Cambiar el estado del Cliente a Inactivo");
                Utilidad.mostrarMensaje("2.- Mantener el estado del cliente Activo");
                Utilidad.mostrarMensaje("Ingrese opción: ");
                int opcionEstado = entrada.nextInt();
                entrada.nextLine();
                Utilidad.mostrarMensaje("----------------------------------------");
                switch (opcionEstado) {
                    case 1:
                        cliente.setNombreCategoria(CategoríaEnum.Activo);
                        break;
                    case 2:
                        cliente.setNombreCategoria(CategoríaEnum.Activo);
                        break;
                    default:
                        Utilidad.mostrarMensaje("Opción no válida, intente con un número entre 1 y 2.");
                }
                Utilidad.mostrarMensaje("Estado cambiado con éxito");
            } else {
                Utilidad.mostrarMensaje("Cliente con RUN " + runCliente + " no encontrado.");
            }
        } catch (InputMismatchException e) {
            Utilidad.mostrarMensaje("Error: Debe ingresar un número. Intente de nuevo.");
            entrada.nextLine();
        }
    }

    public void modificarDatosDelCliente() {
        try {
            System.out.print("Ingrese RUN del Cliente a modificar:  ");
            String runCliente = entrada.nextLine();
            Optional<Cliente> clienteOpt = listaDeClientes.stream()
                    .filter(cliente -> cliente.getRunCliente().equals(runCliente))
                    .findFirst();

            if (clienteOpt.isPresent()) {
                Cliente cliente = clienteOpt.get();
                Utilidad.mostrarMensaje("Datos del Cliente: \n");
                Utilidad.mostrarMensaje("1.- El RUN del Cliente es: \n" + cliente.getRunCliente());
                Utilidad.mostrarMensaje("2.- El Nombre del Cliente es: \n" + cliente.getNombreCliente());
                Utilidad.mostrarMensaje("3.- El Apellido del Cliente es: \n" + cliente.getApellidoCliente());
                Utilidad.mostrarMensaje("4.- Los años del Cliente son: \n" + cliente.getAniosCliente());
                System.out.print("Ingrese opción a modificar de los datos del cliente: \n");
                Utilidad.mostrarMensaje("---------------------------------------- ");
                int opcionModificar = entrada.nextInt();
                entrada.nextLine();
                switch (opcionModificar) {
                    case 1:
                        Utilidad.mostrarMensaje("1.- Ingrese nuevo RUN del Cliente:");
                        cliente.setRunCliente(entrada.nextLine());
                        break;
                    case 2:
                        System.out.print("2.- Ingrese el nuevo nombre del cliente: ");
                        cliente.setNombreCliente(entrada.nextLine());
                        break;
                    case 3:
                        System.out.print("3.- Ingrese el nuevo apellido del cliente: ");
                        cliente.setApellidoCliente(entrada.nextLine());
                        break;
                    case 4:
                        System.out.print("4.- Ingrese los nuevos años del cliente: ");
                        cliente.setAniosCliente(entrada.nextLine());
                        break;
                    default:
                        Utilidad.mostrarMensaje("Opción no válida, intente con un número entre 1 y 4.");
                }
                Utilidad.mostrarMensaje("Datos modificados con éxito");
            } else {
                Utilidad.mostrarMensaje("Cliente con RUN " + runCliente + " no encontrado.");
            }
        } catch (InputMismatchException e) {
            Utilidad.mostrarMensaje("Error: Debe ingresar un número. Intente de nuevo.");
            entrada.nextLine();
        }
    }

    public List<Cliente> obtenerListaDeClientes() {
        return listaDeClientes;
    }

}
