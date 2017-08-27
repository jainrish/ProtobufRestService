package com.protobuf.web;

import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protobuf.generated.LibraryProtos;

@RestController
public class LibraryRestController {

	@Autowired
	LibraryProtos.Libraries librariesProto;

	@RequestMapping("/librariesProto")
	@Produces("application/x-protobuf")
	public LibraryProtos.Libraries getBookByID() {
		return librariesProto;
	}

}
