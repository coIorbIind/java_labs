package Classes;

public class SortPost {
    final Integer first_temp = 50;
    final Integer second_temp = 100;

    /**
     * Sorting clothes according to temperature of washing and color
     *
     * @param arr - clothes for sorting
     * @return Laundry object
     */
    public static Classes.Laundry Load(ColoredLinen[] arr) {
        Classes.Laundry laundry = new Classes.Laundry();
        ColoredLinen[] black_cold = new ColoredLinen[0];
        ColoredLinen[] white_cold = new ColoredLinen[0];
        ColoredLinen[] color_cold = new ColoredLinen[0];
        ColoredLinen[] black_mean = new ColoredLinen[0];
        ColoredLinen[] white_mean = new ColoredLinen[0];
        ColoredLinen[] color_mean = new ColoredLinen[0];
        ColoredLinen[] black_hot = new ColoredLinen[0];
        ColoredLinen[] white_hot = new ColoredLinen[0];
        ColoredLinen[] color_hot = new ColoredLinen[0];
//        for (int i = 0; i < arr.length; i++) {
//            switch (arr[i].getColor()) {
//                case BLACK -> {
//                    if (arr[i].getTemperature_of_washing() < 50) {
//                        ColoredLinen[] new_arr = new ColoredLinen[black_cold.length + 1];
//                        System.arraycopy(black_cold, 0, new_arr, 0, black_cold.length);
//                        new_arr[new_arr.length - 1] = arr[i];
//                        black_cold = new_arr;
//                    } else {
//                        if (arr[i].getTemperature_of_washing() > 100) {
//                            ColoredLinen[] new_arr = new ColoredLinen[black_hot.length + 1];
//                            System.arraycopy(black_hot, 0, new_arr, 0, black_hot.length);
//                            new_arr[new_arr.length - 1] = arr[i];
//                            black_hot = new_arr;
//                        } else {
//                            ColoredLinen[] new_arr = new ColoredLinen[black_mean.length + 1];
//                            System.arraycopy(black_mean, 0, new_arr, 0, black_mean.length);
//                            new_arr[new_arr.length - 1] = arr[i];
//                            black_mean = new_arr;
//                        }
//                    }
//
//                }
//                case WHITE -> {
//                    if (arr[i].getTemperature_of_washing() < 50) {
//                        ColoredLinen[] new_arr = new ColoredLinen[white_cold.length + 1];
//                        System.arraycopy(white_cold, 0, new_arr, 0, white_cold.length);
//                        new_arr[new_arr.length - 1] = arr[i];
//                        white_cold = new_arr;
//                    } else {
//                        if (arr[i].getTemperature_of_washing() > 100) {
//                            ColoredLinen[] new_arr = new ColoredLinen[white_hot.length + 1];
//                            System.arraycopy(white_hot, 0, new_arr, 0, white_hot.length);
//                            new_arr[new_arr.length - 1] = arr[i];
//                            white_hot = new_arr;
//                        } else {
//                            ColoredLinen[] new_arr = new ColoredLinen[white_mean.length + 1];
//                            System.arraycopy(white_mean, 0, new_arr, 0, white_mean.length);
//                            new_arr[new_arr.length - 1] = arr[i];
//                            white_mean = new_arr;
//                        }
//                    }
//
//                }
//                case COLORS -> {
//                    if (arr[i].getTemperature_of_washing() < 50) {
//                        ColoredLinen[] new_arr = new ColoredLinen[color_cold.length + 1];
//                        System.arraycopy(color_cold, 0, new_arr, 0, color_cold.length);
//                        new_arr[new_arr.length - 1] = arr[i];
//                        color_cold = new_arr;
//                    } else {
//                        if (arr[i].getTemperature_of_washing() > 100) {
//                            ColoredLinen[] new_arr = new ColoredLinen[color_hot.length + 1];
//                            System.arraycopy(color_hot, 0, new_arr, 0, color_hot.length);
//                            new_arr[new_arr.length - 1] = arr[i];
//                            color_hot = new_arr;
//                        } else {
//                            ColoredLinen[] new_arr = new ColoredLinen[color_mean.length + 1];
//                            System.arraycopy(color_mean, 0, new_arr, 0, color_mean.length);
//                            new_arr[new_arr.length - 1] = arr[i];
//                            color_mean = new_arr;
//                        }
//                    }
//
//                }
//            }
//        }
//        if (black_cold.length > 0) {
//            laundry.AddMachine(new Classes.WashingMachine("Ласка", "Lenor", Classes.Color.BLACK,Classes.Temperature.COLD, black_cold));
//        }
//        if (black_mean.length > 0) {
//            laundry.AddMachine(new Classes.WashingMachine("Ласка", "Lenor", Classes.Color.BLACK, Classes.Temperature.MIDDLE, black_mean));
//        }
//        if (black_hot.length > 0) {
//            laundry.AddMachine(new Classes.WashingMachine("Ласка", "Lenor", Classes.Color.BLACK, Classes.Temperature.HOT, black_hot));
//        }
//        if (white_cold.length > 0) {
//            laundry.AddMachine(new Classes.WashingMachine("Tide", "Lenor", Classes.Color.WHITE, Classes.Temperature.COLD, white_cold));
//        }
//        if (white_mean.length > 0) {
//            laundry.AddMachine(new Classes.WashingMachine("Tide", "Lenor", Classes.Color.WHITE, Classes.Temperature.MIDDLE, white_mean));
//        }
//        if (white_hot.length > 0) {
//            laundry.AddMachine(new Classes.WashingMachine("Tide", "Lenor", Classes.Color.WHITE, Classes.Temperature.HOT, white_hot));
//        }
//        if (color_cold.length > 0) {
//            laundry.AddMachine(new Classes.WashingMachine("Persil", "Lenor", Classes.Color.COLORS, Classes.Temperature.COLD, color_cold));
//        }
//        if (color_mean.length > 0) {
//            laundry.AddMachine(new Classes.WashingMachine("Persil", "Lenor", Classes.Color.COLORS, Classes.Temperature.MIDDLE, color_mean));
//        }
//        if (color_hot.length > 0) {
//            laundry.AddMachine(new Classes.WashingMachine("Persil", "Lenor", Classes.Color.COLORS, Classes.Temperature.HOT, color_hot));
//        }
        return laundry;
    }
}
