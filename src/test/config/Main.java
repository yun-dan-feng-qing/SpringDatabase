package test.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String... args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DataConfig.class);
        JdbcStudentRepository repository =
                context.getBean(JdbcStudentRepository.class);
        Student stu1 = null;
        stu1 = repository.findOne("1612190201");
        System.out.println(stu1);

        Student stu2 = new Student("1612190201", "张三",
            "男", 30, "财会学院", "5201314");
        repository.addStudent(stu2);
        
        System.out.println("Hello world");

        System.out.println("拉取代码");
    }
}
