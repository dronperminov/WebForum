package main;

import config.AppConfig;
import model.UserEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.MessagesManager;
import service.SectionsManager;
import service.TopicManager;
import service.UserManager;

public class AppMain {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserManager userManager = ctx.getBean(UserManager.class);
        TopicManager topicManager = ctx.getBean(TopicManager.class);
        SectionsManager sectionsManager = ctx.getBean(SectionsManager.class);
        MessagesManager messagesManager = ctx.getBean(MessagesManager.class);

        UserEntity user = new UserEntity();
        user.setName("Andrew");
        user.setSurname("Perminov");
        user.setLogin("login3");
        user.setIsModerator((byte) 1);
        user.setPassword("password3");
        user.setRegistrationDate(new java.sql.Timestamp(System.currentTimeMillis()));

        userManager.insertUser(user);
        System.out.println("Size of users: " + userManager.getUsers().size());

        System.out.println("User inserted");
    }
}