package ru.folder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.folder.company.ITCompany;
import ru.folder.company.employer.Employer;
import ru.folder.company.employer.ITRole;

@Configuration
@ComponentScan("ru.folder.company")
public class CompanyConfig {

//    @Bean
//    @Primary
//    //в параметре так же автоматически подставиться директор из @Bean("DirectorOurCompany")-DI
//    public ITCompany getItCompany(Employer<ITRole> director) {
//        ITCompany company = new ITCompany("SoftEngineer", 50);
//        company.setDirector(director);
//        return company;
//    }
//
//    @Bean
//    public ITCompany getAnotherItCompany() {
//        return new ITCompany("someCompany", 200);
//    }

    @Bean("DirectorOurCompany")
    public Employer<ITRole> getDirector() {
        return new Employer<ITRole>("Oleg", 30, ITRole.DIRECTOR) {
            @Override
            public void work() {
                System.out.println(this.getName() + "is directing");
            }
        };
    }

    @Bean("CompanyName")
    public String getCompanyName() {
        return "SoftLine";
    }

    @Bean("MaxEmployerCount")
    public int getCount() {
        return 100;
    }
}
