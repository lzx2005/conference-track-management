package io.github.lzx2005.service;

import io.github.lzx2005.entity.Talk;
import io.github.lzx2005.entity.Track;
import org.junit.Test;

import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class TrackServiceTest {

    @Test
    public void manage() {

        String s1 = "Rails Magic 60min";
        String s2 = "Ruby Errors from Mismatched Gem Versions 45min";
        String s3 = "Rails for Python Developers lightning";

        Talk talk1 = new Talk(s1);
        Talk talk2 = new Talk(s2);
        Talk talk3 = new Talk(s3);

        TreeSet<Talk> talks = new TreeSet<>();
        talks.add(talk1);
        talks.add(talk3);
        talks.add(talk2);
        TrackService instance = TrackService.getInstance();
        List<Track> manage = instance.manage(talks);
        for (Track track : manage) {
            System.out.println(track.getMorning());
            System.out.println(track.getAfternoon());
        }
        assertTrue(manage.size() > 0);
    }
}