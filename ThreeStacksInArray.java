public class ThreeStacksInArray {
private int[] array;
private int size, topOne, topTwo, topThree, baseThree;

public ThreeStacksInArray(int size) throws Exception {
    if (size < 3)
        throw new Exception("Size should be at least 3");

    this.size = size;
    array = new int[size];
    topOne = -1;
    topTwo = size;
    baseThree = size/2;
    topThree = baseThree;
}

/*
 ------------------------------------------------------------
 |                            |                             |
 |                            |                             |
 |--->                        |--->                     <---|
 ------------------------------------------------------------ 
 topOne              baseThree & topThree              topTwo
 
*/

public void push(int stackID, int data) throws Exception {
    if (stackID ==  1) {
        if (topOne + 1 == baseThree) {
            if (isMiddleStackRightShiftable()) {
                shiftMiddleStackToRight();
                array[++topOne] = data;
            } else
                throw new Exception("Stack 1 is full!");
        } else
            array[++topOne] = data;
        
     } else if (stackID == 2) {
            if (topTwo - 1 == topThree) {
                if (isMiddleStackLeftShiftable()) {
                    shiftMiddleStackToLeft();
                    array[--topTwo] = data;
                }
                else
                    throw new Exception("Stack 2 is full!");
     } else if (stackID == 3) {
            if (topTwo - 1 == topThree) {
                if (isMiddleStackLeftShiftable) {
                    shiftMiddleStackToLeft();
                    array[++topThree] = data;
                }
            } else
                throw new Exception("Stack 3 is full!");
             
