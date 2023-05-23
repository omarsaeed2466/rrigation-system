package com.example.automatic.irrigation.system.entity.dao;

public interface SensorClient {
    boolean irrigate(int xCoordinate, int yCoordinate, float areaToIrrigate, float amountOfWater);
}
