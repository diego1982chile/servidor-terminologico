/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cl.minsal.semantikos.designer_modeler.helper_tables;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@ManagedBean(name = "fileUploadBean")
public class FileUploadBean {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadBean.class);

    /** El archivo cargado */
    private UploadedFile file;

    public UploadedFile getFile() {
        logger.info("Paso 1");
        return file;
    }

    public void setFile(UploadedFile file) {
        logger.info("Paso 2");
        this.file = file;
    }

    /**
     * Este método es utilizado como acción para cargar el archivo CVS con una tabla.
     */
    public void upload() {
            logger.info("FileUpload");
        if (file != null) {
            logger.info("Archivo cargado:" + file.getFileName());
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            /* El archivo es procesado */
            try {
                processFile();
            } catch (IOException e) {
                throw new EJBException("Error", e);
            }
        } else {
            logger.info("Archivo NO cargado!");
        }
    }

    private void processFile() throws IOException {
        Reader in = new InputStreamReader(file.getInputstream());
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            String cctnu_concepto_id = record.get("CCTNU_CONCEPTO_ID");
            logger.info("CCTNU_CONCEPTO_ID=" + cctnu_concepto_id);
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        logger.info("Archivo cargado!");
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
