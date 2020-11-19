package org.letsonlycode.kambv;

public class NewYearRollerCoaster {

    public static void main(String[] args) {

        int a[] = {2, 5, 1, 3, 4};
        /*int a[] = {1, 2, 5, 3, 7, 8, 6, 4};*/

        int swap = 0;
        int resetWasp = 0;
        boolean isTooChaotic = false;

        while(!isArraySorted(a)){
            for (int i = 0; i < a.length-1; i++) {
                if(a[i] > a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    resetWasp++;
                }
                else if(a[i] < a[i+1]){
                    if(resetWasp > 2){
                        isTooChaotic = true;
                        break;
                    }
                    swap = swap + resetWasp;
                    resetWasp = 0;
                }
            }

            if(isTooChaotic){
                break;
            }
            else if(resetWasp > 2){
                isTooChaotic = true;
                break;
            }
            else{
                swap = swap + resetWasp;
            }

            resetWasp = 0;
        }

        if(isTooChaotic)
            System.out.println("TooChaotic");
        else
            System.out.println(swap);
    }

    private static boolean isArraySorted(int a[]){

        for (int i = 0; i < a.length -1; i++) {
            if(!(a[i] < a[i+1])){
                return false;
            }
        }
        return true;
    }
}
