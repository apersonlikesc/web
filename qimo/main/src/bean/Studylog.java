package bean;

public class Studylog {
  private String username;
  private java.sql.Date studydate;
  private String lessonnum;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public java.sql.Date getStudydate() {
    return studydate;
  }

  public void setStudydate(java.sql.Date studydate) {
    this.studydate = studydate;
  }

  public String getLessonnum() {
    return lessonnum;
  }

  public void setLessonnum(String lessonnum) {
    this.lessonnum = lessonnum;
  }
}
