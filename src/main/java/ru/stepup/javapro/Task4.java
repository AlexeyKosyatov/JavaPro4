package ru.stepup.javapro;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Task 4
 *
 */

public class Task4
{
    public static void main( String[] args )
    {
        BasicConfigurator.configure();

        Properties props = new Properties();
        try {
            props.load(new FileInputStream("src/log4j.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PropertyConfigurator.configure(props);


        System.out.println( "Task4" );

        ApplicationContext context = new AnnotationConfigApplicationContext("ru.stepup.javapro");
        UserService userService = context.getBean(UserService.class);

        //Очистить
        userService.deleteAll();

        // Создавать
        User user1 = new User(1L, "user1");
        userService.create(user1);
        User user2 = new User(2L, "user2");
        userService.create(user2);
        User user3 = new User(3L, "user3");
        userService.create(user3);

        //Удалять
        userService.deleteById(1L);

        //Получать одного
        System.out.println("user id = 2:");
        var user = userService.selectById(2L);
        System.out.println(user);

        //Получать всех пользователей из базы данных
        System.out.println("Все строки:");
        var users = userService.selectAll();
        System.out.println(users);

    }
}
