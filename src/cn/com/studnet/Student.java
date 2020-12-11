package cn.com.studnet;

public class Student {
    public String stuID;
    public String stuName;
    public String sex;
    public int age;
    public String phone;

    //全参构造
    public Student(String ID,String name,String s,int a,String ph){
        stuID = ID;
        stuName = name;
        sex = s;
        age = a;
        phone = ph;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
