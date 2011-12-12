package org.agilewiki.jactor.events.dualEchoTiming;

import org.agilewiki.jactor.concurrent.ThreadManager;
import org.agilewiki.jactor.events.EventDestination;
import org.agilewiki.jactor.events.JAEventActor;
import org.agilewiki.jactor.events.Sender;

public final class Driver extends JAEventActor<Object> {

    private Sender sender1;
    private Sender sender2;

    public Driver(ThreadManager threadManager, int c) {
        super(threadManager);
        sender1 = new Sender(threadManager, c);
        sender2 = new Sender(threadManager, c);
    }

    @Override
    protected void processEvent(Object event) {
        EventDestination<Object> destination = (EventDestination<Object>) event;
        send(destination, this);
    }
}
