package com.protobuf.web;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protobuf.dao.LibraryDao;
import com.protobuf.generated.LibraryProtos;

@RestController
public class LibraryRestController {
	
	@Autowired
	LibraryDao libraryDao;
	
	@RequestMapping("/library/{id}")
	@Produces("application/x-protobuf")
	public LibraryProtos.Library getBookByID(@PathVariable("id") Integer id){
		return libraryDao.findById(id);
	}
	
}
