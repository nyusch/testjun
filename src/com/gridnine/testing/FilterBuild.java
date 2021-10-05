package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

 class FilterBuild {
    private Filter[] filters = new Filter[TypeOfFilter.values().length];

    FilterBuild() {
        reset();
    }

    private void reset() {
        filters = new Filter[TypeOfFilter.values().length];
    }

    Filter get(TypeOfFilter typeOfFilter) {
        return filters[typeOfFilter.ordinal()];
    }

    void add(final Filter... newFilters) {
        for (Filter filter : newFilters) {
            filters[filter.getType().ordinal()] = filter;
        }
    }

    public void replace(final Filter... newFilters) {
        reset();
        add(newFilters);
    }

    void remove(TypeOfFilter typeOfFilter) {
        filters[typeOfFilter.ordinal()] = null;
    }

    List<Flight> filter(List<Flight> allFlights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : allFlights) {
            boolean isFlightPas = true;
            for (Filter filter : filters) {
                if (filter != null)
                    if (!filter.isPassing(flight)) {
                        isFlightPas = false;
                        break;
                    }
            }
            if (isFlightPas) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

}
