package io.github.lzx2005.entity;

public class Talk {
    private String title;
    private int minutes;

    public Talk(String title) {
        this.title = title;
        this.minutes = this.getMinutes(title);
    }

    public String getTitle() {
        return title;
    }

    public int getMinutes() {
        return minutes;
    }

    private int getMinutes(String title){
        if(title.endsWith("min")){
            // 如果以 min 结尾，则提取具体的时长
            String[] words = title.split(" ");
            String m = words[words.length-1];
            String m1 = m.substring(0, m.indexOf("m"));
            return Integer.valueOf(m1);
        } else {
            // 如果以 lighting 结尾，则为5分钟
            return 5;
        }
    }
}
