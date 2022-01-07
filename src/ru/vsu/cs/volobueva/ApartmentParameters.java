package ru.vsu.cs.volobueva;

import java.util.List;

public class ApartmentParameters {
    private String cityArea;
    private int numberOfRooms;
    private int totalSquareOfApartment;
    private int kitchenSquare;
    private int price;

    public ApartmentParameters(String cityArea, int numberOfRooms, int totalSquareOfApartment, int kitchenSquare, int price) {
        this.cityArea = cityArea;
        this.numberOfRooms = numberOfRooms;
        this.totalSquareOfApartment = totalSquareOfApartment;
        this.kitchenSquare = kitchenSquare;
        this.price = price;
    }

    public String getCityArea() {
        return cityArea;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getTotalSquareOfApartment() {
        return totalSquareOfApartment;
    }

    public int getPrice() {
        return price;
    }

    public ApartmentParameters() {

    }

    public static String[][] makeListToArr(List<ApartmentParameters> list) {
        String [][] array = new String[list.size()][5];

        for (int row = 0; row < array.length; row++) {
            ApartmentParameters apartmentParameters = list.get(row);

            array[row][0] = apartmentParameters.cityArea;
            array[row][1] = String.valueOf(apartmentParameters.numberOfRooms);
            array[row][2] = String.valueOf(apartmentParameters.totalSquareOfApartment);
            array[row][3] = String.valueOf(apartmentParameters.kitchenSquare);
            array[row][4] = String.valueOf(apartmentParameters.price);
        }

        return array;
    }
}