package org.agilewiki.jactor.advanced.many;

import org.agilewiki.jactor.RP;
import org.agilewiki.jactor.lpc.JLPCActor;

import static junit.framework.Assert.assertEquals;

public class ReleaseDriver extends JLPCActor {
    public Doer doer;

    public void startRelease(final RP rp)
            throws Exception {
        System.out.println("release driver sending release");
        Release.req.send(this, doer, new RP<Object>() {
            @Override
            public void processResponse(Object response) throws Exception {
                assertEquals(
                        StartRelease.req,
                        getMailbox().getCurrentRequest().getUnwrappedRequest());
                System.out.println("release driver sending response");
                Thread.sleep(10);
                rp.processResponse(null);
                assertEquals(
                        StartRelease.req,
                        getMailbox().getCurrentRequest().getUnwrappedRequest());
            }
        });
    }
}
