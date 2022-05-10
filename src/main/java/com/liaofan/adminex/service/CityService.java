package com.liaofan.adminex.service;

import com.liaofan.adminex.Mapper.CityMapper;
import com.liaofan.adminex.bean.City;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class CityService {
    @Resource
    private CityMapper cityMapper;

    Counter counter;        //计数器
    public CityService(MeterRegistry meterRegistry) {    //构造函数
        counter = meterRegistry.counter("city.insert.count");   //计数器
    }

    public City getCityById(Long id) {
        return cityMapper.getCityById(id);
    }

    public void insertCity(City city) {
        counter.increment();              //计数器计数
        cityMapper.insertCity(city);      //插入数据
    }









}
