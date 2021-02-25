package com.ank.util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

    private String name = "";

    public DefaultSubscriber(String name) {
        this.name = name + " - ";
    }

    public DefaultSubscriber() {
    }

    /**
     * Invoked after calling {@link Publisher#subscribe(Subscriber)}.
     * <p>
     * No data will start flowing until {@link Subscription#request(long)} is invoked.
     * <p>
     * It is the responsibility of this {@link Subscriber} instance to call {@link Subscription#request(long)}
     * whenever more data is wanted.
     * <p>
     * The {@link Publisher} will send notifications only in response to {@link Subscription#request(long)}.
     *
     * @param s {@link Subscription} that allows requesting data via {@link Subscription#request(long)}
     */
    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    /**
     * Data notification sent by the {@link Publisher} in response to requests to {@link Subscription#request(long)}.
     *
     * @param o the element signaled
     */
    @Override
    public void onNext(Object o) {
        System.out.println(name + "Received : " + o);
    }

    /**
     * Failed terminal state.
     * <p>
     * No further events will be sent even if {@link Subscription#request(long)} is invoked again.
     *
     * @param t the throwable signaled
     */
    @Override
    public void onError(Throwable t) {
        System.out.println(name + "ERROR : " + t.getMessage());
    }

    /**
     * Successful terminal state.
     * <p>
     * No further events will be sent even if {@link Subscription#request(long)} is invoked again.
     */
    @Override
    public void onComplete() {
        System.out.println(name + "Completed");
    }
}
