package org.haven.controller;

import org.haven.bean.Run;
import org.haven.service.RunService;
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

    @RequestMapping(value = "/changeRun", method = RequestMethod.POST)
    public int changeRun(Run run){
        return runService.changeRun(run);
    }

    @RequestMapping(value = "/insertNewRun", method = RequestMethod.POST)
    public int insertNewRun(Run run){
        return runService.insertNewRun(run);
    }

    @RequestMapping(value = "/deleteRun", method = RequestMethod.POST)
    public int deleteRun(int runId){
        return runService.deleteRun(runId);
    }
}
