package com.mybatis3.apps;

import com.mybatis3.domain.Student;
import com.mybatis3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DemoApp {
    @Autowired
    StudentService studentService;
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DemoApp app = new DemoApp();
//        app.hello(); //自己new出来的类没有注入studentService类
        DemoApp demoApp = applicationContext.getBean(DemoApp.class);
//        demoApp.hello();
    }
    @Bean
    public  String  hello() {
        List<Student> allStudents = studentService.findAllStudents();
//        for (Student allStudent : allStudents) {
//            System.out.println(allStudent);
//        }
        return "Sucecess";
    }
}
