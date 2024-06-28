package servicio;

import modelo.Cliente;
import servicio.Exportador;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorTxt extends Exportador {

    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        StringBuilder datos = new StringBuilder("Lista de clientes\n");
        File carpeta = new File("src/main/resources");

        if (!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }

        File archivo = new File(carpeta, fileName);

        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        try {
            archivo.createNewFile();
            PrintWriter escritor = new PrintWriter(new FileWriter(archivo));

            for (Cliente cliente : listaClientes) {
                datos.append("\n").append(cliente.toString()).append("\n");
            }

            escritor.write(datos.toString());
            escritor.close();

            System.out.println("Clientes exportados exitosamente en formato txt.");
        } catch (Exception e) {
            System.out.println("Hubo un error al generar el archivo txt.");
        }
    }
}
