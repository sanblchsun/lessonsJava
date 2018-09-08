package ru.geekbrains.java3.dz.dz2.KonstantinS.hibernate_dz2;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author friar
 */
@Entity
@Table(name = "product" )
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;            //порядковый номер записи, первичный ключ
    private UUID prodid;        //уникальный номер товара
    private String title;       //название товара
    private Double cost;        //стоимость    

    public Product(){
        
    }
    
    public Product(UUID prodid, String title, Double cost) {
        this.prodid = prodid;
        this.title = title;
        this.cost = cost;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getProdid() {
        return prodid;
    }

    public void setProdid(UUID prodid) {
        this.prodid = prodid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
    
    @Override
    public String toString(){
        return new StringBuilder("\n\tproduct\n\t[").append("\n\t\tid: "+id).append("\n\t\tprodid: "+prodid).append("\n\t\ttitle:"+title).append("\n\t\tcost: "+cost).append("\n\t]\n").toString();
    }
}
