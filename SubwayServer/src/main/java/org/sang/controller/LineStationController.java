package org.sang.controller;

import org.sang.bean.Line;
import org.sang.bean.LineStation;
import org.sang.service.LineStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HavenTong
 * @Date 2019/6/5 23:40
 */

@RestController
@RequestMapping("/stationInfo")
public class LineStationController {

    @Autowired
    LineStationService lineStationService;

    @RequestMapping(value = "/searchStation", method = RequestMethod.POST)
    public List<LineStation> getLineStationByLineNameAndStation(LineStation lineStation){
        return lineStationService.getLineStationByLineNameAndStation(lineStation);
    }

    @RequestMapping(value = "/insertStation", method = RequestMethod.POST)
    public String insertStation(LineStation lineStation){
        System.out.println("lineName ==> " + lineStation.getLineName());
        System.out.println("origin ==> " + lineStation.getOrigin());
        System.out.println("stationName ==> " + lineStation.getStationName());
        Map<String, Object> map = new HashMap<>();
        map.put("lineName", lineStation.getLineName());
        map.put("origin", lineStation.getOrigin());
        map.put("stationName", lineStation.getStationName());
        return lineStationService.insertStation(map);
    }
}
