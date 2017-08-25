package com.protobuf.application;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.protobuf.generated.LibraryProtos;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LibraryApplication.class)
@WebAppConfiguration
@Import({RestClientConfiguration.class})
public class LibraryApplicationTest {

	@Autowired
	private RestTemplate restTemplate;

	@Test
    public void contextLoaded() {

        ResponseEntity<LibraryProtos.Library> library = restTemplate.getForEntity(
                "http://localhost:8080/library/1", LibraryProtos.Library.class);

        Assert.assertEquals(1, library.getBody().getBooks5List().size());
    }

}
