package io.github.lzx2005;

import io.github.lzx2005.constants.FileLaction;
import io.github.lzx2005.entity.Talk;
import io.github.lzx2005.entity.Track;
import io.github.lzx2005.service.TrackService;
import io.github.lzx2005.tools.FileUtils;

import java.io.File;
import java.util.List;
import java.util.TreeSet;

/**
 * 入口程序
 */
public class App {
    public static void main(String[] args) {
        List<String> list = FileUtils.read(new File(FileLaction.TEXT_FILE));
        if (list == null) {
            throw new RuntimeException("file is null");
        }
        TreeSet<Talk> talks = new TreeSet<>();
        list.forEach(title -> {
            Talk talk = new Talk(title);
            talks.add(talk);
        });
        TrackService trackService = TrackService.getInstance();
        List<Track> tracks = trackService.manage(talks);
        for (int i = 0; i < tracks.size(); i++) {
            Track track = tracks.get(i);
            System.out.println("Track " + (i + 1) + ":");
            System.out.print(track.getMorning().toString());
            System.out.println("12:00PM Lunch");
            System.out.print(track.getAfternoon().toString());
            System.out.println("05:00PM Networking Event");
            System.out.println();
        }
    }
}
