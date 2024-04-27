package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;



@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering() {
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList() {
        return Arrays.asList(new SomeBean("value1", "value2", "value3"),
                             new SomeBean("value12", "value22", "value32"),
                             new SomeBean("value13", "value23", "value33"));
    }
}

//       In REST APIs, filtering refers to the process of selectively choosing what data to send in the response.
//
//       There are two types of filtering: static and dynamic.
//
//        1. Static Filtering: This type of filtering is done at the code level and is fixed. It means that certain fields are always excluded or
//        included in the response. In your code, static filtering is implemented using the `@JsonIgnore` and `@JsonIgnoreProperties` annotations
//        from the Jackson library. These annotations are used to ignore the serialization or deserialization of certain properties.
//
//        For example, in the `SomeBean` class, `field1` is ignored at the class level using `@JsonIgnoreProperties`, and `field2` is ignored at the field
//        level using `@JsonIgnore`. This means that these fields will not be included in the JSON response when an instance of `SomeBean` is returned f
//        rom a REST endpoint.
//
//@JsonIgnoreProperties(value = {"field1"})
//public class SomeBean {
//    private String field1;
//
//    @JsonIgnore
//    private String field2;
//    //...
//}
//   ```
//
//    2. Dynamic Filtering: This type of filtering allows you to change what data is included in the response at runtime,
//    based on different conditions. This is typically implemented using Jackson's `FilterProvider` and `SimpleBeanPropertyFilter`.
//
//        For example, you might want to return different fields for the same object based on the user's role. An admin user might see all the fields,
//        while a regular user might only see a subset of the fields. This cannot be achieved with static filtering, as the fields to be included or
//        excluded are fixed at compile time.
//
//Here's a simplified example of how you might implement dynamic filtering:
//
//@GetMapping("/dynamic-filtering")
//public MappingJacksonValue dynamicFiltering() {
//    SomeBean someBean = new SomeBean("value1", "value2", "value3");
//
//    SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
//            .filterOutAllExcept("field1", "field2");
//
//    FilterProvider filters = new SimpleFilterProvider()
//            .addFilter("SomeBeanFilter", filter);
//
//    MappingJacksonValue mapping = new MappingJacksonValue(someBean);
//    mapping.setFilters(filters);
//
//    return mapping;
//}
//   ```
//
//In this example, a `SimpleBeanPropertyFilter` is created to filter out all properties except `field1` and `field2`.
// This filter is then added to a `FilterProvider`, which is set on a `MappingJacksonValue` object. The `MappingJacksonValue` object is then returned from the REST endpoint, and only the properties specified in the filter will be included in the JSON response.
