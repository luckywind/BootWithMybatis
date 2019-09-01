package com.mybatis3.web;

//import com.com.mybatis3.domain.Student;
import com.mybatis3.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentRest extends BaseController {
    @RequestMapping("/FindAll")
    public List<Student> findAll() {
        try {
            return getStudentService().findAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("test")
    public String test() {
        return "hello world ";
    }
}
