package vista;


import modelo.Cliente;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import servicio.ServicioArchivo;
import utilidades.Utilidad;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private ClienteServicio clienteServicio;
    private ServicioArchivo archivoServicio;
    private ExportadorCsv exportadorCsv;
    private ExportadorTxt exportadorTxt;
    private final String nombreArchivo = "clientes";
    private final String nombreArchivoDatos = "DBClientes.csv";
    private Scanner escaner;
    private List<Cliente> listaClientes;

    public Menu() {
        this.clienteServicio = new ClienteServicio();
        this.archivoServicio = new ServicioArchivo();
        this.exportadorCsv = new ExportadorCsv();
        this.exportadorTxt = new ExportadorTxt();
        this.escaner = new Scanner(System.in);
        this.listaClientes = new ArrayList<>();
    }

    public void iniciarMenu() {
        int opcion = 0;
        do {
            mostrarMenu();
            try {
                opcion = escaner.nextInt();
                escaner.nextLine();
                switch (opcion) {
                    case 1:
                        clienteServicio.obtenerListaDeClientes();
                        break;
                    case 2:
                        clienteServicio.añadirCliente();
                        break;
                    case 3:
                        clienteServicio.modificarClientes();
                        break;
                    case 4:
                        cargarDatos();
                        break;
                    case 5:
                        archivoServicio.exportar(nombreArchivo, listaClientes);
                        break;
                    case 6:
                        terminarPrograma();
                        break;
                    default:
                        Utilidad.mostrarMensaje("Opción no válida");
                }
            } catch (InputMismatchException e) {
                Utilidad.mostrarMensaje("Debe ingresar los números de las opciones disponibles.");
                escaner.nextLine();
            }
        } while (opcion != 6);
    }

    private void mostrarMenu() {
        Utilidad.mostrarMensaje("------- Menú -------");
        Utilidad.mostrarMensaje("1. Listar Clientes");
        Utilidad.mostrarMensaje("2. Agregar Cliente");
        Utilidad.mostrarMensaje("3. Editar Cliente");
        Utilidad.mostrarMensaje("4. Cargar Datos");
        Utilidad.mostrarMensaje("5. Exportar Datos");
        Utilidad.mostrarMensaje("6. Salir");
        Utilidad.mostrarMensaje("Ingrese una opción: ");
    }

    private void cargarDatos() {
        listaClientes = archivoServicio.cargarDatos();
        clienteServicio.mostrarClientes(listaClientes);
    }

    public void terminarPrograma() {
        Utilidad.limpiarConsola();
        Utilidad.mostrarMensaje("Finalizando sistema...");
        Utilidad.pausa();
    }
}
