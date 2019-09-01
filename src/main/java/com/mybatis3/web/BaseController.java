package com.mybatis3.web;

//import com.com.mybatis3.services.StudentService;
import com.mybatis3.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    private StudentService studentService;

    public StudentService getStudentService() throws Exception {
        if (studentService == null) {
            System.out.println("studentService has not inited");
            throw new Exception("studentService 没有初始化");
        }
        return studentService;
    }




}
