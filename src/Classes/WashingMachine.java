package Classes;


import java.util.ArrayList;
import java.util.Objects;

public class WashingMachine {
    private String powder;
    private String fabric_softener;
    private Classes.Color color;
    private Classes.Temperature temperature;
    private ArrayList<ColoredLinen> clothes;

    /**
     * Setting powder field
     *
     * @param value - new value for powder field
     */
    public void setPowder(String value) {
        this.powder = value;
    }

    /**
     *
     * @return value of powder field
     */
    public String getPowder() {
        return powder;
    }

    /**
     * Setting fabric_softener field
     * @param value for fabric_softener field
     */
    public void setFabric_softener(String value) {
        fabric_softener = value;
    }

    /**
     *
     * @return value of fabric_softener field
     */
    public String getFabricSoftener() {
        return fabric_softener;
    }

    /**
     * Setting color field
     * @param value for color field
     */
    public void setColor(Classes.Color value) {
        color = value;
    }

    /**
     *
     * @return value of color field
     */
    public Classes.Color getColor() {
        return color;
    }

    /**
     * Setting temperature field
     * @param temp - value for temperature field
     */
    public void setTemperature(Classes.Temperature temp) {
        temperature = temp;
    }

    /**
     *
     * @return temperature value
     */
    public Classes.Temperature getTemperature() {
        return temperature;
    }

    /**
     *
     * @return linen value
     */
    public ArrayList<ColoredLinen> getClothes() {
        return clothes;
    }

    /**
     * Setting clothes field
     * @param clothes_value - value for clothes field
     */
    public void setClothes(ArrayList<ColoredLinen> clothes_value) {
        clothes = new ArrayList<ColoredLinen>(clothes_value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WashingMachine that = (WashingMachine) o;
        return Objects.equals(powder, that.powder) && Objects.equals(fabric_softener, that.fabric_softener) && color == that.color && temperature == that.temperature;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powder, fabric_softener, color, temperature);
    }

    /**
     *
     * @param linen - linen for addition
     */
    public void addLinen(ColoredLinen linen){
        clothes.add(linen);
    }

    /**
     * default constructor
     */
    public WashingMachine() {
        powder = "Tide";
        fabric_softener = "Lenor";
        color = Classes.Color.BLACK;
        temperature = Classes.Temperature.MIDDLE;
        clothes = new ArrayList<ColoredLinen>();
    }

    /**
     * constructor
     * @param powder_value - value for powder field
     * @param fabric_softener_value - value for fabric_softener_value field
     * @param color_value - value for color_value field
     * @param temperature_value - value for temperature_value field
     * @param clothes_value - value for clothes_value field
     */
    public WashingMachine(String powder_value, String fabric_softener_value, Classes.Color color_value, Classes.Temperature temperature_value, ArrayList<ColoredLinen> clothes_value) {
        powder = powder_value;
        fabric_softener = fabric_softener_value;
        color = color_value;
        temperature = temperature_value;
        clothes = new ArrayList<ColoredLinen>(clothes_value);
    }

    /**
     * override method toSting()
     * @return string value of object
     */
    public String toString() {
        StringBuilder text = new StringBuilder(String.format("Стирает белье %s цвета порошком %s с кондиционером %s при температуре " + getTemperature(), getColor(), getPowder(), getFabricSoftener()));
        text.append("\nБелье: \n");
        for (ColoredLinen item :
                getClothes()) {
            text.append(item.toString()).append("\n");

        }
        return text.toString();
    }
}
