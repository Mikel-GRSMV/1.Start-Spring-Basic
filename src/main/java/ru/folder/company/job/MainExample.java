package ru.folder.company.job;

public class MainExample {
    public static void main(String[] args) throws InterruptedException {
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(()-> System.out.println("task 1"));
        taskManager.addTask(()-> System.out.println("task 2"));
        taskManager.addTask(()-> System.out.println("task 3"));

        taskManager.runTasks();
    }
}
