package com.in28minutes.rest.webservices.restfulwebservices.filtering;

// For /filtering mapping we will filter out field1

// For /filtering-list mapping we will filter out field2

// We will use dynamic filtering in both cases

// The logic to filter will have to be in the REST API controller
// -- MappingJacksonValue is a class that is used to filter out fields dynamically


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicFilteringController {

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue retrieveSomeBean() {
        DynamicFilterBean someBean = new DynamicFilterBean("value1", "value2", "value3");

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilterBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping(path = "/filtering-list-dynamic")
    public MappingJacksonValue retrieveListOfSomeBeans() {
        DynamicFilterBean someBean1 = new DynamicFilterBean("value1", "value2", "value3");
        DynamicFilterBean someBean2 = new DynamicFilterBean("value12", "value22", "value32");
        DynamicFilterBean someBean3 = new DynamicFilterBean("value13", "value23", "value33");

        MappingJacksonValue mapping = new MappingJacksonValue(new DynamicFilterBean[]{someBean1, someBean2, someBean3});
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicFilterBeanFilter", filter);
        mapping.setFilters(filters);

        return mapping;
    }
}
