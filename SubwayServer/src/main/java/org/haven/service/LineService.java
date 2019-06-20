package org.haven.service;

import org.haven.bean.Line;
import org.haven.mapper.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author HavenTong
 * @Date 2019/5/29 17:34
 */

@Service
@Transactional
public class LineService implements LineMapper {

    @Autowired
    LineMapper lineMapper;

    public List<Line> getLineByLineName(String lineName){
        return lineMapper.getLineByLineName(lineName);
    }

    public int updateLine(Line line) {
        return lineMapper.updateLine(line);
    }

    public String insertLine(Map<String,Object> map){
        lineMapper.insertLine(map);
        return (String)map.get("result");
    }
}
