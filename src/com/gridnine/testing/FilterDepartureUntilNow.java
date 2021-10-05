package com.gridnine.testing;

import java.time.LocalDateTime;

public class FilterDepartureUntilNow implements Filter {

    @Override
    public boolean isPassing(Flight flight) {
        LocalDateTime date =LocalDateTime.now();
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isAfter(date))
                return false;
        }
        return true;
    }

    @Override
    public TypeOfFilter getType() {
        return TypeOfFilter.DEPARTURE_UNTIL_NOW;
    }
}
