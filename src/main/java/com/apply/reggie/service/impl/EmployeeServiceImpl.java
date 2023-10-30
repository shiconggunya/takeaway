package com.apply.reggie.service.impl;

import com.apply.reggie.entity.Employee;
import com.apply.reggie.mapper.EmployeeMapper;
import com.apply.reggie.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
