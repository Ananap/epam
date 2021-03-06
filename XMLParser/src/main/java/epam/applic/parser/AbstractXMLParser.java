package epam.applic.parser;

import epam.applic.exception.InvalidDocumentException;
import epam.applic.model.GreenHouse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static epam.applic.util.ProjectUtils.checkNotNull;

public abstract class AbstractXMLParser implements XMLParser {
    final static Logger logger = LogManager.getLogger(AbstractXMLParser.class);
    protected GreenHouse greenHouse;
    protected abstract GreenHouse parseFile(InputStream xmlis) throws Exception;

    @Override
    public GreenHouse parse(String xmlFile, String xsdFile) throws Exception {
        checkNotNull(xmlFile);

        if (xsdFile != null) {
            boolean xmlValidated = validate(new FileInputStream(xmlFile), new FileInputStream(xsdFile)); //Validation
            if(!xmlValidated)
                throw new InvalidDocumentException();
        }

        return parseFile(new FileInputStream(xmlFile));
    }

    private boolean validate(InputStream xmlis, InputStream xsdis) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(xmlis);
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(xsdis);
        Schema schema = factory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        try {
            validator.validate(new DOMSource(document));
        } catch (SAXException e) {
            logger.error("Error: " + e.getMessage());
            return false;
        }
        logger.info("Validation successful...");
        return true;
    }
}

