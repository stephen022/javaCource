package org.javacourse.beanconfig;


import org.javacourse.beanconfig.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zyb
 */
public class XmlConfig {


    public static void main(String[] args) throws Exception {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println("student name: " + student.getName());

    }
}
