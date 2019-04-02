package test.config;

public class Student {
    private String Sno;     // 学号
    private String Sname;   // 姓名
    private String Ssex;    // 性别
    private int Sage;    // 年龄
    private String Sdept;   // 学院
    private String Spassword;   // 口令

    public Student(String Sno, String Sname, String Ssex,
                   int Sage, String Sdept, String Spassword){
        this.Sno = Sno;
        this.Sname = Sname;
        this.Ssex = Ssex;
        this.Sage = Sage;
        this.Sdept = Sdept;
        this.Spassword = Spassword;
    }

    public int getSage() { return Sage; }

    public void setSage(int sage) { this.Sage = sage; }

    public String getSdept() { return Sdept; }

    public void setSdept(String sdept) { this.Sdept = sdept; }

    public String getSname() { return Sname; }

    public void setSname(String sname) { this.Sname = sname; }

    public String getSno() { return Sno; }

    public void setSno(String sno) { Sno = sno; }

    public String getSpassword() { return Spassword; }

    public void setSpassword(String spassword) { Spassword = spassword; }

    public String getSsex() { return Ssex; }

    public void setSsex(String ssex) { Ssex = ssex; }

    public String toString(){
        return "学生身份信息：" +
                "Sno = " + Sno +
                ", Sname = " + Sname +
                ", Ssex = " + Ssex +
                ", Sage = " + Sage +
                ", Sdept = " + Sdept +
                ", Spassword = " + Spassword;
    }
}
