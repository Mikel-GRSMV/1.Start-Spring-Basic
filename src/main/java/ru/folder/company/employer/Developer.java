package ru.folder.company.employer;

public class Developer extends Employer<ITRole> {
    private String language;

    public Developer(String name, int age, String language) {
        super(name, age, ITRole.DEVELOPER);
        this.language = language;
    }

    @Override
    public void work() {
        System.out.println(this.getName() + " write " + this.language + " code...");
    }
}

