package org.matsim.analysis;

import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;

import java.util.Map;

public class ElaborateEventHandler implements LinkLeaveEventHandler {

    private Map<>;

    //unfertig

    @Override
    public void handleEvent(LinkLeaveEvent linkLeaveEvent) {
        int hour= (int) (linkLeaveEvent.getTime()/3600);
    }
}
