package com.jwtAuth.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jwtAuth.dao.AppData;
import com.jwtAuth.exceptions.DataNotFoundException;



@Repository("objCommonDaoImpls")
@Transactional
public class AppDataImpl implements AppData {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getData(String strQuery) {
		Session session = null;
		List<Object[]> listData = null;
		session = sessionFactory.getCurrentSession();
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
			throw new DataNotFoundException("");
		} else {
			listData = data.get(0).toString();
		}
		return listData;
	}
}
