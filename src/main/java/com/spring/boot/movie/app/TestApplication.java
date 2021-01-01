package com.spring.boot.movie.app;

import com.spring.boot.movie.app.test.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(TestApplication.class, args);

        TestController controller = (TestController) context.getBean("testController");

        controller.show();

    }

}
