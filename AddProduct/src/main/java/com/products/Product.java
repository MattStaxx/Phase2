package com.products;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;

@Entity
@Table(name = "products")

public class Product {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "color")
    private String color;
	
	@Column(name = "price")
    private double price;
        
        public Product() {
                
        }
        
        public Product(int id, String name, String color, double price) {
        	
            this.id= id;
            this.name = name;
            this.color = color;
            this.price = price;
        }
        
        public int getID() {return this.id; }
        public String getName() { return this.name;}
        public String getColor() { return this.color;}
        public double getPrice() { return this.price;}
        
        public void setId(int id) { this.id = id;}
        public void setName(String name) { this.name = name;}
        public void setColor(String color) { this.color = color;}
        public void setPrice(double price) { this.price = price;}
        
        
}