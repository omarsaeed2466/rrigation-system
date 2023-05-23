package com.example.automatic.irrigation.system.Service;

import com.example.automatic.irrigation.system.entity.dao.LandPlotRepository;
import com.example.automatic.irrigation.system.entity.dto.Crop;
import com.example.automatic.irrigation.system.entity.dto.LandPlot;
import com.example.automatic.irrigation.system.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LandPlotServiceImpl implements LandPlotService{


   private LandPlotRepository landPlotRepository ;
   private SensorService sensorService = new sensorServiceImpl();

   public LandPlotRepository getLandPlotDAO(){
       return landPlotRepository ;
   }
@Autowired
   public void  setLandPlotDAO(LandPlotRepository landPlotRepository){
      this.landPlotRepository = landPlotRepository ;
   }


    @Override
    public LandPlot createOrUpdateLandPlot(LandPlot landPlot) {
        return landPlotRepository.save(landPlot);
    }

    @Override
    public List<LandPlot> getAllLandPlots() {
       List<LandPlot> landPlots = landPlotRepository.findAll();
       return landPlots;
    }

    @Override
    public LandPlot getLandPlotByID(int id) {
    LandPlot landPlot = landPlotRepository.findById(id).orElseThrow((()-> new ResourceNotFoundException("Land Plot", "id", id)));
    return landPlot ;
    }
    @Override
    public void deleteLandPlot(int id) {
LandPlot landPlotRetrieved = landPlotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Land Plot", "id", id));
landPlotRepository.delete(landPlotRetrieved);
   }
    private Long predictSlotTime(LandPlot landPlotRetrieved, Crop cropRetrieved) {
        Long timePerfeddan = cropRetrieved.getTimePerFeddan();
        timePerfeddan = landPlotRetrieved.getAreaInFeddan()*timePerfeddan;
        return timePerfeddan ;
    }
    private Float predictWaterAmount(LandPlot landPlotRetrieved, Crop cropRetrieved) {
       float waterPerFeddan = cropRetrieved.getWaterPerFeddan();
       waterPerFeddan = waterPerFeddan * landPlotRetrieved.getAreaInFeddan();
       return waterPerFeddan ;
    }
    @Override
    public LandPlot irrigateLandPlot(int id) {
        LandPlot landPlotRetrieved = landPlotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Land Plot", "id", id));
        Crop crop = landPlotRetrieved.getCrop();
        float  waterPerFeddan = predictWaterAmount(landPlotRetrieved,crop);
        Long minutesPerFeddan = predictSlotTime(landPlotRetrieved,crop);
        sensorService.irrigateCallToSensor(landPlotRetrieved,waterPerFeddan);
        landPlotRetrieved.setTimeSlot(landPlotRetrieved.getTimeSlot().plusMinutes(minutesPerFeddan));
        return createOrUpdateLandPlot(landPlotRetrieved);
    }
}
