package net.orphidian11.projects.cars.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.orphidian11.projects.cars.product.domain.Parts;
import net.orphidian11.projects.cars.product.domain.Parts.PartTypes;

@RestController
@RequestMapping("/parts")
public class PartsController {

    private List<Parts> parts = new ArrayList<Parts>();

    // initialize 
    {
        parts.add(new Parts(1, "Generic Engine", "Generic Honda engine", PartTypes.ENGINE));
        parts.add(new Parts(2, "Civic Chassis", "Civic Unibody Chassis", PartTypes.CHASSIS));
        parts.add(new Parts(3, "City Chassis", "City Unibody Chassis", PartTypes.CHASSIS));
        parts.add(new Parts(4, "Generic Wheels", "16\" Wheels", PartTypes.WHEEL));
        parts.add(new Parts(5, "Generic Front Seats", "Front row seats", PartTypes.SEAT));
        parts.add(new Parts(6, "Generic Back Seats", "Back row seats", PartTypes.SEAT));
        parts.add(new Parts(7, "Generic Fuel Tank", "Fuel tank", PartTypes.TANK));
    }

    /**
     * List all parts
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Parts>> all(){
        return new ResponseEntity<List<Parts>>(parts, HttpStatus.OK);
    }

    /**
     * Get an existing part
     * @return
     */
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<Parts> find(@PathVariable Integer id){
        Parts part = parts.stream()
            .filter(currPart -> currPart.getId().equals(id))
            .findAny()
            .orElse(null);

        return new ResponseEntity<Parts>(part, HttpStatus.OK);
    }
}