package Classes;

import Views.View;

public abstract class Linen {
    protected Temperature temperature_of_washing;
    protected Integer temperature_of_iron;

    /**
     * @param value for temperature_of_washing field
     */
    public void setTemperature_of_washing(Temperature value) {
        this.temperature_of_washing = value;
    }

    /**
     * @return value of temperature_of_washing field
     */
    public Temperature getTemperature_of_washing() {
        return temperature_of_washing;
    }

    /**
     * @param value for temperature_of_iron field
     */
    public void setTemperatureOfIron(Integer value) {
        if (value > 0) {
            this.temperature_of_iron = value;
        } else {
            View.Out("Температура должна быть натуральным числом");
        }
    }

    /**
     * @return value of temperature_of_iron field
     */
    public Integer getTemperatureOfIron() {
        return temperature_of_iron;
    }

    /**
     * default constructor
     */
    public Linen() {
        temperature_of_iron = 30;
        temperature_of_washing = Temperature.COLD;
    }

    /**
     * constructor
     *
     * @param temp1 - value for temperature of washing
     * @param temp2 - value for temperature of iron
     */
    public Linen(Temperature temp1, Integer temp2) {
        this.setTemperature_of_washing(temp1);
        this.setTemperatureOfIron(temp2);
    }
}
