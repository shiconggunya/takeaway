package com.apply.reggie.controller;

import com.apply.reggie.common.R;
import com.apply.reggie.entity.Employee;
import com.apply.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
@Controller
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        //1、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee employee1 = employeeService.getOne(queryWrapper);

        //2、如果没有查询到则返回登录失败结果
        if(Objects.isNull(employee1)) return R.error("用户名不存在");

        //3、将页面提交的密码password进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //4、密码比对，如果不一致则返回登录失败结果
        if(!Objects.equals(password,employee1.getPassword())) return R.error("密码错误");

        //5、查看员工状态，如果为已禁用状态，则返回员工已禁用结果
        if(employee1.getStatus() == 0) return R.error("用户已已禁用");

        //6、登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("employee",employee1.getId());
        return R.success(employee1);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody Employee employee){
        employee.setPassword(DigestUtils.md5DigestAsHex("123123".getBytes()));
        employeeService.save(employee);
        return R.success("新增成功");
    }

    @GetMapping("/page")
    public R<Page<Employee>> page(int page,int pageSize,String name){
        Page<Employee> employeePage = new Page<>(page,pageSize);

        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(name),Employee::getName,name);
        wrapper.orderByAsc(Employee::getUpdateTime);

        employeeService.page(employeePage,wrapper);
        return R.success(employeePage);
    }

    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
        employeeService.updateById(employee);
        return R.success("员工信息修改成功");
    }


    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if(employee != null){
            return R.success(employee);
        }
        return R.error("没有查询到对应员工信息");
    }
}
