package bean;

import java.sql.Date;

public class Info {
    private String info_class;
    private String title;
    private String info;
    private java.sql.Date createdate;


    public String getInfo_class() {
        return info_class;
    }

    public void setInfo_class(String info_class) {
        this.info_class = info_class;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}
