package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.population.Person;
import si.uom.quantity.MagneticPermeability;

import java.util.HashMap;
import java.util.Map;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {

    private Map<Id<Person>, Double> personToDepTime = new HashMap<>();

    @Override
    public void handleEvent(PersonDepartureEvent personDepartureEvent) {
        double depTime = personDepartureEvent.getTime();
        var personId=personDepartureEvent.getPersonId();
        personToDepTime.put(personId, depTime);
    }

    @Override
    public void handleEvent(PersonArrivalEvent personArrivalEvent) {
        var arrTime = personArrivalEvent.getTime();
        var depTime=personToDepTime.get(personArrivalEvent.getPersonId());
        var travelTime = arrTime - depTime;

        System.out.println("Person "+personArrivalEvent.getPersonId()+" travelled "+ travelTime+" s");
    }


}
