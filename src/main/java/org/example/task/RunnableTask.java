package org.example.task;

public class RunnableTask implements Runnable {

    int number;

    public RunnableTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {

        System.out.println("Inside runnable task " + number);
    }
}
