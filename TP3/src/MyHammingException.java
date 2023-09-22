
public class MyHammingException extends RuntimeException{

        public MyHammingException(int i, int j, String value){
            super("В ячейке с индексом [" + i + "]["+ j +"] лежит \"" + value + "\", что в свою очередь является числом Хемминга.");
        }

    }
