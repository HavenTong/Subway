package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.sang.bean.LineStation;

import java.util.List;

/**
 * @Author HavenTong
 * @Date 2019/6/5 23:24
 */

@Mapper
public interface LineStationMapper {

    List<LineStation> getLineStationByLineNameAndStation(LineStation lineStation);
}
