package Classes;

import Views.View;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Laundry {
    private ArrayList<WashingMachine> washing_machines;

    /**
     * @return array of washing_machines
     */
    public ArrayList<WashingMachine> getWashing_machines() {
        return washing_machines;
    }

    /**
     * Setting array of washing_machines
     *
     * @param value - array of washing_machines
     */
    public void setWashing_machines(ArrayList<WashingMachine> value) {
        washing_machines = new ArrayList<WashingMachine>(value);
    }

    /**
     * Adding another washing_machine
     *
     * @param machine - new machine for Laundry
     */
    public void AddMachine(WashingMachine machine) {
        washing_machines.add(machine);
    }

    /**
     * Deleting machine
     * @param i - index of washing machine
     */
    public void DeleteMachine(int i){
        washing_machines.remove(i);
    }

    /**
     * default constructor
     */
    public Laundry() {
        washing_machines = new ArrayList<WashingMachine>();
    }

    /**
     * override method toSting()
     *
     * @return string value of object
     */
    public String toString() {
        StringBuilder text = new StringBuilder(String.format("В прачечной находятся %d стиральных машинок:\n", washing_machines.size()));
        for (WashingMachine item :
                washing_machines) {
            text.append(item.toString()).append("\n");
        }
        return text.toString();
    }

    /**
     * Display laundry to file
     * @return string expression of laundry
     */
    public String ToFile(){
        StringBuilder text = new StringBuilder(String.valueOf(washing_machines.size()) + '\n');
        for (WashingMachine machine:
             washing_machines) {
            text.append(machine.getPowder()).append('\n');
            text.append(machine.getFabricSoftener()).append('\n');
            text.append(String.valueOf(machine.getColor())).append('\n');
            text.append(String.valueOf(machine.getTemperature())).append('\n');
            text.append(String.valueOf(machine.getClothes().size())).append('\n');
            for (ColoredLinen linen:
                 machine.getClothes()) {
                text.append(String.valueOf(linen.getTemperature_of_washing())).append('\n');
                text.append(String.valueOf(linen.getTemperatureOfIron())).append('\n');
                text.append(String.valueOf(linen.getColor())).append('\n');
            }
        }
        return text.toString();
    }

    /**
     * Try to save laundry
     * @return result of saving
     */
    public boolean SaveFile(String FileName) throws java.io.IOException{
        boolean Result = false;
//        FileWriter writer = null;
        try(FileWriter writer = new FileWriter(FileName, false)){
            writer.write(this.ToFile());
            Result = true;
        }
        catch(IOException ex){
            System.err.println(ex.getMessage());
        }
        return Result;
    }

}
