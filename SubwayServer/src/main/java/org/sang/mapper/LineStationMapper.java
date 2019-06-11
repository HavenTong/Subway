package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.LineStation;

import java.util.List;
import java.util.Map;

/**
 * @Author HavenTong
 * @Date 2019/6/5 23:24
 */

@Mapper
public interface LineStationMapper {

    List<LineStation> getLineStationByLineNameAndStation(LineStation lineStation);

    String insertStation(Map<String, Object> map);
}
