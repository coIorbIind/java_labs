package Classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Laundry {
    private ArrayList<WashingMachine> washing_machines_array;
    private LinkedList<WashingMachine> washing_machines_linked;

    /**
     * Generating new element to linked list
     */
    public void GenerateElementToTheLinkedList(){
         String[] powder_list = {"Tide", "Ariel", "Persil", "Laska", "Mif", "Vanish"};
         String[] soft_list = {"Lenor", "Losk", "Persil", "EKO", "Laska", "Ecover"};
         WashingMachine new_machine = new WashingMachine();
         new_machine.setPowder(powder_list[(int)Math.floor(Math.random() * powder_list.length)]);
         new_machine.setFabric_softener(soft_list[(int)Math.floor(Math.random() * soft_list.length)]);
         new_machine.setTemperature(Temperature.values()[(int)Math.floor(Math.random() * Temperature.values().length)]);
         new_machine.setColor(Color.values()[(int)Math.floor(Math.random() * Color.values().length)]);
         washing_machines_linked.add(new_machine);
     }

    /**
     * Generating new element to linked list
     */
    public void GenerateElementToTheArrayList(){
        String[] powder_list = {"Tide", "Ariel", "Persil", "Laska", "Mif", "Vanish"};
        String[] soft_list = {"Lenor", "Losk", "Persil", "EKO", "Laska", "Ecover"};
        WashingMachine new_machine = new WashingMachine();
        new_machine.setPowder(powder_list[(int)Math.floor(Math.random() * powder_list.length)]);
        new_machine.setFabric_softener(soft_list[(int)Math.floor(Math.random() * soft_list.length)]);
        new_machine.setTemperature(Temperature.values()[(int)Math.floor(Math.random() * Temperature.values().length)]);
        new_machine.setColor(Color.values()[(int)Math.floor(Math.random() * Color.values().length)]);
        washing_machines_array.add(new_machine);
    }

    /**
     * Removing element from washing_machines_array
     * @param i - index of element for removing
     */
    public void RemoveElementFromTheArrayList(int i){
        washing_machines_array.remove(i);
    }

    /**
     * Removing element from washing_machines_linked
     * @param i - index of element for removing
     */
    public void RemoveElementFromTheLinkedList(int i){
        washing_machines_linked.remove(i);
    }
    /**
     *
     * @return linked list of washing machines
     */
    public LinkedList<WashingMachine> getWashing_machines_linked() {
        return washing_machines_linked;
    }

    /**
     * Setting list of washing_machines
     * @param washing_machines_linked - list of washing_machines
     */
    public void setWashing_machines_linked(LinkedList<WashingMachine> washing_machines_linked) {
        this.washing_machines_linked = washing_machines_linked;
    }

    /**
     * @return array of washing_machines
     */
    public ArrayList<WashingMachine> getWashing_machines_array() {
        return washing_machines_array;
    }

    /**
     * Setting array of washing_machines
     *
     * @param value - array of washing_machines
     */
    public void setWashing_machines_array(ArrayList<WashingMachine> value) {
        washing_machines_array = new ArrayList<WashingMachine>(value);
    }

    /**
     * Adding another washing_machine
     *
     * @param machine - new machine for Laundry
     */
    public void AddMachine(WashingMachine machine) {
        washing_machines_array.add(machine);
    }

    /**
     * Deleting machine
     * @param i - index of washing machine
     */
    public void DeleteMachine(int i){
        washing_machines_array.remove(i);
    }

    /**
     * default constructor
     */
    public Laundry() {
        washing_machines_array = new ArrayList<WashingMachine>();
        washing_machines_linked = new LinkedList<WashingMachine>();
    }

    /**
     * override method toSting()
     *
     * @return string value of object
     */
    public String toString() {
        StringBuilder text = new StringBuilder(String.format("В прачечной находятся %d стиральных машинок:\n", washing_machines_array.size()));
        for (WashingMachine item :
                washing_machines_array) {
            text.append(item.toString()).append("\n");
        }
        return text.toString();
    }

    /**
     * Display laundry to file
     * @return string expression of laundry
     */
    public String ToFile(){
        StringBuilder text = new StringBuilder(String.valueOf(washing_machines_array.size()) + '\n');
        for (WashingMachine machine:
                washing_machines_array) {
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
        try(FileWriter writer = new FileWriter(FileName, false)) {
            writer.write(this.ToFile());
            Result = true;
        }
        return Result;
    }

}
