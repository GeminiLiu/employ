package com.jagt.employ.common.command;

/**
 * The command invoker for internal usage.
 *
 * @author gotanks
 */
public interface Executor {

    /**
     * get receiver
     * @param clazz
     * @return
     */
    <R extends Receiver> R getReceiver(Class<R> clazz);
//    Receiver getReceiver(Class<? extends Receiver> clazz);

    /**
     * Execute a command with the default
     */
    <T> T execute(Command<T> command);

}
