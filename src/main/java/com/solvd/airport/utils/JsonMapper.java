package com.solvd.airport.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonMapper {
    private static final Logger LOGGER = Logger.getLogger(JsonMapper.class.getName());
    private static ObjectMapper objectMapper = new ObjectMapper();


    public <T> List<T> readJSON(String filePath, Class<T> classRef) {
        try {
            List<T> entities;
            JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, classRef);
            entities = objectMapper.readValue(new File(filePath), javaType);
            return entities;
        } catch (JsonProcessingException e) {
            LOGGER.error("Can't open file", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }
    public <T> void writeJSON(List<T> entityList, String filePath) {
        try {
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File(filePath),entityList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
