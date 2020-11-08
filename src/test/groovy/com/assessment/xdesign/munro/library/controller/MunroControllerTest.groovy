package com.assessment.xdesign.munro.library.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MunroControllerTest extends Specification{

    @Autowired
    MockMvc mvc;

    def "when get with id parameter is performed then the response has status 200 and return content"() {
        expect: "Status is 200 and the response contains munro name 'Ben Chonzie'"

        mvc.perform(get("/api/munro/{runningNo}",1))
                .andExpect(status().isOk())
                .andReturn()
                .response
                .contentAsString.contains("Ben Chonzie") == true

    }

}
