package com.khg.springdemoapp.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
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
    @DirtiesContext
    public void addPersonnel() throws JSONException {
        JSONObject jsObject = new JSONObject();
        jsObject.put("batchNumber", "666666");
        jsObject.put("name", "test");
        jsObject.put("surname", "test");
        jsObject.put("placeOfBirth", "Bursa");
        jsObject.put("rutbe", "Komiser");
        jsObject.put("isActive", true);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsObject.toString(), headers);
        ResponseEntity<String> result = template.withBasicAuth("a", "a")
                .postForEntity("/personnel/add-personnel", request, String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    @DirtiesContext
    public void updatePersonnel() throws JSONException {
        JSONObject jsObject = new JSONObject();
        jsObject.put("id", 3);
        jsObject.put("batchNumber", "77777");
        jsObject.put("name", "test");
        jsObject.put("surname", "test");
        jsObject.put("placeOfBirth", "Bursa");
        jsObject.put("rutbe", "Komiser");
        jsObject.put("isActive", true);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsObject.toString(), headers);
        template.withBasicAuth("a", "a")
                .put("/personnel/update-personnel", request);
    }
}
