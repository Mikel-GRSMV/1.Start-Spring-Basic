package ru.folder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.folder.company.ITCompany;
import ru.folder.config.CompanyConfig;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CompanyConfig.class);

        //ITCompany company = context.getBean("CompanyComponent", ITCompany.class);
        ITCompany company = context.getBean(ITCompany.class);

        System.out.println(company.getName());
        System.out.println(company.getDirector());

    }
}
