package io.github.lzx2005.entity;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * 测试Talk创建
 */
public class TalkTest {

    @Test
    public void test(){
        String s1 = "Rails Magic 60min";
        String s2 = "Ruby Errors from Mismatched Gem Versions 45min";
        String s3 = "Rails for Python Developers lightning";

        Talk talk1 = new Talk(s1);
        Talk talk2 = new Talk(s2);
        Talk talk3 = new Talk(s3);

        System.out.println(talk1.getMinutes());
        System.out.println(talk2.getMinutes());
        System.out.println(talk3.getMinutes());

        assertEquals(talk1.getMinutes(), 60);
        assertEquals(talk2.getMinutes(), 45);
        assertEquals(talk3.getMinutes(), 5);
    }

}