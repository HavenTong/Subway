package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sang.bean.Line;

import java.util.List;

/**
 * @Author HavenTong
 * @Date 2019/5/29 17:32
 */

@Mapper
public interface LineMapper {

    @Select("select * from line where lineName = #{lineName}")
    List<Line> getLineByLineName(@Param("lineName") String lineName);
}
