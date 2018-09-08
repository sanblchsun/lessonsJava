package ru.geekbrains.java3.dz.dz2.KonstantinS.hibernate_dz2;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author friar
 */
public class ProductController {

    private static SessionFactory sessionFactory;

    public ProductController() {
        sessionFactory = HbrnUtl.getSessionFactory();
    }

    public Product getProduct(Long id) {
        Session session = sessionFactory.openSession();
        return (Product) session.load(Product.class, id);
    }

    public void deleteProduct(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Product product = new Product();
        product.setId(id);
        session.delete(product);
        session.getTransaction().commit();
    }

    public void deleteAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createSQLQuery("truncate table MyTable").executeUpdate();
        session.getTransaction().commit();
    }

    public Long saveProduct(Product p) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(p);
        session.flush();
        session.getTransaction().commit();
        return p.getId();
    }

    public void batchInsert(ArrayList<Product> product) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for (Product p : product) {
            session.save(p);
        }

        session.flush();
        session.clear();

        tx.commit();
        session.close();
    }

    public List<Product> getProductByTitle(String title) {
        Session session = sessionFactory.openSession();
        Criteria productCriteria = session.createCriteria(Product.class);
        List<Product> productList = productCriteria.add(Restrictions.eq("title", title)).list();
        session.close();
        return productList;
    }

    public List<Product> getProductByCost(Double cost, Double biggerCost) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Product.class);
        criteria.add(Restrictions.ge("cost", cost));
        criteria.add(Restrictions.le("cost", biggerCost));
        List<Product> productList = criteria.list();
        session.close();
        return productList;
    }
    
    public void close(){
        sessionFactory.close();
    }
}
