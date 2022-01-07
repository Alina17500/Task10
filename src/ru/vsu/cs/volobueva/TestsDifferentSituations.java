package ru.vsu.cs.volobueva;

import org.junit.Assert;
import org.junit.Test;
import ru.vsu.cs.util.ArrayUtils;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class TestsDifferentSituations {
    @Test
    public void testStandardSituation() throws FileNotFoundException {
        List<String[]> originalList = ArrayUtils.readSplitListFromFile("TestCase/input01TestStandardSituation.txt");
        List<String[]> listForTest = ArrayUtils.writeMatrixToList(ApartmentParameters.makeListToArr(SearchFlat.searchFlat(ArrayUtils.makeListToApartmentParameters(originalList), 3, 50)));
        List<String[]> trueList = ArrayUtils.readSplitListFromFile("TestResult/outputResult01.txt");

        String resultListForTest;
        if (compareTransformListAndTrueList(listForTest, trueList)) {
            resultListForTest = "Железнодорожный, 3, 58, 8, 3150000\n" +
                    "Ленинский, 3, 75, 15, 3700000\n" +
                    "Центральный, 3, 70, 18, 4000000";
        } else resultListForTest = null;

        String resultList = "Железнодорожный, 3, 58, 8, 3150000\n" +
                "Ленинский, 3, 75, 15, 3700000\n" +
                "Центральный, 3, 70, 18, 4000000";

        Assert.assertEquals(resultList, resultListForTest);
    }

    @Test
    public void testTwoSuitableApartmentsWithSamePrice() throws FileNotFoundException {
        List<String[]> originalList = ArrayUtils.readSplitListFromFile("TestCase/input02TestTwoSuitableApartmentsWithSamePrice.txt");
        List<String[]> listForTest = ArrayUtils.writeMatrixToList(ApartmentParameters.makeListToArr(SearchFlat.searchFlat(ArrayUtils.makeListToApartmentParameters(originalList), 4, 80)));
        List<String[]> trueList = ArrayUtils.readSplitListFromFile("TestResult/outputResult02.txt");

        String resultListForTest;
        if (compareTransformListAndTrueList(listForTest, trueList)) {
            resultListForTest = "Левобережный, 4, 85, 18, 3600000";
        } else resultListForTest = null;

        String resultList = "Левобережный, 4, 85, 18, 3600000";

        Assert.assertEquals(resultList, resultListForTest);
    }

    @Test
    public void testOnlyOneDistrict() throws FileNotFoundException {
        List<String[]> originalList = ArrayUtils.readSplitListFromFile("TestCase/input03TestOnlyOneDistrict.txt");
        List<String[]> listForTest = ArrayUtils.writeMatrixToList(ApartmentParameters.makeListToArr(SearchFlat.searchFlat(ArrayUtils.makeListToApartmentParameters(originalList), 2, 30)));
        List<String[]> trueList = ArrayUtils.readSplitListFromFile("TestResult/outputResult03.txt");

        String resultListForTest;
        if (compareTransformListAndTrueList(listForTest, trueList)) {
            resultListForTest = "Советский, 2, 32, 6, 2100000";
        } else resultListForTest = null;

        String resultList = "Советский, 2, 32, 6, 2100000";

        Assert.assertEquals(resultList, resultListForTest);
    }

    @Test
    public void testOnlyOneApartmentInEachDistrict() throws FileNotFoundException {
        List<String[]> originalList = ArrayUtils.readSplitListFromFile("TestCase/input04TestOnlyOneApartmentInEachDistrict.txt");
        List<String[]> listForTest = ArrayUtils.writeMatrixToList(ApartmentParameters.makeListToArr(SearchFlat.searchFlat(ArrayUtils.makeListToApartmentParameters(originalList), 2, 50)));
        List<String[]> trueList = ArrayUtils.readSplitListFromFile("TestResult/outputResult04.txt");

        String resultListForTest;
        if (compareTransformListAndTrueList(listForTest, trueList)) {
            resultListForTest = "Коминтерновский, 2, 50, 8, 2000000\n" +
                    "Левобережный, 2, 57, 10, 2700000\n" +
                    "Железнодорожный, 2, 55, 8, 2200000\n" +
                    "Ленинский, 2, 58, 9, 2190000";
        } else resultListForTest = null;

        String resultList = "Коминтерновский, 2, 50, 8, 2000000\n" +
                "Левобережный, 2, 57, 10, 2700000\n" +
                "Железнодорожный, 2, 55, 8, 2200000\n" +
                "Ленинский, 2, 58, 9, 2190000";

        Assert.assertEquals(resultList, resultListForTest);
    }

    @Test
    public void testAllApartmentsHaveSamePrice() throws FileNotFoundException {
        List<String[]> originalList = ArrayUtils.readSplitListFromFile("TestCase/input05TestAllApartmentsHaveSamePrice.txt");
        List<String[]> listForTest = ArrayUtils.writeMatrixToList(ApartmentParameters.makeListToArr(SearchFlat.searchFlat(ArrayUtils.makeListToApartmentParameters(originalList), 2, 55)));
        List<String[]> trueList = ArrayUtils.readSplitListFromFile("TestResult/outputResult05.txt");

        String resultListForTest;
        if (compareTransformListAndTrueList(listForTest, trueList)) {
            resultListForTest = "Коминтерновский, 2, 62, 15, 3100000\n" +
                    "Левобережный, 2, 58, 17, 3100000\n" +
                    "Железнодорожный, 2, 56, 13, 3100000";
        } else resultListForTest = null;

        String resultList = "Коминтерновский, 2, 62, 15, 3100000\n" +
                "Левобережный, 2, 58, 17, 3100000\n" +
                "Железнодорожный, 2, 56, 13, 3100000";

        Assert.assertEquals(resultList, resultListForTest);
    }

    private static boolean compareTransformListAndTrueList(List<String[]> listForTest, List<String[]> trueList) {
        boolean value = false;

        for (int i = 0; i < listForTest.size(); i++) {
            value = Arrays.equals(listForTest.get(i), trueList.get(i));
        }

        return value;
    }
}
