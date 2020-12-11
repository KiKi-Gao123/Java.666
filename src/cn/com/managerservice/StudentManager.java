package cn.com.managerservice;



import cn.com.studnet.Student;

import java.util.Scanner;

public class StudentManager {
    //创建扫描器对象
    Scanner input = new Scanner(System.in);

    //定义存放学生对象的数组
    Student[] students = new Student[10];


    //欢迎界面
    public void welcome(){
        System.out.println("欢迎使用学生管理系统");
        System.out.println("制作人：高琪");
        System.out.println("1:登录 2:注册 3:找回密码 0:注销");

        int choose = input.nextInt();

        switch (choose){
            case 1:
                login();
                break;
            case 2:

            case 3:

            case 0:
                System.out.println("正在研发中...");
                System.exit(0);//退出系统
                break;
            default:
                System.out.println("您的输入有误，请重新输入！");
                welcome();
                break;
        }
    }

    //登录界面:账号密码正确执行菜单，账号密码错误再次登录
    public void login(){
        System.out.println("账号");
        String name = input.next();
        System.out.println("密码：");
        String password = input.next();

        if (name.equals("gaoqi")&&password.equals("201902857")){
            menu();
        }else {
            System.out.println("您的账号或密码错误，请重新输入！");
            login();
        }
    }
    //菜单：实现查询，增，删，改等功能
    public void menu(){
        System.out.println("1:增加学生");
        System.out.println("2:查询学生");
        System.out.println("3:删除学生");
        System.out.println("4:修改学生信息");
        System.out.println("5:显示所有学生");
        System.out.println("0:退出系统");
        System.out.println("请选择:");

        int choose = input.nextInt();
        switch (choose){
            case 1:
                addStudent();
                break;
            case 2:
                findStudent();
                break;
            case 3:
                deleteStudent()  ;
                break;
            case 4:
                updateStudent();
                break;
            case 5:
                showAllStudent();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("您的输入有误，请重新输入！");
                menu();
                break;
        }
    }
    //1.添加学生
    public void addStudent(){
        System.out.println("学生编号：");
        String stuID = input.next();
        System.out.println("姓名：");
        String stuname = input.next();
        System.out.println("性别：");
        String sex = input.next();
        System.out.println("年龄：");
        int age = input.nextInt();
        System.out.println("手机号");
        String phone = input.next();

        //创建学生对象
        Student stu = new Student(stuID,stuname,sex,age,phone);

        //将学生存储起来
        //循环遍历，确保存储前有空间
        for (int i=0;i<students.length;i++){
            if (students[i]==null){
                students[i] = stu;
                break;
            }
        }

        System.out.println("添加成功！是否继续添加？Y/N");
        String choose = input.next();
        if (choose.equals("Y")){
            addStudent();
        }else{
            menu();
        }
    }

    //2.查询学生
    public Student findStudent(){
        System.out.println("请输入您要查找的学生编号:");
        String id= input.next();
        if (id.isEmpty()){
            System.out.println("输入有误，请重新输入！！！");
        }else{
            System.out.println("学生信息如下：");
            Student stu = null;
            System.out.println(stu.stuID+"\t"+stu.stuName+"\t"+stu.sex+"\t"+stu.age+"\t"+stu.phone);
        }
        return null;


    }
    //3.删除学生
    public void deleteStudent() {

        try {
            System.out.println("请输入您要删除的学生编号:");
            String id = input.next();
        }catch (Exception e) {
            for (int i = 0; i < students.length; i++) {
                System.out.println("请输入您要删除的学生编号:");
                String id = input.next();
                if (students[i].stuID == id) {
                    students[i] = null;
                }
            }
        }
        System.out.println("删除成功！是否继续删除？Y/N");
        String choose = input.next();
        if (choose.equals("Y")){
        deleteStudent();
        }else{
            menu();
        }




    }

    //4.修改学生信息
    public void updateStudent(){

        System.out.println("请输入您要修改的学生编号:");
        String stuID = input.next();
        System.out.println("请输入要更新的学生姓名:");
        String stuName = input.next();
        System.out.println("请输入要更新的学生年龄:");
        int age = input.nextInt();
        System.out.println("请输入要更新的学生性别:");
        String sex = input.next();
        System.out.println("请输入要更新的手机号:");
        String phone = input.next();
        Student stu = new Student(stuID,stuName,sex,age,phone);
        for (int i=0;i<students.length;i++){
            if (students[i]==null){
                students[i] = stu;
                break;
            }
        }
        System.out.println("修改成功！是否继续修改？Y/N");
        String choose = input.next();
        if (choose.equals("Y")){
            updateStudent();
        }else{

            menu();
        }



    }
    //5.显示所有学生
    public void showAllStudent(){

        System.out.println("学生编号\t姓名\t性别\t年龄\t手机");
        //循环遍历学生信息
        for (int i=0;i< students.length;i++){
            if (students[i]==null){
                continue;//判断数组当前位置是否存在学生对象
            }
            Student stu = students[i];
            System.out.println(stu.stuID+"\t"+stu.stuName+"\t"+stu.sex+"\t"+stu.age+"\t"+stu.phone);
        }
        menu();

    }
}
