public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"5", "185", "121", "145"},
                {"226", "241", "960", "430"},
                {"763", "647", "970", "967"},
                {"111", "960", "143", "121"}
        };
        try {
            System.out.println("Сумма всех чисел матрицы: " + method(array));
        }
        catch (MyArraySizeException | MyArrayDataException | MyHammingException e){
            e.printStackTrace();
        }
    }

    public static int method(String[][] array) throws MyArraySizeException, MyArrayDataException, MyHammingException{

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i].length != 4 | array[j].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }

        int sum = 0;
        int number;
        for (int k = 1; k<=4; k++) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length; j++) {
                    try {
                        number = Integer.parseInt(array[i][j]);
                        sum += number;
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i,j,array[i][j]);
                    }
                    try {
                        if (array[i][j].length() == k && Hemming(number))
                            throw new MyHammingException(i, j, array[i][j]);
                    } catch (MyHammingException  ham) {
                        ham.printStackTrace();
                    }

                }
            }
        }
        return sum/4;
    }

    public static boolean Hemming(int number)
    {
        int n = 86;
        int[] hammingNumbers = new int[n];
        hammingNumbers[0] = 1;

        int index2 = 0, index3 = 0, index5 = 0;

        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            hammingNumbers[i] = min;

            if (min == nextMultipleOf2) {
                index2++;
                nextMultipleOf2 = hammingNumbers[index2] * 2;
            }
            if (min == nextMultipleOf3) {
                index3++;
                nextMultipleOf3 = hammingNumbers[index3] * 3;
            }
            if (min == nextMultipleOf5) {
                index5++;
                nextMultipleOf5 = hammingNumbers[index5] * 5;
            }
        }
        for (int i = 1; i < n; i++)
        {
            if (number == hammingNumbers[i])
                return true;
        }
        return false;
    }

}