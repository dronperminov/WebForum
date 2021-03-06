package main;

import config.AppConfig;
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

        System.out.println("Size of topics: " + topicManager.getTopics().size());
    }
}