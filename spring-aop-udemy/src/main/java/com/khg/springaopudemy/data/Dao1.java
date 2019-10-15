package com.khg.springaopudemy.data;

import com.khg.springaopudemy.aspect.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    @TrackTime
    public String retrieveSomeData() {
        return "Dao1";
    }
}
