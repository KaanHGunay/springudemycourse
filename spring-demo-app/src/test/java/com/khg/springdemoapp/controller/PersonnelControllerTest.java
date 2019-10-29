package com.khg.springdemoapp.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonnelControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getAllPersonnel() {
        ResponseEntity<String> result = template.withBasicAuth("a", "a")
                .getForEntity("/personnel/all-personnel", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAllPersonnelForACity() {
        ResponseEntity<String> result = template.withBasicAuth("a", "a")
                .getForEntity("/personnel/all-personnel-city?city={city}", String.class, "Bursa");
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAllPersonnelForRank() {
        ResponseEntity<String> result = template.withBasicAuth("a", "a")
                .getForEntity("/personnel/all-personnel-rank?rutbe={rutbe}", String.class, "Polis Memuru");
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void searchPersonnel() {
        ResponseEntity<String> result = template.withBasicAuth("a", "a")
                .getForEntity("/personnel/search-personnel?name={name}&surname={surname}", String.class, "Kaan", "Günay");
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void addPersonnel() {
    }

    @Test
    public void updatePersonnel() {
    }
}
