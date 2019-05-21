package com.example.pradhan.iep_parent_portal.responseVO;

import java.util.List;

public class ObjectiveDto {

    private int objectiveID;
    private String objectiveDescription;
    private String startDate;
    private String completionDate;
    private String actualCompetionDate;
    private int isCompleted;
    private int inProgress;
    private int notStarted;
    private int studentID;
    private int goalID;
    private List<TaskDto> taskDtoList;
}
