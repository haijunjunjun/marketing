package com.example.demo.controller;

import com.example.demo.DemoApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
public class UserInfoControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void login() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/login").param("id", "18306845521").param("pass", "123456");
        MvcResult mvcResult = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
}
