package com.jagt.employ.common.command;

public interface Command<T> {

    T execute(Executor executor);

}
