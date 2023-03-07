package io.github.itzispyder.funnysentences.scheduler;

/**
 * Task scheduler
 */
public interface Schedulable {

    void runTask();

    void runRepeatingTask(int times, long millisDelay);

    void runTaskForever(long millisDelay);

    void runDelayedTask(long millisDelay);

    void cancel();

    Runnable getTask();
}
