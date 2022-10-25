package com.solvd.airport.utils;

import javax.xml.validation.Schema;
import java.util.List;

public interface XmlParser<T> {
    public Schema loadSchema(String filename);
    public T readXMLFile(String filename, Class<T> clas);
    public List<T> unmarshal(String filename, Class <T> clas);
}
