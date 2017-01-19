package cl.minsal.semantikos.ws.request;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * @author Andrés Farías on 2016-11-23.
 *
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "patronDeBusqueda", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "PatronDeBusqueda", namespace = "http://service.ws.semantikos.minsal.cl/")
public class PatternRequest implements Serializable {

    /** El patron de busqueda */
    private String pattern;

    /** ID de establecimiento que origina la consulta */
    private String idStablishment;

    @XmlElement(required = true, name = "pattern")
    public String getPattern() {
        return pattern;
    }
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @XmlElement(required = true, name="idEstablecimiento")
    public String getIdStablishment() {
        return idStablishment;
    }
    public void setIdStablishment(String idStablishment) {
        this.idStablishment = idStablishment;
    }
}
