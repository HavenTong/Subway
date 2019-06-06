package org.sang.controller;

import org.sang.bean.LineStation;
import org.sang.service.LineStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
