package com.solvd.airport.services.json;

import com.solvd.airport.DAO.MealDAOImpl;
import com.solvd.airport.DAO.TicketDAOImpl;
import com.solvd.airport.models.Ticket;
import com.solvd.airport.services.IMealService;
import com.solvd.airport.services.ITicketService;
import com.solvd.airport.utils.ParserDOM;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TicketService implements ITicketService {
    private static final Logger LOGGER = Logger.getLogger(TicketService.class.getName());
    private TicketDAOImpl ticketDAO = new TicketDAOImpl();
    private ParserDOM parseMeal = new ParserDOM();

    @Override
    public void getTicketFromXML(String xmlFile, String xsdFile) {
        Ticket ticketFromXML = new Ticket();
        try {
            JAXBContext context = JAXBContext.newInstance(Ticket.class);
            ticketFromXML = (Ticket) context.createUnmarshaller().unmarshal(new FileReader(xmlFile));
        } catch (JAXBException | FileNotFoundException e) {
            LOGGER.warn(e.getMessage());
        }
        //bagDAO.create(bagFromXML);

    }
    @Override
    public void createXML(String xmlFile) {
        Ticket ticket = new Ticket();
        try {
            JAXBContext context = JAXBContext.newInstance(Ticket.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(ticket, new File(xmlFile));
        } catch (JAXBException e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
