package org.sang.service;

import org.sang.bean.Run;
import org.sang.mapper.RunMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author HavenTong
 * @Date 2019/6/12 1:46
 */

@Service
@Transactional
public class RunService implements RunMapper {

    @Autowired
    RunMapper runMapper;

    public List<Run> getRunByLineName(String lineName){
        return runMapper.getRunByLineName(lineName);
    }

    public int changeRun(Run run){
        return runMapper.changeRun(run);
    }

    public int insertNewRun(Run run){
        return runMapper.insertNewRun(run);
    }

    public int deleteRun(int runId){
        return runMapper.deleteRun(runId);
    }
}
