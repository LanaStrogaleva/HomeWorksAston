
public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] array = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] array1 = {
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        String[][] array2 = {
                {"1", "1", "1", "*"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };

        try {
            System.out.println("Сумма: " + sumArray(array1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (array.length != 4) {
            throw new MyArraySizeException("Количество строк не равно 4!");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Количество столбцов не равно 4 в строке " + i);
            }
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum = Integer.parseInt(array[i][j]) + sum;
                } catch (NumberFormatException er) {
                    throw new MyArrayDataException("Не удалось преобразовать элемент массива в число: строка " + i + " столбец " + j);
                }
            }
        }
        return sum;
    }
}
