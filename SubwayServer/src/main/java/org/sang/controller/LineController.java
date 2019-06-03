package org.sang.controller;

import org.sang.bean.Line;
import org.sang.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
