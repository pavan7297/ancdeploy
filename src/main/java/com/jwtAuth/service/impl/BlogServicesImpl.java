package com.jwtAuth.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jwtAuth.dao.AppData;
import com.jwtAuth.exceptions.DataNotFoundException;
import com.jwtAuth.model.Blogs;
import com.jwtAuth.services.BlogServices;
import com.jwtAuth.utils.CommonConstants;

import lombok.extern.slf4j.Slf4j;


@Service("Blogsserviceimpl")
@Slf4j
public  class BlogServicesImpl implements BlogServices{
	
	
	@Autowired
	@Qualifier("objCommonDaoImpls")
	AppData objAppdata;

	@Value("${spring.datasource.url}")
	private String strJdbcUrl;

	@Value("${spring.datasource.username}")
	private String strDBUSERNAME;

	@Value("${spring.datasource.password}")
	private String strDBPWD;

	@Override
	public String createBlogs(Blogs blogs, String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call create_blog(?,?,?,?)}");
			cs.setString(1, blogs.getBlogtitle());
			cs.setString(2, blogs.getBlogdescription());
			cs.setString(3, blogs.getBlogcategory());
			cs.setString(4, blogs.getBlogimgurl());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		String output = objAppdata.getSingleData(cs.toString());
		return output;

	}

	@Override
	public List<Blogs> getAllBlogs(String strRequestID)
			throws DataNotFoundException, SQLException {
		PreparedStatement cs = null;
		Connection connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
		try {
//			connection = 
//			System.err.println("check the connections :::::::" + connection);
			cs = connection.prepareCall("{call get_all_blogs()}");
//			System.err.println("check the queary :::::::" + cs);
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {
			connection.close();
		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<Blogs> blogList = data.stream().map((Object[] objects) -> {
			Blogs blog = new Blogs();

			if (objects[0] != null) {
				blog.setBlogid(objects[0].toString());
			} else {
				blog.setBlogid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				blog.setBlogtitle(objects[1].toString());
			} else {
				blog.setBlogtitle(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				blog.setBlogdescription(objects[2].toString());
			} else {
				blog.setBlogdescription(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				blog.setBlogdateandtime(objects[3].toString());
			} else {
				blog.setBlogdateandtime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				blog.setBlogcategory(objects[4].toString());
			} else {
				blog.setBlogdateandtime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				blog.setBlogimgurl(objects[5].toString());
			} else {
				blog.setBlogdateandtime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return blog;
		}).collect(Collectors.toList());

		return blogList;

	}

	
	@Override
	public List<Blogs> getBlogsbyId(Blogs blogs , String strRequestID)
			throws DataNotFoundException, SQLException {
		PreparedStatement cs = null;
		Connection connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
		try {

			cs = connection.prepareCall("{call get_blog_by_id(?)}");
			cs.setString(1, blogs.getBlogid());
			
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {
			connection.close();
		}
		log.info("SQL QUERY :::::::::::" + cs.toString());
		@SuppressWarnings("unchecked")
		List<Object[]> data = (List<Object[]>) objAppdata.getData(cs.toString());

		List<Blogs> blogList = data.stream().map((Object[] objects) -> {
			Blogs blog = new Blogs();

			if (objects[0] != null) {
				blog.setBlogid(objects[0].toString());
			} else {
				blog.setBlogid(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[1] != null) {
				blog.setBlogtitle(objects[1].toString());
			} else {
				blog.setBlogtitle(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[2] != null) {
				blog.setBlogdescription(objects[2].toString());
			} else {
				blog.setBlogdescription(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[3] != null) {
				blog.setBlogdateandtime(objects[3].toString());
			} else {
				blog.setBlogdateandtime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[4] != null) {
				blog.setBlogcategory(objects[4].toString());
			} else {
				blog.setBlogdateandtime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			if (objects[5] != null) {
				blog.setBlogimgurl(objects[5].toString());
			} else {
				blog.setBlogdateandtime(CommonConstants.DATA_NOT_AVIALABLE);
			}
			return blog;
		}).collect(Collectors.toList());

		return blogList;

	}

	
	
	
	
	@Override
	public String updateBlogs(Blogs blogs, String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call update_blog_by_id(?,?,?,?,?)}");
			cs.setString(1, blogs.getBlogid());
			cs.setString(2, blogs.getBlogtitle());
			cs.setString(3, blogs.getBlogdescription());
			cs.setString(4, blogs.getBlogcategory());
			cs.setString(5, blogs.getBlogimgurl());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		String output = objAppdata.getSingleData(cs.toString());
		return output;

	}

	@Override
	public String deleteBlogs(Blogs blogs, String strRequestID) throws Exception, SQLDataException {
		CallableStatement cs = null;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(strJdbcUrl, strDBUSERNAME, strDBPWD);
			cs = connection.prepareCall("{call delete_blog_by_id(?)}");
			cs.setString(1, blogs.getBlogid());
		} catch (Exception e) {
			System.out.print("sqlexception:::" + e);
		} finally {

			connection.close();

		}
		log.info(strRequestID + ":::::::::::::" + cs.toString());
		String output = objAppdata.getSingleData(cs.toString());
		return output;
	}

}
