package com.khg.mockito;

public class SomeBusinessImpl {
    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    int findTheGreatestNumber() {
        int[] data = dataService.retrieveAllData();
        int greatest = Integer.MIN_VALUE;
        for (int number :
                data) {
            if (number > greatest) greatest = number;
        }
        return greatest;
    }
}
