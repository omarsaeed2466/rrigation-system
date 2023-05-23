package com.example.automatic.irrigation.system.Service;

import com.example.automatic.irrigation.system.entity.dto.LandPlot;

import java.util.List;

public interface LandPlotService {
    LandPlot createOrUpdateLandPlot(LandPlot landPlot);
    List<LandPlot> getAllLandPlots();
    LandPlot getLandPlotByID(int id);
     public LandPlot  irrigateLandPlot(int id);
    void deleteLandPlot(int id);

}
