package day2Method;
//学生测试类

import java.util.ArrayList;
import java.util.Scanner;

public class StudentsDemo {
    public static void main(String[] args) {
        /*创建一个集合存储学生数据*/
        ArrayList<Students> array = new ArrayList<>();
        int flag = 0;
        String name = "yt";
        String password = "123456";
        Scanner sc = new Scanner(System.in);
        for (int x = 0; x < 3; x++) {
            System.out.println("请输入用户名：");
            String s1 = sc.nextLine();
            System.out.println("请输入密码：");
            String s2 = sc.nextLine();
            if (s1.equals(name) && s2.equals(password)) {
                System.out.println("登录成功！");
                break;
            } else {
                if ((2 - x) == 0) {
                    System.out.println("登录失败，用户已锁定！");
                    System.exit(0);//退出虚拟机
                } else {
                    System.out.println("你输入的用户名或密码有误！请重新输入！你还有" + (2 - x) + "次机会！");
                }
            }
        }
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1.添加学生");
            System.out.println("2.删除学生");
            System.out.println("3.修改学生");
            System.out.println("4.查看所有学生");
            System.out.println("5.退出");
            System.out.println("请输入你要选择的序号：");
            String line = sc.nextLine();
            switch (line) {
                case "1":
                    AddMessage(array);
                    break;
                case "2":
                    DeleteMessage(array);
                    break;
                case "3":
                    SetMessage(array);
                    break;
                case "4":
                    WatchMessage(array);
                    break;
                case "5":
                    System.out.println("已退出！");
                    System.exit(0);//退出虚拟机
            }
        }
    }

    /*添加学生的方法*/
    public static void AddMessage(ArrayList<Students> array) {
        Scanner sc = new Scanner(System.in);
        String number;
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄：");
        String age = sc.nextLine();
        while(true) {
            System.out.println("请输入学生学号：");
            number = sc.nextLine();
            boolean flag = IsUsed(array, number);
            if (flag) {
                System.out.println("学号已存在系统，请检查是否输入错误，重新输入！");
            } else {
                break;
            }
        }
        System.out.println("请输入学生绩点：");
        String score = sc.nextLine();
        /*将学生对象添加到集合中*/
        Students sr = new Students();
        sr.setName(name);
        sr.setAge(age);
        sr.setNumber(number);
        sr.setScore(score);
        array.add(sr);
        System.out.println("添加学生成功！");
    }
    /*判断学号是否重复*/
    public static boolean IsUsed(ArrayList<Students> array,String number){
        boolean flag = false;
        for(int x=0;x<array.size();x++){
            Students s = array.get(x);
            if(s.getNumber().equals(number)){
                flag = true;
                break;
            }
        }
        return flag;
    }
    /*查看学生的方法*/
    public static void WatchMessage(ArrayList<Students> array) {
        if (array.size() == 0) {
            System.out.println("系统中无信息，请返回后选择1添加信息！");
            return;
        }
        System.out.println("姓名\t年龄\t学号\t\t\t绩点");
        for (int x = 0; x < array.size(); x++) {
            Students sr = array.get(x);
            System.out.println(sr.getName() + "\t" + sr.getAge() + "\t" + sr.getNumber() + "\t" + sr.getScore());
        }
    }

    /*删除学生的方法*/
    public static void DeleteMessage(ArrayList<Students> array) {
        int idex = -1;
        System.out.println("请输入你要删除的学生学号：");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        for (int x = 0; x < array.size(); x++) {
            Students sr = array.get(x);
            if (sr.getNumber().equals(number)) {
                idex = x;
                break;
            }
        }
        if (idex == -1) {
            System.out.println("该学生信息不存在系统中！请重新输入！");
        } else {
            array.remove(idex);
            System.out.println("删除成功！");
        }
    }

    /*修改学生的方法*/
    public static void SetMessage(ArrayList<Students> array) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要修改信息的学生学号：");
            String number = sc.nextLine();
            for (int x = 0; x < array.size(); x++) {
                if (array.get(x).getNumber().equals(number)) {
                    System.out.println("请输入你们要修改的学生信息序号：");
                    Students s = array.get(x);
                    System.out.println("1.修改姓名\t2.修改年龄\t3.修改学号\t4.修改绩点\t5.修改所有\t");
                    int count = sc.nextInt();
                    if (count == 1) {
                        System.out.println("请输入修改后的学生姓名：");
                        String newname = sc.next();
                        s.setName(newname);
                        System.out.println("修改成功！");
                        return;
                    } else if (count == 2) {
                        System.out.println("请输入修改后的学生年龄：");
                        String age = sc.next();
                        s.setAge(age);
                        System.out.println("修改成功！");
                        return;
                    } else if (count == 3) {
                        System.out.println("请输入修改后的学生学号：");
                        String afternumber = sc.next();
                        s.setNumber(afternumber);
                        System.out.println("修改成功！");
                        return;
                    } else if (count == 4) {
                        System.out.println("请输入修改后的学生绩点：");
                        String score = sc.next();
                        s.setScore(score);
                        System.out.println("修改成功！");
                        return;
                    } else if (count == 5) {
                        System.out.println("请输入修改后的学生姓名：");
                        String aftername = sc.next();
                        s.setName(aftername);
                        System.out.println("请输入修改后的学生年龄：");
                        String newage = sc.next();
                        s.setAge(newage);
                        System.out.println("请输入修改后的学生学号：");
                        String newnumber = sc.next();
                        s.setNumber(newnumber);
                        System.out.println("请输入修改后的学生绩点：");
                        String newscore = sc.next();
                        s.setScore(newscore);
                        System.out.println("修改成功！");
                        return;
                    }
                }
            }
            System.out.println("该学号不在系统中，请重新输入学号！");
        }
    }
}
