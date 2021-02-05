package applic.parser;

import applic.exception.InvalidDocumentException;
import applic.xmlflowers.GreenHouse;
import jdk.nashorn.internal.runtime.ParserException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static applic.utils.ProjectUtils.checkNotNull;

public abstract class AbstractXMLParser implements XMLParser {
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

    protected void writeDocument(Document document, String xmlOutFile)
            throws TransformerException, TransformerFactoryConfigurationError, FileNotFoundException, TransformerConfigurationException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        Result output = new StreamResult(new FileOutputStream(xmlOutFile));
        Source input = new DOMSource(document);
        transformer.transform(input, output);
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
            System.out.println(e);
            return false;
        }
        System.out.println("Validation successful...");
        return true;
    }
}

