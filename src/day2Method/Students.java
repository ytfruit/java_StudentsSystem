package day2Method;
/*学生类:学生信息管理系统*/

public class Students {
    private  String name;
    private String age;
    private String number;
    private String score;
    /*set()设置成员变量
    get()获取成员变量*/
    public Students(){}
    /*构造无参方法*/
    public Students(String name,String age){
        this.name = name;
        this.age = age;
        this.number =number;
        this.score =score;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getAge() {
        return age;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getNumber(){
        return number;
    }

    public void setScore(String score){
        this.score = score;
    }
    public String getScore(){
        return score;
    }
}
