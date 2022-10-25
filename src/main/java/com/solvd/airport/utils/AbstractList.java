package com.solvd.airport.utils;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

    @XmlRootElement
    public class AbstractList<T> {
        @XmlAnyElement(lax = true)
        private List<T> entities = new ArrayList<>();

        public void addEntity(T entity){
            entities.add(entity);
        }

        public AbstractList(List<T> entities) {
            this.entities = entities;
        }

        public List<T> getEntities(){
            return entities;
        }
}
