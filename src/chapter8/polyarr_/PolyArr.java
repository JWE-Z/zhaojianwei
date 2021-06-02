package chapter8.polyarr_;

public class PolyArr {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 20);
        persons[1] = new Student("mary", 18, 100);  // 向上转型
        persons[2] = new Student("smith", 19, 30.1);
        persons[3] = new Teacher("scott", 30, 20000);
        persons[4] = new Teacher("king", 50, 25000);

        for (int i = 0; i < persons.length; i++) {
            // persons[i] 编译类型是Person, 运行类型是具体的元素
            // 动态绑定机制
            System.out.println(persons[i].say());
            if(persons[i] instanceof Student){
                ((Student) persons[i]).study(); // 向下转型
            } else if(persons[i] instanceof Teacher){
                ((Teacher)persons[i]).teach();
            }
        }

    }
}
