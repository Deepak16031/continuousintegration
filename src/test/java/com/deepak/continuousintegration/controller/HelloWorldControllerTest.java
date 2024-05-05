package com.deepak.continuousintegration.controller;

import com.deepak.continuousintegration.ContinuousIntegrationApplicationTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class HelloWorldControllerTest extends ContinuousIntegrationApplicationTests {

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }

    @Test
    void testResponse() throws Exception {
        mockMvc.perform(get("/v1/api/hello"))
                .andExpect(status().isOk())
                .andDo(mvcResult -> {
                    String contentAsString = mvcResult.getResponse().getContentAsString();
                    assertEquals(contentAsString, "World!");
                });
    }
}