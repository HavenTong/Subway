package org.haven.controller;

import org.haven.bean.Line;
import org.haven.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author HavenTong
 * @Date 2019/5/29 17:38
 */

@RestController
@RequestMapping("/lineInfo")
public class LineController {

    @Autowired
    LineService lineService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public List<Line> getLineByLineName(String lineName){
        return lineService.getLineByLineName(lineName);
    }

    @RequestMapping(value = "/changeInfo", method = RequestMethod.POST)
    public int updateLine(Line line){
        return lineService.updateLine(line);
    }

    @RequestMapping(value = "/insertLine", method = RequestMethod.POST)
    public String insertLine(Line line){
        Map<String,Object> hashmap = new HashMap<>();
        hashmap.put("lineName", line.getLineName());
        hashmap.put("origin", line.getOrigin());
        hashmap.put("destination", line.getDestination());
        hashmap.put("startTime", line.getStartTime());
        hashmap.put("endTime", line.getEndTime());
        return lineService.insertLine(hashmap);
    }
}
