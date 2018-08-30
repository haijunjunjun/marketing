package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.dal.model.CustomerInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class CustomerControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getCustomerInfoTest() throws Exception {
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.get("/marketing/customer/info")
                .header("ACCESS_TOKEN", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNTMwODQ0MDU5LCJzdWIiOiJtYXJrZXRpbmciLCJpc3MiOiJ3d3cubml1bGUuY29tIiwiZXhwIjozMDYxNjg4MTE4fQ.6_iC07JSbCEyffnWLbBkHjx7-0i6OGQXlX0U8e4KaH0");
        MvcResult mvcResult = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }

    @Test
    public void removeCustomerInfoTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setId(1);
        customerInfo.setAbandonReason("不想要了，你能咋滴！！！");

        MockHttpServletRequestBuilder post = MockMvcRequestBuilders.post("/marketing/customer/remove")
                .content(objectMapper.writeValueAsString(customerInfo))
                .header("ACCESS_TOKEN", "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNTMwODU4ODA1LCJzdWIiOiJtYXJrZXRpbmciLCJpc3MiOiJ3d3cubml1bGUuY29tIiwiZXhwIjozMDYxNzE3NjExfQ.0U4YUK673aJ1SV5UFBz9ygfqMTobdxP8Xy6x3SLlSQs");
        MvcResult mvcResult = mockMvc.perform(post).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), mvcResult.getResponse().getStatus());
    }
}
