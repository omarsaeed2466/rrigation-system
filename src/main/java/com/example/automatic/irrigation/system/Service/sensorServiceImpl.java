package com.example.automatic.irrigation.system.Service;

import com.example.automatic.irrigation.system.entity.dao.CropRepository;
import com.example.automatic.irrigation.system.entity.dao.LandPlotRepository;
import com.example.automatic.irrigation.system.entity.dao.SensorClient;
import com.example.automatic.irrigation.system.entity.dao.SensorClientImp;
import com.example.automatic.irrigation.system.entity.dto.LandPlot;
import com.example.automatic.irrigation.system.exception.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sensorServiceImpl implements SensorService{
private static int counter = 0 ;
LandPlotRepository landPlotRepository ;
CropRepository cropRepository ;
SensorClient sensorClient = new SensorClientImp();
@Autowired
public void  setCropDAO(CropRepository cropRepository) {
    this.cropRepository = cropRepository ;
}
@Autowired
public void setLandPlotDAO(LandPlotRepository landPlotRepository){
    this.landPlotRepository=landPlotRepository;
}
private void irrigate(LandPlot landPlotRetrieved , float waterPerFeddan){
sensorClient.irrigate(landPlotRetrieved.getXCoordinate(),landPlotRetrieved.getYCoordinate(),landPlotRetrieved.getAreaInFeddan(),waterPerFeddan);
counter=0;
}
    @Override
    public void irrigateCallToSensor(LandPlot landPlotRetrieved, float waterPerFeddan) {
        try {
            irrigate(landPlotRetrieved, waterPerFeddan);
            System.out.println("Irrigation Performed");


        } catch (SensorNotFoundException e) {

            if (counter < 3) {
                System.out.println("Irrigation call failed, attempt number: " + counter + ". Retry!");
                counter++;
                irrigateCallToSensor(landPlotRetrieved, waterPerFeddan);

            } else {
                System.out.println("Number of attempts exceeded limit, Sensor is out of service!!");
                throw e;
            }
        }

    }
}
