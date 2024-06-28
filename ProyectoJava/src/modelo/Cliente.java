package modelo;

public class Cliente {

    //atributos
    private String runCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String aniosCliente;
    private CategoríaEnum nombreCategoria;

    //contructor


    public Cliente() {
    }

    public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente, CategoríaEnum nombreCategoria) {
        this.runCliente = runCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.aniosCliente = aniosCliente;
        this.nombreCategoria = nombreCategoria;
    }

    //metodos


    public String getRunCliente() {
        return runCliente;
    }

    public void setRunCliente(String runCliente) {
        this.runCliente = runCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getAniosCliente() {
        return aniosCliente;
    }

    public void setAniosCliente(String aniosCliente) {
        this.aniosCliente = aniosCliente;
    }

    public CategoríaEnum getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(CategoríaEnum nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "runCliente='" + runCliente + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", aniosCliente='" + aniosCliente + '\'' +
                ", nombreCategoria=" + nombreCategoria +
                '}';
    }
}
