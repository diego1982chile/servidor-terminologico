package cl.minsal.semantikos.ws.response;

import cl.minsal.semantikos.model.User;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Development on 2016-10-13.
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "usuario", namespace = "http://service.ws.semantikos.minsal.cl/")
@XmlType(name = "Usuario", namespace = "http://service.ws.semantikos.minsal.cl/")
public class UserResponse implements Serializable {

    @XmlElement(name="nombreUsuario")
    private String username;

    @XmlElement(name="nombre")
    private String name;

    @XmlElement(name="apellido")
    private String lastName;

    @XmlElement(name="segundoApellido")
    private String secondLastName;

    @XmlElement(name="email")
    private String email;

    @XmlElement(name="rut")
    private String rut;

    @XmlElement(name="ultimoLogin")
    private Date lastLogin;

    @XmlElement(name="ultimoCambioPassword")
    private Date lastPasswordChange;

    public UserResponse() {
    }

    public UserResponse(User creatorUser) {
        this.username = creatorUser.getUsername();
        this.name = creatorUser.getName();
        this.lastName = creatorUser.getLastName();
        this.secondLastName = creatorUser.getSecondLastName();
        this.email = creatorUser.getEmail();
        this.rut = creatorUser.getRut();
        this.lastLogin = creatorUser.getLastLogin();
        this.lastPasswordChange = creatorUser.getLastPasswordChange();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getLastPasswordChange() {
        return lastPasswordChange;
    }

    public void setLastPasswordChange(Date lastPasswordChange) {
        this.lastPasswordChange = lastPasswordChange;
    }
}
