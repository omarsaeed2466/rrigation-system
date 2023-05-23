package com.example.automatic.irrigation.system.entity.dao;

import com.example.automatic.irrigation.system.Enum.Status;

public class SensorClientImp implements SensorClient{
    @Override
    public boolean irrigate(int xCoordinate, int yCoordinate, float areaToIrrigate, float amountOfWater) {
        return getSensorStatus()==Status.AVAILABLE;
    }
    private static int generateRandomNumber(){
        int minimum = 0 ;
        int maximum = 10 ;
        return (int) Math.floor(Math.random()*(maximum -minimum + 1)+minimum);
    }
    private Status getSensorStatus(){
int random = generateRandomNumber();
if (random<5){
    return Status.NOT_AVAILABLE;
}else {
    return Status.AVAILABLE ;
}
    }
}
