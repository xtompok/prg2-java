/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cv08;

import com.eclipsesource.json.JsonObject;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jethro
 */
public class Data {
    String lastUpdate;
    int updateInterval;
    List<Vehicle> vehicles;
    
    public Data(JsonObject d){
        this.lastUpdate = d.getString("LastUpdate", "");
        this.updateInterval = d.getInt("UpdateInterval", -1);
        
        JsonObject vehicles;
        vehicles  = d.get("Data").asObject();
        this.vehicles = new LinkedList<>();
        for (JsonObject.Member v : vehicles){
            int id;
            id = Integer.parseInt(v.getName());
            this.vehicles.add(new Vehicle(id, v.getValue().asObject()));
        }
        
    }
    
    @Override
    public String toString(){
        return String.format("LastUpdate: %s, vehicles: %d", lastUpdate,vehicles.size());
    }
}

class Vehicle {
    double lat;
    double lon;
    int line;
    String heading;
    int delay;
    int id;
    
    public Vehicle(int id,JsonObject v){
        this.id = id;
        this.lat = v.getDouble("Lat",-1);
        this.lon = v.get("Lng").asDouble();
        this.delay = v.get("Delay").asInt();
        this.line = v.get("Line").asInt();
        this.heading = v.getString("EndStopX","");
    }
}

class Bus extends Vehicle {
    public Bus(int id, JsonObject v){
        super(id,v);
    }
}
class Tram extends Vehicle {
    public Tram(int id, JsonObject v){
        super(id,v);
    }
}
class Trolley extends Vehicle {
    public Trolley(int id, JsonObject v){
        super(id,v);
    }
}