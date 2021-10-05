package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class FilterHoursOnEarthMoreTwo implements Filter {
    private final long onEarthTime;

    public FilterHoursOnEarthMoreTwo(long onEarthTime) {
        this.onEarthTime = onEarthTime;
    }

    @Override
    public boolean isPassing(Flight flight)
    {
        long onEarthTime=0;
        List<Segment> segments = flight.getSegments();
        int countSegments = segments.size();
        if (countSegments >1 )
        {
            for (int i = 1; i < countSegments; i++)
            {
                long onEarthSeg = segments.get(i-1).getArrivalDate().until(segments.get(i).getDepartureDate(), ChronoUnit.HOURS);
                onEarthTime+=onEarthSeg;
            }
        }
        return onEarthTime<=this.onEarthTime;
    }

    @Override
    public TypeOfFilter getType() {
        return TypeOfFilter.HOURS_ON_EARTH_MORE_TWO;
    }
}
