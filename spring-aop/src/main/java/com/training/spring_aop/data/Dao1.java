package com.training.spring_aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
    @TrackTime
    public String retrieveData(){
        return "Dao1";
    }
}
