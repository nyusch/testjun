package com.gridnine.testing;

import java.util.List;

class Main {
    public static void main(String[] args) {

        List<Flight> list = FlightBuilder.createFlights();
        System.out.println("\nВсе полёты:");
        for (Flight iterator : list) {
            System.out.println(iterator);
        }
        System.out.println("\n 1. Исключены полёты по фильтру: вылет до текущего момента времени");
        Filter filterDepUntilNow = new FilterDepartureUntilNow();
        FilterBuild filterBuild = new FilterBuild();
        filterBuild.replace(filterDepUntilNow);
        List<Flight> flights = filterBuild.filter(list);
        for (Flight iterator : flights) {
            System.out.println(iterator);
        }
        System.out.println("\n 2. Исключены полёты по фильтру: имеются сегменты с датой прилёта раньше даты вылета");
        Filter filterArrBeforeDep = new FilterArrivialBeforeDeparture();
        filterBuild = new FilterBuild();
        filterBuild.replace(filterArrBeforeDep);
        flights = filterBuild.filter(list);
        for (Flight iterator : flights) {
            System.out.println(iterator);
        }

        System.out.println("\n 3. Исключены полёты по фильтру: общее время, проведённое на земле превышает два часа ");
        Filter filterTwoHours = new FilterHoursOnEarthMoreTwo(2);
        filterBuild = new FilterBuild();
        filterBuild.replace(filterTwoHours);
        flights = filterBuild.filter(list);
        for (Flight iterator : flights) {
            System.out.println(iterator);
        }
    }
}

interface Filter {
    boolean isPassing(Flight flight);

    TypeOfFilter getType();
}
