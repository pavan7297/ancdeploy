package com.jwtAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jwtAuth.model.Blogs;
import com.jwtAuth.response.Response;
import com.jwtAuth.services.BlogServices;
import com.jwtAuth.wrappers.BlogWrappers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
public class BlogsController {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("Blogsserviceimpl")
	private BlogServices dataServices;

	@RequestMapping(value = "/createablog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response createABlog(@RequestBody Blogs blog) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		BlogWrappers wrapper = new BlogWrappers();
		log.info(strRequestID + "::::Create the Blog Data:::::::save with:::::"+blog.toString());

		String listOfData = dataServices.createBlogs(blog, strRequestID);
		wrapper.setCreateblog(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}

	@RequestMapping(value = "/getAllBlogs", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	private Response getAllBlogsData() throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		BlogWrappers wrapper = new BlogWrappers();
		log.info(strRequestID + "::::Get All Blog Data:::::::");

		List<Blogs> listOfData = dataServices.getAllBlogs(strRequestID);
		wrapper.setBlogsList(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}

	
	@RequestMapping(value = "/getBlogsById", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response getBlogsById(@RequestBody Blogs blog) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		BlogWrappers wrapper = new BlogWrappers();
		log.info(strRequestID + "::::Get All Blog Data:::::::");

		List<Blogs> listOfData = dataServices.getBlogsbyId(blog,strRequestID);
		wrapper.setBlogsList(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}
	
	@RequestMapping(value = "/updateblog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response updateTheBlog(@RequestBody Blogs blog) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		BlogWrappers wrapper = new BlogWrappers();
		log.info(strRequestID + ":::::Update the Blog Data:::::::updated data:::::"+blog.toString());

		String listOfData = dataServices.updateBlogs(blog, strRequestID);
		wrapper.setBlogupdate(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}

	@RequestMapping(value = "/deleteblog", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	private Response deleteTheBlog(@RequestBody Blogs blog) throws Exception {

		String reqIdValue = "dataid1";
		request.setAttribute("reqid", reqIdValue);
		String strRequestID = (String) request.getAttribute("reqid");

		BlogWrappers wrapper = new BlogWrappers();
		log.info(strRequestID + ":::::delete the Blog Data:::::::deleted data:::::"+blog.toString());

		String listOfData = dataServices.deleteBlogs(blog, strRequestID);
		wrapper.setBlogupdate(listOfData);
		wrapper.setResponseCode(org.springframework.http.HttpStatus.OK.value());
		wrapper.setStatus(org.springframework.http.HttpStatus.OK.getReasonPhrase());
		return wrapper;
	}
}
