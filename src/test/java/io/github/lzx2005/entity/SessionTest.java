package io.github.lzx2005.entity;

import io.github.lzx2005.enums.SessionType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SessionTest {

    private Talk talk1;
    private Talk talk2;
    private Talk talk3;
    private Session session;

    @Before
    public void before() {
        String s1 = "Rails Magic 60min";
        String s2 = "Ruby Errors from Mismatched Gem Versions 45min";
        String s3 = "Rails for Python Developers lightning";

        this.talk1 = new Talk(s1);
        this.talk2 = new Talk(s2);
        this.talk3 = new Talk(s3);
        session = new Session(SessionType.MORNING);
    }

    @Test
    public void addTalk() {
        session.addTalk(talk1);
        session.addTalk(talk2);
        session.addTalk(talk3);
        int restMinutes = session.getRestMinutes();
        System.out.println(restMinutes);
        String s = session.toString();
        System.out.println(s);
    }

}