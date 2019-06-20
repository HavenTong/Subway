package org.haven.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.haven.bean.Run;

import java.util.List;

/**
 * @Author HavenTong
 * @Date 2019/6/12 1:36
 */

@Mapper
public interface RunMapper {

    List<Run> getRunByLineName(String lineName);

    int changeRun(Run run);

    int insertNewRun(Run run);

    int deleteRun(int runId);
}
