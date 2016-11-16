package cl.minsal.semantikos.kernel.components.ispfetcher;

import javax.ejb.Local;
import java.util.Map;

/**
 * Created by BluePrints Developer on 16-11-2016.
 */
@Local
public interface ISPFetcher {
    Map<String,String> getISPData(String registro);
}
