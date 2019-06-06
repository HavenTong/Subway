package org.sang.service;

import org.sang.bean.LineStation;
import org.sang.mapper.LineStationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author HavenTong
 * @Date 2019/6/5 23:36
 */

@Service
@Transactional
public class LineStationService implements LineStationMapper {

    @Autowired
    LineStationMapper lineStationMapper;

    public List<LineStation> getLineStationByLineNameAndStation(LineStation lineStation){
        return lineStationMapper.getLineStationByLineNameAndStation(lineStation);
    }



}
