package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    /**
     * This method is mapped to the "/v1/person" endpoint.
     * It returns a PersonV1 object with the name "Bob Charlie".
     * To use this API from Postman, send a GET request to http://localhost:8080/v1/person
     *
     * @return a new PersonV1 object
     */
    @GetMapping("v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    /**
     * This method is mapped to the "/v2/person" endpoint.
     * It returns a PersonV2 object with the name "Bob Charlie".
     * To use this API from Postman, send a GET request to http://localhost:8080/v2/person
     *
     * @return a new PersonV2 object
     */
    @GetMapping("v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    /**
     * This method is mapped to the "/person" endpoint with a parameter "version=1".
     * It returns a PersonV1 object with the name "Bob Charlie".
     * To use this API from Postman, send a GET request to http://localhost:8080/person?version=1
     *
     * @return a new PersonV1 object
     */
    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Bob Charlie");
    }

    /**
     * This method is mapped to the "/person" endpoint with a parameter "version=2".
     * It returns a PersonV2 object with the name "Bob Charlie".
     * To use this API from Postman, send a GET request to http://localhost:8080/person?version=2
     *
     * @return a new PersonV2 object
     */
    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    /**
     * This method is mapped to the "/person/header" endpoint with a header "X-API-VERSION=1".
     * It returns a PersonV1 object with the name "Bob Charlie".
     * To use this API from Postman, send a GET request to http://localhost:8080/person/header with the header "X-API-VERSION: 1"
     *
     * @return a new PersonV1 object
     */
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Bob Charlie");
    }

    /**
     * This method is mapped to the "/person/header" endpoint with a header "X-API-VERSION=2".
     * It returns a PersonV2 object with the name "Bob Charlie".
     * To use this API from Postman, send a GET request to http://localhost:8080/person/header with the header "X-API-VERSION: 2"
     *
     * @return a new PersonV2 object
     */
    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    /**
     * This method is mapped to the "/person/produces" endpoint and produces a custom media type "application/vnd.company.app-v1+json".
     * It returns a PersonV1 object with the name "Bob Charlie".
     * To use this API from Postman, send a GET request to http://localhost:8080/person/produces with the header "Accept: application/vnd.company.app-v1+json"
     *
     * @return a new PersonV1 object
     */
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Bob Charlie");
    }

    /**
     * This method is mapped to the "/person/produces" endpoint and produces a custom media type "application/vnd.company.app-v2+json".
     * It returns a PersonV2 object with the name "Bob Charlie".
     * To use this API from Postman, send a GET request to http://localhost:8080/person/produces with the header "Accept: application/vnd.company.app-v2+json"
     *
     * @return a new PersonV2 object
     */
    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}