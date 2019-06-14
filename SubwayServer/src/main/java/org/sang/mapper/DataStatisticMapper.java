package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author HavenTong
 * @Date 2019/6/14 21:35
 */

@Mapper
public interface DataStatisticMapper {

    String searchStationPopulationByTime(Map<String,Object> map);

    List<String> getStation();

    List<Integer> getStationPopulation();
}
