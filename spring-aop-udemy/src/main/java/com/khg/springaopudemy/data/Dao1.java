package com.khg.springaopudemy.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    public String retrieveSomeData() {
        return "Dao1";
    }
}
