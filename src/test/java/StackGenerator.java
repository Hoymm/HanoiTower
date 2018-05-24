import rollerStackGenerator.Rollers.Roller;

import java.util.Stack;

class StackGenerator {
    static int[] generateIntArray(int from, int to) {
        int [] resultArray = new int [Math.abs(to-from)+1];

        if (from < to){
            addValuesIncreasingly(from, to, resultArray);
        }
        else{
            addValuesDecreasingly(from, to, resultArray);
        }

        return resultArray;
    }

    static void addValuesIncreasingly(int from, int to, int[] resultArray) {
        for (int i = 0; i <= to-from; ++i){
            resultArray[i] = i+from;
        }
    }

    static void addValuesDecreasingly(int from, int to, int[] resultArray) {
        for (int i = 0; i <= from-to; ++i){
            resultArray[i] = from-i;
        }
    }

    static Stack<Roller> generateRollerStackFirstIndexToBottom(int... rollersSizes) {
        Stack<Roller> rollerStack = new Stack<>();
        for (int rollerSize : rollersSizes){
            rollerStack.add(new Roller(rollerSize));
        }
        return rollerStack;
    }
}
