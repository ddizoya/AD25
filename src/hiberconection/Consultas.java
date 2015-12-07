/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberconection;


import hiberconection.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author oracle
 */
public class Consultas {

    final String CONSULTA = "from Produtos";

    public DefaultTableModel verResultados() {
        Vector datos = new Vector();
        List lista = select();
        for (Object o : lista) {
            Produtos pro = (Produtos) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(pro.getCod());
            oneRow.add(pro.getDescricion());
            oneRow.add(pro.getPrezo());
            datos.add(oneRow);
        }
        Vector cabeceras = new Vector();
        cabeceras.add("Código");
        cabeceras.add("Descrición");
        cabeceras.add("Prezo");
        
       return new DefaultTableModel(datos, cabeceras);

    }

   private List select() {
     
            Session session = HUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(CONSULTA);
            List lista = q.list();
            return lista;
            //session.getTransaction().commit();
      
    }

    public void delete(String cod) {
        Session session = HUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Produtos pro = new Produtos(cod);
        session.delete(pro);
        
        session.getTransaction().commit();
       
    }

    public void insert (String cod, String desc, BigDecimal prezo) {
        Session session = HUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Produtos pro = new Produtos(cod, desc, prezo);
        session.save(pro);
        
        session.getTransaction().commit();
      
    }

    public void updateMasivo(BigDecimal prezo) {
        Session session = HUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery(CONSULTA);
        List lista = q.list();

        for (Object x: lista){
            Produtos pro = (Produtos) x;
            if (pro.getPrezo().compareTo(prezo) == -1){ //Si precio del objeto en la base es menor al precio que le pasamos,
                                                        //se cambiará el precio actual del objeto por el nuevo que le pasamos. 
                pro.setPrezo(prezo);
                session.update(pro);
            }
        } 
        session.getTransaction().commit();
 
    }

    public void update(String cod, String desc, BigDecimal prezo) {

        Session session = HUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Produtos pro = (Produtos) session.get(Produtos.class, cod);
        pro.setDescricion(desc);
        pro.setPrezo(prezo);
        
        session.update(pro);

        session.getTransaction().commit();

        
    }
}
