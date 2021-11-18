package ru.folder.company.job;

import java.util.ArrayList;
import java.util.List;

public class TaskManager <T extends Job> {
    List<T> tasks = new ArrayList<>();

    public void addTask(T task){
        tasks.add(task);
    }


    //метод с бесконечным циклом, который будет запускать поданный список задач и будет выполнять их каждую 1 сек
    public void runTasks() throws InterruptedException {
        while (true) {
            //пробегаемся по всем задачам и подаем их на выполнение(здесь передали метод в метод при помощи lambda)
            tasks.forEach(task -> task.run());//можем вызвать метод run() тк имплементирует интерфейс Job
            Thread.sleep(1000);
        }
    }
}
