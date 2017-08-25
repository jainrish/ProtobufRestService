package com.protobuf.config;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.protobuf.dao.LibraryDao;
import com.protobuf.generated.LibraryProtos;
import com.protobuf.generated.LibraryProtos.Library.OrganizationType;

@Configuration
public class DaoConfig {

	@Bean
	LibraryDao libraryDao() {
		LibraryProtos.Book book = LibraryProtos.Book.newBuilder().setAuthor("R.D.Sharma").setName("Mathematics").setPages(400).setBookID(1).build();
		Map<Integer, LibraryProtos.Library> libraries = new ConcurrentHashMap<Integer, LibraryProtos.Library>();
		Arrays.asList(
				LibraryProtos.Library.newBuilder().setLibraryID(1)
						.setOrganizationType(OrganizationType.ACADEMIC)
						.setOrganization("D.A.V Public School").addBooks5(book).build(),
				LibraryProtos.Library.newBuilder().setLibraryID(2)
						.setOrganizationType(OrganizationType.ACADEMIC)
						.setOrganization("Air Force School").addBooks5(book).build(),
				LibraryProtos.Library.newBuilder().setLibraryID(3)
						.setOrganizationType(OrganizationType.ACADEMIC)
						.setOrganization("ABC School").addBooks5(book).build(),
				LibraryProtos.Library.newBuilder().setLibraryID(4)
						.setOrganizationType(OrganizationType.ACADEMIC)
						.setOrganization("XYZ School").addBooks5(book).build())
				.forEach(
						library -> libraries.put(library.getLibraryID(),
								library));
		return libraries::get;
	}
}
