package cl.minsal.semantikos.ws.ingreso;

import cl.minsal.semantikos.ws.shared.IllegalInputFault_Exception;
import cl.minsal.semantikos.ws.shared.PeticionCodificacionDeNuevoTermino;
import cl.minsal.semantikos.ws.shared.RespuestaCodificacionDeNuevoTermino;
import cl.minsal.semantikos.ws.shared.ServicioDeIngreso_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.SOAPFaultException;
import java.io.IOException;

import static java.lang.System.currentTimeMillis;

/**
 * @author Andrés Farías
 */
@WebServlet(urlPatterns = "/ws-req-003")
public class WebServiceReq031Servlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(WebServiceReq031Servlet.class);

    /** El proxy al servicio web */
    private ServicioDeIngreso_Service servicioDeIngreso_service;

    /**
     * El constructror inicializa el proxy hacia el servicio.
     */
    public WebServiceReq031Servlet() {
        this.servicioDeIngreso_service = new ServicioDeIngreso_Service();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long init = currentTimeMillis();
        logger.debug("WebServiceReq031Servlet:doPost("+ req + ")");

        PeticionCodificacionDeNuevoTermino peticionNuevoTermino = new PeticionCodificacionDeNuevoTermino();
        peticionNuevoTermino.setTermino(req.getParameter("term"));
        peticionNuevoTermino.setCategoria(req.getParameter("category"));
        peticionNuevoTermino.setProfesional(req.getParameter("profesional"));
        peticionNuevoTermino.setProfesion(req.getParameter("profession"));
        peticionNuevoTermino.setEmail(req.getParameter("email"));
        peticionNuevoTermino.setEspecialidad(req.getParameter("specialty"));
        peticionNuevoTermino.setSubEspecialidad(req.getParameter("subSpecialty"));
        peticionNuevoTermino.setEstablecimiento(req.getParameter("establishment"));
        peticionNuevoTermino.setEsSensibleAMayusculas(req.getParameter("sensitiveCase") == "true");
        peticionNuevoTermino.setObservacion(req.getParameter("observation"));
        peticionNuevoTermino.setTipoDescripcion(req.getParameter("descriptionType"));

        peticionNuevoTermino.setIdConcepto("1");
        logger.debug("WebServiceReq031Servlet:doPost("+ peticionNuevoTermino + ")");

        RespuestaCodificacionDeNuevoTermino respuestaCodificacionDeNuevoTermino;
        try {
            respuestaCodificacionDeNuevoTermino = servicioDeIngreso_service.getServicioDeIngresoPort().codificacionDeNuevoTermino(peticionNuevoTermino);
            req.setAttribute("serviceResponse", respuestaCodificacionDeNuevoTermino);
            logger.debug("WebServiceReq031Servlet:doPost("+ peticionNuevoTermino + ") ==> " + respuestaCodificacionDeNuevoTermino);
        } catch (IllegalInputFault_Exception | SOAPFaultException e) {
            req.setAttribute("exception", e.getMessage());
        }


        logger.debug("WebServiceReq031Servlet:doPost("+ peticionNuevoTermino + "): {}ms " + (currentTimeMillis()-init));
        req.getRequestDispatcher("/update_service/ServicioIngresoWS-REQ-003.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WebServiceReq030Servlet:doGet()");
    }
}
