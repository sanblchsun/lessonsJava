package ru.geekbrains.java3.dz.dz2.KonstantinS.hibernate_dz2;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author friar
 */
public class Main {

    public static void main(String[] args) {
        ProductController pc = new ProductController();
                
        ArrayList<Product> productArray = new ArrayList<>();
        for (long i = 0; i < 10000; i++) {
            productArray.add(new Product(UUID.randomUUID(), "товар" + i, i * 10d));
        }
        pc.batchInsert(productArray);
        
        System.out.println(pc.getProductByTitle("товар512"));
        System.out.println(pc.getProductByCost(100d, 120d));
        pc.close();
    }

}
