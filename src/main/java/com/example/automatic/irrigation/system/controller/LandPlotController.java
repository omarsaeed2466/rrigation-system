package com.example.automatic.irrigation.system.controller;

import com.example.automatic.irrigation.system.Service.LandPlotService;

import com.example.automatic.irrigation.system.entity.dto.LandPlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/landPlot")
public class LandPlotController {

    private LandPlotService landPlotService ;



      @Autowired
       public void setLandPlotService(LandPlotService landPlotService){
        this.landPlotService = landPlotService ;

    }

    @PostMapping
    public ResponseEntity<LandPlot>  createOrUpdateLandPlot(@RequestBody LandPlot landPlot) {
return new ResponseEntity<>(landPlotService.createOrUpdateLandPlot(landPlot), HttpStatus.CREATED);
    }


    @GetMapping
    public List<LandPlot> getAllLandPlots() {
    return landPlotService.getAllLandPlots();
    }
@PutMapping
public ResponseEntity<LandPlot> updateLandPlot(@RequestBody LandPlot landPlot) {
    LandPlot updatedLandPlot = landPlotService.createOrUpdateLandPlot(landPlot);
    return new ResponseEntity<>(updatedLandPlot, HttpStatus.OK);
}

@DeleteMapping
public ResponseEntity<String> deleteLandPlot(@PathVariable(name = "id") int id) {
    landPlotService.deleteLandPlot(id);
    return new ResponseEntity<>("Land Plot deleted Successfully", HttpStatus.OK);
}
    //irrigate and update the land-plot's time slot

    public ResponseEntity<LandPlot>irrigateLandPLot(@PathVariable(name = "id") int id){
    LandPlot irrigatedLandPlot = landPlotService.irrigateLandPlot(id);
        return new ResponseEntity<>(irrigatedLandPlot,HttpStatus.OK);
    }

}
