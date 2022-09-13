package greedy;

import java.util.Arrays;

public class CoinChange {


    public static void main(String[] args) {

         Integer [] faces={25,5,10,1};
         Arrays.sort(faces,(Integer f1,Integer f2)->f2-f1);
         int memory=41,coin=0,i=0;
         while (i<faces.length){
             if(memory<faces[i]){
                 i++;
                 continue;
             }
             System.out.println("memory:"+faces[i]);
             memory-=faces[i];
             coin++;
         }
        System.out.println("coin:"+coin);

    }

}
