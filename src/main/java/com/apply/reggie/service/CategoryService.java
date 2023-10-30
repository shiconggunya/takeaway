package com.apply.reggie.service;

import com.apply.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CategoryService extends IService<Category> {
    //根据ID删除分类
    public void remove(Long id);
}
