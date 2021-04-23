package com.training.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Dynamic filtering example
@RestController
public class FilterController {

    //field1, field2
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        String[] fields = {"field1", "field2"};

        return getMappingJacksonValue(Collections.singletonList(someBean), fields);
    }

    //field2, field3
    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveListOfSomeBean() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));
        String[] fields = {"field2", "field3"};

        return getMappingJacksonValue(list, fields);
    }

    private MappingJacksonValue getMappingJacksonValue(List<SomeBean> list, String[] fieldsToKeep) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToKeep);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);
        return mapping;
    }
}
