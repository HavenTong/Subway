package org.haven.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.haven.bean.Line;

import java.util.List;
import java.util.Map;

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

    String insertLine(Map<String,Object> map);
}
