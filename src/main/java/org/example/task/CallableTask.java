package org.example.task;

import org.example.exception.InvalidParamaterException;

import java.util.concurrent.Callable;

public class CallableTask implements Callable {

    int number;

    public CallableTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {

        if(number < 0)
            throw new InvalidParamaterException("Number must be positive");

        Thread.sleep(number);

        return number;
    }
}
