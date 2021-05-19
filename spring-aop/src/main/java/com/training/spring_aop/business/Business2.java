package com.training.spring_aop.business;

import com.training.spring_aop.data.Dao1;
import com.training.spring_aop.data.Dao2;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class Business2 {

    private final Dao2 dao2;

    public Business2(Dao2 dao2) {
        this.dao2 = dao2;
    }

    public String calculateSomething() {
        return dao2.retrieveData();
    }
}
