package org.sang.service;

import org.sang.bean.Line;
import org.sang.mapper.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
