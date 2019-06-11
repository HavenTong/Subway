package org.sang.controller;

import org.sang.bean.Run;
import org.sang.service.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author HavenTong
 * @Date 2019/6/12 1:47
 */

@RestController
@RequestMapping("/run")

public class RunController {

    @Autowired
    RunService runService;

    @RequestMapping(value = "/searchRun", method = RequestMethod.POST)
    public List<Run> getRunByLineName(String lineName){
        return runService.getRunByLineName(lineName);
    }

}
