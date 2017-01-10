package cl.minsal.semantikos.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Esta clase tiene como objetivo realizar validaciones sobre los parámetros, como por ejemplo, si son obligatorios, etc.
 *
 * @author Andrés Farías on 10-01-17.
 */
public class ParameterValidator {

    private static final Logger logger = LoggerFactory.getLogger(ParameterValidator.class);

    /**
     * Este método tiene como responsabilidad validar que el parametro <code>parameter</code> no sea nulo.
     *
     * @param parameter El parametro a validar.
     * @throws IllegalArgumentException Śe arroja si el parámetro <code>parameter</code> es nulo o vacío.
     */
    public void required(String parameter) throws IllegalArgumentException {

        if(parameter == null){
            String errorMsg = "Parámetro nulo.";
            logger.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }

        if (parameter.trim().equals("")){
            String errorMsg = "Parámetro vacío.";
            logger.error(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }
    }
}
