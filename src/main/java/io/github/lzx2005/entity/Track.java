package io.github.lzx2005.entity;

import io.github.lzx2005.enums.SessionType;

/**
 * 记录一天的工作，分为上午下午
 */
public class Track {
    private Session morning;
    private Session afternoon;

    public Track() {
        this.morning = new Session(SessionType.MORNING);
        this.afternoon = new Session(SessionType.AFTERNOON);
    }

    public Session getMorning() {
        return morning;
    }

    public void setMorning(Session morning) {
        this.morning = morning;
    }

    public Session getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(Session afternoon) {
        this.afternoon = afternoon;
    }

    public boolean addTalk(Talk talk) {
        if (morning.getRestMinutes() >= talk.getMinutes()) {
            //如果早上还要富余时间
            morning.addTalk(talk);
        } else if (afternoon.getRestMinutes() >= talk.getMinutes()) {
            //如果下午还有富余时间
            afternoon.addTalk(talk);
        } else {
            //没有富余时间了
            return false;
        }
        return true;
    }

}
