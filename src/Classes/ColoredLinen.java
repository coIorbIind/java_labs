package Classes;

public class ColoredLinen extends Classes.Linen {
    private Classes.Color color;

    /**
     * Setting color field
     *
     * @param value - value for color field
     */
    public void setColor(Classes.Color value) {
        this.color = value;
    }

    /**
     * @return value of color field
     */
    public Classes.Color getColor() {
        return color;
    }

    /**
     * default constructor
     */
    public ColoredLinen() {
        super();
        this.color =Classes.Color.BLACK;
    }

    /**
     * constructor
     *
     * @param temp1       - value for temperature of washing
     * @param temp2       - value for temperature of iron
     * @param color_value - value for color field
     */
    public ColoredLinen(Temperature temp1, Integer temp2,Classes.Color color_value) {
        super(temp1, temp2);
        this.color = color_value;
    }

    /**
     * override method toSting()
     *
     * @return string value of object
     */
    public String toString() {
        return String.format("Температура стирки: %s. Температура глажки: %d. Цвет: " + getColor(), getTemperature_of_washing(), getTemperatureOfIron());
    }
}
