package cl.minsal.semantikos.ws;

/**
 * Esta clase tiene como objetivo el de invocar el cliente de WS de Ingreso
 * .
 *
 * @author Andrés Farías on 03-01-17.
 */
public class ServicioDeIngresoClient {

    public static void main(String[] args) {
        System.out.println("Este es un test para consumir el WS.");

        ServicioDeIngreso_Service servicioDeIngreso_service = new ServicioDeIngreso_Service();
        ServicioDeIngreso servicioDeIngresoPort = servicioDeIngreso_service.getServicioDeIngresoPort();
        servicioDeIngresoPort.incrementarContadorDescripcionConsumida("1");
    }
}
