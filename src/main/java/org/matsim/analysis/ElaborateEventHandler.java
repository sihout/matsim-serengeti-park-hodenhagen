package org.matsim.analysis;

import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;

import java.util.HashMap;
import java.util.Map;

public class ElaborateEventHandler implements LinkLeaveEventHandler {

    private final String intLinkId ="2344590910000f";

    public Map<Integer, Integer> getCounter() {
        return counter;
    }

    private final Map<Integer, Integer> counter = new HashMap<>();

    @Override
    public void handleEvent(LinkLeaveEvent linkLeaveEvent) {
        int hour= (int) (linkLeaveEvent.getTime()/3600);

        if (linkLeaveEvent.getLinkId().toString().equals(intLinkId)){
            int cnt=1;
            if (counter.containsKey(hour)){
                cnt  =counter.get(hour)+1;
            }
            counter.put(hour, cnt);
        }
    }
}
