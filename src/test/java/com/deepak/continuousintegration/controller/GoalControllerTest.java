package com.deepak.continuousintegration.controller;

import com.deepak.continuousintegration.ContinuousIntegrationApplicationTests;
import com.deepak.continuousintegration.model.Goal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GoalControllerTest extends ContinuousIntegrationApplicationTests {

    private static final String GOAL_URI = "/v1/api/goal%s";

    MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new GoalController()).build();
    }

    @Test
    void shouldReturnBadRequest() throws Exception {
        // no request body
        mockMvc.perform(post(String.format(GOAL_URI, "/"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        // no name given
        Goal goal = new Goal();
        goal.setDescription("Without name goal");
        mockMvc.perform(post(String.format(GOAL_URI, "/"))
                        .contentType(MediaType.APPLICATION_JSON)
                .content(OBJECT_MAPPER.writeValueAsString(goal)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnSuccess() throws Exception {
        Goal goal = new Goal();
        goal.setName("Test Goal");
        goal.setDescription("Test Goal");
        mockMvc.perform(post(String.format(GOAL_URI, "/"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(OBJECT_MAPPER.writeValueAsString(goal)))
                .andExpect(status().isOk())
                .andExpect(mvcResult -> {
                    mvcResult.getResponse().getStatus();
                    String contentAsString = mvcResult.getResponse().getContentAsString();
                    Goal responseGoal = OBJECT_MAPPER.readValue(contentAsString, new TypeReference<>() {});
                    assertThat(responseGoal.getName()).isEqualTo(goal.getName());
                    assertThat(responseGoal.getDescription()).isEqualTo(goal.getDescription());
                });
    }
}