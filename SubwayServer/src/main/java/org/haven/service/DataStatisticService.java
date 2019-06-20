package org.haven.service;

import org.haven.mapper.DataStatisticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author HavenTong
 * @Date 2019/6/14 21:48
 */
@Service
@Transactional

public class DataStatisticService implements DataStatisticMapper{

    @Autowired
    DataStatisticMapper dataStatisticMapper;

    public String searchStationPopulationByTime(Map<String, Object> map){
        dataStatisticMapper.searchStationPopulationByTime(map);
        return (String) map.get("result");
    }

    public List<String> getStation(){
        return dataStatisticMapper.getStation();
    }

    public List<Integer> getStationPopulation(){
        return dataStatisticMapper.getStationPopulation();
    }

    public String searchTimePopulationByStation(Map<String, Object> map){
        dataStatisticMapper.searchTimePopulationByStation(map);
        return (String)map.get("result");
    }

    public List<String> getTimeInterval(){
        return dataStatisticMapper.getTimeInterval();
    }

    public List<Integer> getTimePopulation(){
        return dataStatisticMapper.getTimePopulation();
    }
}
