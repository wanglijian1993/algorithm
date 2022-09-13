public class Resume {
    String xm;      //姓名
    int nl;        // 年龄
    String jtzz;   // 家庭住址
    String xl;     // 学历

    public Resume(String xm, int nl, String jtzz, String xl) {
        this.xm = xm;
        this.nl = nl;
        this.jtzz = jtzz;
        this.xl = xl;
    }

    public Resume(String xm, String jtzz, String xl) {
        this.xm = xm;
        this.jtzz = jtzz;
        this.xl = xl;
    }

    public Resume(String xm, int nl) {
        this.xm = xm;
        this.nl = nl;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "姓名='" + xm + '\'' +
                ", 年龄=" + nl +
                ", 家庭住址='" + jtzz + '\'' +
                ", 学历='" + xl + '\'' +
                '}';
    }

    public String resumeInfo(){
       return this.toString();
    }
}

class Text{

    public static void main(String[] args) {
        Resume resume1=new Resume("高晶晶","海淀区车道沟小区","本科");
        Resume resume2=new Resume("王智广",-25);
        Resume resume3=new Resume("李灿星",28,"朝阳区仰山桥西里","研究生");
    }

}
