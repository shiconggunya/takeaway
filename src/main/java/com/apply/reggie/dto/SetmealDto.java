package com.apply.reggie.dto;

import com.apply.reggie.entity.Setmeal;
import com.apply.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
