package bean;

public class Lesson {
  private int lessonnum;
  private String lessonname;
  private String lessonclass;
  private String lessinfo;
  private java.sql.Date lessbg;
  private java.sql.Date lessend;
  private String teacher;
  private String pic;
  private int amount;

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getLessonnum() {
    return lessonnum;
  }

  public void setLessonnum(int lessonnum) {
    this.lessonnum = lessonnum;
  }

  public String getLessonname() {
    return lessonname;
  }

  public void setLessonname(String lesssonname) {
    this.lessonname = lesssonname;
  }

  public String getLessonclass() {
    return lessonclass;
  }

  public void setLessonclass(String lessonclass) {
    this.lessonclass = lessonclass;
  }

  public String getLessinfo() {
    return lessinfo;
  }

  public void setLessinfo(String lessinfo) {
    this.lessinfo = lessinfo;
  }

  public java.sql.Date getLessbg() {
    return lessbg;
  }

  public void setLessbg(java.sql.Date lessbg) {
    this.lessbg = lessbg;
  }

  public java.sql.Date getLessend() {
    return lessend;
  }

  public void setLessend(java.sql.Date lessend) {
    this.lessend = lessend;
  }

  public String getTeacher() {
    return teacher;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }
}
