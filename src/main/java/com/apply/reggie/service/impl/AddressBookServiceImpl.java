package com.apply.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apply.reggie.entity.AddressBook;
import com.apply.reggie.service.AddressBookService;
import com.apply.reggie.mapper.AddressBookMapper;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【address_book(地址管理)】的数据库操作Service实现
* @createDate 2023-10-29 11:46:14
*/
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook>
    implements AddressBookService{

}




