package com.deepak.continuousintegration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
public class ContinuousIntegrationApplicationTests {

	protected static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

}
