/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.geekbrains.java3.dz.dz2.KonstantinS;

import java.util.UUID;

/**
 *
 * @author friar
 */
public class Goods {
    Long id;      //порядковый номер записи, первичный ключ
    UUID prodid;        //уникальный номер товара
    String title;       //название товара
    Double cost;        //стоимость

    public Goods(Long id, UUID prodid, String title, Double cost) {
        this.id = id;
        this.prodid = prodid;
        this.title = title;
        this.cost = cost;
    }
    
    @Override
    public String toString(){
        return new StringBuilder("\n\tgood\n\t[").append("\n\t\tid: "+id).append("\n\t\tprodid: "+prodid).append("\n\t\ttitle:"+title).append("\n\t\tcost: "+cost).append("\n\t]\n").toString();
    }
}
