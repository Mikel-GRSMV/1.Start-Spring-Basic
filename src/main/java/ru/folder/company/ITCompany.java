package ru.folder.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.folder.company.employer.Employer;
import ru.folder.company.employer.ITRole;
import ru.folder.company.employer.Worker;

import javax.annotation.Resource;

@Component("CompanyComponent")
//здесь я утверждаю, что менеджер сущностей конкретно будет, менеджер сущностьей объекта - Worker.
//явно говорю, что ITCompany это по сути менеджер реализует логику EntityManager над объектами интерфейса Worker.
public class ITCompany extends EntityManager<Employer> {
   // @Value("NameOurCompany")
    private String name;

    @Autowired
    private Employer<ITRole> director;

//    public ITCompany() {
//        super(100, Employer)
//    }

    public ITCompany(@Qualifier("CompanyName") String companyName,
                     @Qualifier("MaxEmployerCount") int maxEmployerCount) {
        super(maxEmployerCount, Employer.class);
        this.name = companyName;
    }

    public String getName() {
        return name;
    }

    public Employer<ITRole> getDirector() {
        return director;
    }

    public void setDirector(Employer<ITRole> director) {
        this.director = director;
    }

    //ITCompany начинает работать
    public void startWork() {
        for (int i = 0; i < this.getSize(); i++) { //прохожу по всему списку ITCompany
            Employer[] employers = this.getEntities(); //получаю массив всех Employer
            Employer employer = employers[i]; //получаю конкретного работника
            employer.work(); //вызываю у конкретного работника метод work()
            System.out.println(employer.getName() + " is " + employer.getRole());
        }




    }
}
