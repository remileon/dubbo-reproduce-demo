package com.dubbo_demo.client.controller;

import com.dubbo_demo.client.service.StudentService;
import com.dubbo_demo.client.service.TeacherService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DubboController {
    @Reference(check = false, mock = "true")
    private StudentService studentService;
    @Reference(check = false, mock = "true")
    private TeacherService teacherService;

    @RequestMapping(value = "/api/test/dubbo", method = RequestMethod.GET)
    public int test() {
        teacherService.getTeacherId();
        return studentService.getStudentId();
    }

    @RequestMapping(value = "/api/test/dubbo/single", method = RequestMethod.GET)
    public int test2() {
        return studentService.getStudentId();
    }
}
