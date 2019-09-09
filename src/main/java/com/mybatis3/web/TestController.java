package com.mybatis3.web;

import com.mybatis3.domain.Student;
import com.mybatis3.util.Result;
import com.mybatis3.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TestController extends BaseController {
    @RequestMapping("/map")
    public Result<Map<String, Object>> getMap() throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        map.put("int", Integer.valueOf(3));
        map.put("obj", new Student());
        map.put("nullobj", null);
        return ResultUtil.success(map);
    }

}
