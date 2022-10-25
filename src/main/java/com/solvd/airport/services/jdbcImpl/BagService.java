package com.solvd.airport.services.jdbcImpl;

import com.solvd.airport.DAO.BagDAOImpl;
import com.solvd.airport.DAO.IBagDAO;
import com.solvd.airport.models.Bag;
import com.solvd.airport.services.IBagService;
import com.solvd.airport.utils.ParserDOM;
import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BagService implements IBagService {
    private final IBagDAO bagDAO = new BagDAOImpl();
    private static final Logger LOGGER = Logger.getLogger(BagService.class.getName());
    ParserDOM domParser;

    @Override
    public void createBag(Bag b) {
        try {
            bagDAO.create(b);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bag> getBagsByUser(int userID) {
        try {
            return bagDAO.getBagByUser((userID));
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<Bag> parseFromXmlDOM(String schemaName, String xmlName) {
        domParser.loadSchema(schemaName);
        Document doc = domParser.readXMLFile(xmlName, Document.class);
        domParser.validate(doc);
        NodeList list = doc.getElementsByTagName("bag");
        List<Bag> discounts = new ArrayList<Bag>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == node.ELEMENT_NODE) {
                Element element = (Element) node;
                Bag b = new Bag();
                b.setId(Integer.parseInt(element.getAttribute("id")));
                b.setAmount(Integer.parseInt(element.getElementsByTagName("amount").item(0).getTextContent()));
                b.setSize(Integer.parseInt(element.getElementsByTagName("size").item(0).getTextContent()));
                b.setWeight(Integer.parseInt(element.getElementsByTagName("weight").item(0).getTextContent()));

                discounts.add(b);
                try {
                    bagDAO.create(b);
                } catch (SQLException e) {
                    LOGGER.warn(e.getMessage());
                }
            }
        }
        return discounts;
    }

    @Override
    public void parseFromXmlJAXB(String schemaName, String xmlName) {
        Bag xmlBag = new Bag();
        try {
            JAXBContext context = JAXBContext.newInstance(Bag.class);
            xmlBag = (Bag) context.createUnmarshaller().unmarshal(new FileReader(xmlName));
        } catch (JAXBException | FileNotFoundException e) {
            LOGGER.warn(e.getMessage());
        }

        try {
            bagDAO.create(xmlBag);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }

    }
}
