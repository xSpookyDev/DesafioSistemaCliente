package servicio;

import modelo.Cliente;
import servicio.Exportador;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorCsv extends Exportador {


    public void exportar(String fileName, List<Cliente> listaClientes) {
        File carpeta = new File("src/main/resources/");

        if (!fileName.endsWith(".csv")) {
            fileName = fileName + ".csv";
        }

        File archivo = new File(carpeta, fileName);

        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        try {
            boolean archivoCreado = archivo.createNewFile();

            if (!archivoCreado) {
                System.out.println("El archivo no se pudo crear o ya existe.");
            }

            PrintWriter escritor = new PrintWriter(new FileWriter(archivo));

            for (Cliente cliente : listaClientes) {
                escritor.printf("%s,%s,%s,%s,%s%n",
                        cliente.getRunCliente(),
                        cliente.getNombreCliente(),
                        cliente.getApellidoCliente(),
                        cliente.getAniosCliente(),
                        cliente.getNombreCategoria());
            }

            escritor.close();

            System.out.println("Clientes exportados exitosamente en formato csv.");
        } catch (Exception e) {
            System.out.println("Error al generar archivo csv.");
        }
    }
}
