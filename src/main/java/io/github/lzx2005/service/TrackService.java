package io.github.lzx2005.service;

import io.github.lzx2005.entity.Talk;
import io.github.lzx2005.entity.Track;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

/**
 * 主逻辑代码
 *
 * @author Li Zhengxian
 */
public class TrackService {

    private static final TrackService trackService = new TrackService();

    private TrackService() {
    }

    public static TrackService getInstance() {
        return trackService;
    }

    /**
     * 安排会议日程
     *
     * @param talks 会议列表
     * @return 日程列表
     */
    public List<Track> manage(TreeSet<Talk> talks) {
        LinkedList<Track> tracks = new LinkedList<>();
        tracks.add(new Track());
        talks.descendingSet().forEach(talk -> {
            boolean success = false;
            for (Track track : tracks) {
                if (track != null) {
                    success = track.addTalk(talk);
                    if(success) break;
                }

            }
            if (!success) {
                Track trackNew = new Track();
                trackNew.addTalk(talk);
                tracks.add(trackNew);
            }
        });
        return tracks;
    }
}
