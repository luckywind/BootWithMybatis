package com.mybatis3.web;

//import com.com.mybatis3.domain.Student;
import com.mybatis3.domain.Student;
import com.mybatis3.util.Result;
import com.mybatis3.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Student")
public class StudentController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    /**
     * 在controller中尽管抛异常，由全局异常处理器去统一处理
     * @return
     * @throws Exception
     */
    @RequestMapping("/FindAll")
    public List<Student> findAll() throws Exception {
        return getStudentService().findAllStudents();
    }

    @RequestMapping("test")
    public String test() {
        return "hello world ";
    }

    @RequestMapping("findStudentById")
    public Student findStudentById(@RequestParam("id") Integer id) throws Exception {
        return getStudentService().findStudentById(id);
    }

    @RequestMapping("findStudentByIdWithAddress")
    public Student findStudentByIdWithAddress(@RequestParam("id") Integer id) throws Exception {
        return getStudentService().findStudentWithAddressById(id);
    }


    @GetMapping("getAll")

    public List<Student> getAll() throws Exception {
        List<Student> studentList = getStudentService().findAllStudents();
        return studentList;
    }

    @GetMapping("byid")
    public ResponseEntity all(@RequestParam("id") Integer id) throws Exception {
        Student student = getStudentService().findStudentWithAddressById(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("asMap")
    public Result getStudentMap() throws Exception {
        List<Map<String, Object>> studentsMap = getStudentService().findAllStudentsMap();
        return ResultUtil.success(studentsMap);
    }
}
