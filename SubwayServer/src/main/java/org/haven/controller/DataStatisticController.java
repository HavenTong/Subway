package org.haven.controller;

import org.haven.bean.StationWithDate;
import org.haven.bean.TimeInterval;
import org.haven.service.DataStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HavenTong
 * @Date 2019/6/14 22:29
 */

@RestController
@RequestMapping("/dataStatistic")
public class DataStatisticController {

    @Autowired
    DataStatisticService dataStatisticService;

    @RequestMapping(value = "/stationPopulation", method = RequestMethod.POST)
    public Map<String, Object> stationPopulation(TimeInterval timeInterval){
        Map<String, Object> map = new HashMap<>();
        map.put("startTime", timeInterval.getStartTime());
        map.put("endTime", timeInterval.getEndTime());
        map.put("date", timeInterval.getDate());
        String result = dataStatisticService.searchStationPopulationByTime(map);
        System.out.println("Call graphStationPopulation ==> " + result);
        List<String> stations = dataStatisticService.getStation();
        List<Integer> stationPopulation = dataStatisticService.getStationPopulation();
        map.put("stations", stations);
        map.put("stationPopulation", stationPopulation);
        return map;
    }

    @RequestMapping(value = "/timePopulation",method = RequestMethod.POST)
    public Map<String,Object> timePopulation(StationWithDate stationWithDate){
        Map<String,Object> map = new HashMap<>();
        map.put("stationName", stationWithDate.getStationName());
        map.put("date", stationWithDate.getDate());
        String result = dataStatisticService.searchTimePopulationByStation(map);
        System.out.println("Call graphTimePopulation ==> " + result);
        List<String> timeIntervals = dataStatisticService.getTimeInterval();
        List<Integer> timePopulation = dataStatisticService.getTimePopulation();
        map.put("timeIntervals", timeIntervals);
        map.put("timePopulation", timePopulation);
        return map;
    }

}
