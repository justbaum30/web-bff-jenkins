package com.justbaum.webbff;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class WebBffControllerTest {

    @MockBean
    private UserClient userClient;
    @InjectMocks
    private WebBffController webBffController;

    @Test
    public void getTestData_ReturnsString() {
        assertThat(webBffController.getTestData()).isEqualTo("this is a second test");
    }
}