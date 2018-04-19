package com.szachnowicz.resulsts;

import java.util.*;

public class Result {
    //          addBeing , 1000, 1,4 sec
    public String operationTested;
    List<Integer> instanceList = new ArrayList<>();
    public List<Long> timeList = new ArrayList<>();


    public Result(String operationTested) {
        this.operationTested = operationTested;
    }

    public String getOperationTested() {
        return operationTested;
    }

    public void addMessureTime(int instance, long time) {
        instanceList.add(instance);
        timeList.add(time / instance);
    }

    public void setOperationTested(String operationTested) {
        this.operationTested = operationTested;
    }
}
