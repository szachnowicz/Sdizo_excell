package com.szachnowicz.DoubleLinkedList;

public class TimeMessure {

    private long startTime;
    private long duration = 0;

    public TimeMessure() {
        startTime = 0;
        duration = 0;
    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void end() {
        duration += (System.nanoTime() - startTime);
    }

    public long getDuration() {
        return duration;
    }

    public void reset() {
        startTime = 0;
        duration = 0;

}
}
