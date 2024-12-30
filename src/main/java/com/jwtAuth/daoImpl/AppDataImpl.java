package com.jwtAuth.daoImpl;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwtAuth.dao.AppData;
import com.jwtAuth.exceptions.DataNotFoundException;

import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;



@Repository("objCommonDaoImpls")
@Transactional
@Slf4j
public class AppDataImpl implements AppData {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> getData(String strQuery) {
        Session session = null;
        List<Object[]> listData = null;
        session = sessionFactory.getCurrentSession();
        System.out.println("session::::::::::::" + session);
        listData = session.createNativeQuery(strQuery).list();
        return listData;
    }

    @Override
    public String saveData(String strQuery) {
        Session session = sessionFactory.getCurrentSession();
        Object result = session.createNativeQuery(strQuery).uniqueResult();
        return result != null ? result.toString() : "No data found";
    }

    @Override
    public String getSingleData(String strQuery) throws DataNotFoundException {
        Session session = null;
        String listData = null;
        session = sessionFactory.getCurrentSession();
        @SuppressWarnings("rawtypes")
        List data = session.createNativeQuery(strQuery).list();
        if (data == null || data.isEmpty() || data.get(0) == null) {
            throw new DataNotFoundException("No data found");
        } else {
            listData = data.get(0).toString();
        }
        return listData;
    }

    // Method to handle the stored procedure
    public String executeStoredProcedure(String strProcedureQuery, Object[] params) {
        Session session = null;
        String output = null;
        try {
            session = sessionFactory.getCurrentSession();
            Query query = session.createNativeQuery(strProcedureQuery);

            // Bind parameters if there are any
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter(i + 1, params[i]); // Indexing starts at 1 for setParameter
                }
            }

            // Execute the query and retrieve the result
            output = query.getSingleResult().toString();
        } catch (Exception e) {
            // Log and handle exception based on the type of exception
            if (e instanceof SQLException) {
                log.error("SQL Exception occurred while executing stored procedure: " + e.getMessage());
            } else {
                log.error("Unexpected error occurred: " + e.getMessage());
            }
            throw new RuntimeException("Error executing stored procedure");
        }
        return output;
    }
}
