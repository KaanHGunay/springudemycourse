package com.khg.springdemoapp.controller;

import com.khg.springdemoapp.model.entity.User;
import com.khg.springdemoapp.model.repository.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/test-data.sql")
public class PersonnelControllerTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void addUser() {
        userRepository.save(new User("b", passwordEncoder.encode("b"), "ADMIN", ""));
    }

    @Test
    public void getAllPersonnel() {
        ResponseEntity<String> result = template.withBasicAuth("a", "a")
                .getForEntity("/personnel/all-personnel", String.class);
        logger.info("getAllPersonnel function result -> {}", result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAllPersonnelForACity() {
        ResponseEntity<String> result = template.withBasicAuth("a", "a")
                .getForEntity("/personnel/all-personnel-city?city={city}", String.class, "Ankara");
        logger.info("getAllPersonnelForACity function result -> {}", result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void getAllPersonnelForRank() {
        ResponseEntity<String> result = template.withBasicAuth("a", "a")
                .getForEntity("/personnel/all-personnel-rank?rutbe={rutbe}", String.class, "Polis Memuru");
        logger.info("getAllPersonnelForRank function result -> {}", result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void searchPersonnel() {
        ResponseEntity<String> result = template.withBasicAuth("a", "a")
                .getForEntity("/personnel/search-personnel?name={name}&surname={surname}", String.class, "test", "test");
        logger.info("searchPersonnel function result -> {}", result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
//    @DirtiesContext
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
//    @DirtiesContext
    public void updatePersonnel() throws JSONException {
        JSONObject jsObject = new JSONObject();
        jsObject.put("id", 1);
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
