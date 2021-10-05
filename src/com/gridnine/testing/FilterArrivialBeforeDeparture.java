package com.gridnine.testing;

public class FilterArrivialBeforeDeparture implements Filter {

    @Override
    public boolean isPassing(Flight flight)
    {
        for (Segment segment : flight.getSegments())
        {
            if (segment.getArrivalDate().isBefore(segment.getDepartureDate()))
                return false;
        }
        return true;
    }

    @Override
    public TypeOfFilter getType() {
        return TypeOfFilter.ARRIVIAL_BEFORE_DEPARTURE;
    }
}
