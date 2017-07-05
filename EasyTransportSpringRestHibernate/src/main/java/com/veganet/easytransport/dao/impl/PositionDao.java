/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.veganet.easytransport.dao.impl;

import com.veganet.easytransport.dao.impl.AbstractHibernateDao;
import com.veganet.easytransport.entities.Positions;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asus
 */
    
@Repository
public class PositionDao  extends AbstractHibernateDao<Positions>{
  @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    public PositionDao() {
        setClazz(Positions.class);
    }
    
      //add+ set isdeleted =0
    public Positions add(Positions position) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(position);
        return position;
    }

    //users not deleted (having isDeleted=0)
    public List<Positions> getAll(short isdeleted) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Positions> list = session.createQuery("SELECT p FROM Positions p WHERE p.isdeleted = :isdeleted").setParameter("isdeleted", isdeleted).list();
        return list;
    }
    // set isdeleted=1
    public void delete2(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Positions line = (Positions) session.get(Positions.class, id);

    }
}

