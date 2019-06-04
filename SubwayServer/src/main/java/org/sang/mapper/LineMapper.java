package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sang.bean.Line;

import java.util.List;

/**
 * @Author HavenTong
 * @Date 2019/5/29 17:32
 */

@Mapper
public interface LineMapper {

//    @Select("select * from line where lineName = #{lineName}")
    List<Line> getLineByLineName(String lineName);

//    @Update("update line set startTime = #{startTime}, " +
//            "endTime = #{endTime} where (lineName = #{lineName}) and (origin = #{origin})")
    int updateLine(Line line);
}
