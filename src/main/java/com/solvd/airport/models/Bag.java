package com.solvd.airport.models;

import javax.xml.bind.annotation.*;
    @XmlRootElement(name = "bags")
    @XmlType(propOrder = {"id", "amount", "size", "weight"})
    @XmlAccessorType(XmlAccessType.FIELD)
    public class Bag {
        @XmlAttribute
        private int id;
        @XmlElement(name = "amount")
        private int amount;
        @XmlElement(name = "size")
        private int size;
        @XmlElement(name = "weight")
        private int weight;
        public Bag() {}
        public Bag( int amount, int size, int weight) {
            this.amount = amount;
            this.size = size;
            this.weight = weight;

        }
        public Bag(int id, int amount, int size, int weight) {
            this.id = id;
            this.amount = amount;
            this.size = size;
            this.weight = weight;

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAmount() {
            return amount;
        }
        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
