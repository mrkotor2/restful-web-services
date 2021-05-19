package com.training.spring_aop.business;

import com.training.spring_aop.data.Dao1;
import com.training.spring_aop.data.TrackTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class Business1 {

    private final Dao1 dao1;

    public Business1(Dao1 dao1) {
        this.dao1 = dao1;
    }

    @TrackTime
    public String calculateSomething() {
        return dao1.retrieveData();
    }
}
