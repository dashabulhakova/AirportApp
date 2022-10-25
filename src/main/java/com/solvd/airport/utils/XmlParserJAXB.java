package com.solvd.airport.utils;

import net.bytebuddy.build.Plugin;
import org.apache.log4j.Logger;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlParserJAXB<T> implements XmlParser<T> {
    private static final Logger LOGGER = Logger.getLogger(XmlParserJAXB.class.getName());
    Schema schema;

    @Override
    public Schema loadSchema(String filename) {
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(new File(filename));
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
        return null;
    }

    @Override
    public T readXMLFile(String filename, Class<T> clas) {
        return null;
    }

    @Override
    public List<T> unmarshal(String xmlName, Class<T> classRef) {
        Source source = new StreamSource(new File(xmlName));
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(classRef, com.solvd.airport.utils.AbstractList.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<AbstractList> jaxbElement = unmarshaller.unmarshal(source, AbstractList.class);
            List<T> entityList = jaxbElement.getValue().getEntities();
            return entityList;
        } catch (JAXBException e) {
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }
}
