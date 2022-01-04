package cn.edu.tongji.uniplus.notificationcenter.payload;

/**
 * @author tangshuo
 * @version 1.0.0
 * @ClassName MessageBody.java
 * @Description TODO
 * @createTime 2021年12月30日 17:52:00
 */
public class MessageBody {
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String content;

}
