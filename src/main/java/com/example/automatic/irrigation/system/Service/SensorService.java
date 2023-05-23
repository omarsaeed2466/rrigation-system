package com.example.automatic.irrigation.system.Service;

import com.example.automatic.irrigation.system.entity.dto.LandPlot;

public interface SensorService {
    public void irrigateCallToSensor(LandPlot landPlotRetrieved, float waterPerFeddan);
}
