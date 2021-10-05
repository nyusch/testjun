package com.gridnine.testing;

public enum TypeOfFilter {
    DEPARTURE_UNTIL_NOW,                // вылет до текущего момента времени
    ARRIVIAL_BEFORE_DEPARTURE,          //имеются сегменты с датой прилёта раньше даты вылета
    HOURS_ON_EARTH_MORE_TWO             //общее время, проведённое на земле превышает два часа
}

