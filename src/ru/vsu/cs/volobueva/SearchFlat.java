package ru.vsu.cs.volobueva;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchFlat {
    public static List<ApartmentParameters> searchFlat(List<ApartmentParameters> listOfApartments, int numberOfRooms, int totalSquare) {
        Map<String, ApartmentParameters> flat = new HashMap<>();

        for (ApartmentParameters dataBase : listOfApartments) {
            if (flat.containsKey(dataBase.getCityArea())) {
                if (dataBase.getNumberOfRooms() == numberOfRooms && dataBase.getTotalSquareOfApartment() >= totalSquare) {
                    if (dataBase.getPrice() < flat.get(dataBase.getCityArea()).getPrice()) {
                        flat.put(dataBase.getCityArea(), dataBase);
                    }
                }
            } else {
                if (dataBase.getNumberOfRooms() == numberOfRooms && dataBase.getTotalSquareOfApartment() >= totalSquare) {
                    flat.put(dataBase.getCityArea(), dataBase);
                }
            }
        }

        List<ApartmentParameters> result = new ArrayList<>();

        for (String area : flat.keySet()) {
            result.add(flat.get(area));
        }

        return result;
    }
}