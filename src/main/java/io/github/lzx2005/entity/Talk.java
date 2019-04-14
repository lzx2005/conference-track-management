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

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    private int getMinutes(String title){
        if(title.endsWith("min")){
            String[] words = title.split(" ");
            String m = words[words.length-1];
            String m1 = m.substring(0, m.indexOf("m"));
            return Integer.valueOf(m1);
        } else {
            return 5;
        }
    }
}
