package utilidades;

public class Utilidad {

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void limpiarConsola() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public static void pausa() {
        try {
            System.out.println("Saliendo del sistema de clientes...");
            Thread.sleep(1000);
            System.out.println("Ha salido del sistema.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
