package com.liaofan.adminex.Mapper;


import com.liaofan.adminex.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    @Select("select * from city where id=#{id}")
    City getCityById(Long id);       //通过id获取城市信息

    void insertCity(City city);     //插入城市信息


}
