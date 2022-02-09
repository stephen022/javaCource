package org.javacourse.beanconfig;


import org.javacourse.beanconfig.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author zyb
 */
@Configuration
public class AnnotationConfig {

    @Bean(name="student")
    @Scope("prototype")
    public Student student(){
        return new Student("张三", 30);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        Student student1 = (Student) applicationContext.getBean("student");
        System.out.println("name:"+student1.getName());
    }

}
