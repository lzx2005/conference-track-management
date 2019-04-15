package io.github.lzx2005.entity;

/**
 * 记录一次talk
 */
public class Talk implements Comparable {
    private String title;
    private int minutes;

    /**
     * 构造方法
     *
     * @param title
     */
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

    /**
     * 从title中提取时间minutes
     *
     * @param title
     * @return
     */
    private int getMinutes(String title) {
        if (title.endsWith("min")) {
            // 如果以 min 结尾，则提取具体的时长
            String[] words = title.split(" ");
            String m = words[words.length - 1];
            String m1 = m.substring(0, m.indexOf("m"));
            return Integer.valueOf(m1);
        } else {
            // 如果以 lighting 结尾，则为5分钟
            return 5;
        }
    }

    @Override
    public String toString() {
        return "Talk{" +
                "title='" + title + '\'' +
                ", minutes=" + minutes +
                '}';
    }

    /**
     * 重写比较方法，首先比较时间，相同时间下，再比较每个标题的哈希值
     * @param o     其他Talk
     * @return      大小
     */
    @Override
    public int compareTo(Object o) {
        if (o instanceof Talk) {
            Talk that = (Talk) o;
            if (this.minutes == that.minutes) {
                return this.title.hashCode() - that.title.hashCode();
            } else {
                return this.minutes - that.minutes;
            }
        }
        return -1;
    }
}
