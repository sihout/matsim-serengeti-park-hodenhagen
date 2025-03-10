package org.matsim.analysis;

import org.matsim.core.events.EventsUtils;

public class ElaborateAnalysis {
    public static void main(String[] args) {
        var handler=new ElaborateEventHandler();
        var manager= EventsUtils.createEventsManager();
        manager.addHandler(handler);

        EventsUtils.readEvents(manager,"C:\\Users\\Simon\\IdeaProjects\\matsim-serengeti-park-hodenhagen\\scenarios\\serengeti-park-v1.0\\output\\output-serengeti-park-v1.0-run1\\serengeti-park-v1.0-run1.output_events.xml.gz");

        handler.getCounter().forEach((hour, count) -> System.out.println(hour+"Uhr: "+count));
    }
}
