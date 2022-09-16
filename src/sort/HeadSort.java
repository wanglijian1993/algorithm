package sort;

/**
 * 堆排序
 */
public class HeadSort extends Sort{


    public static void main(String[] args) {

        sort();
        printNums();
    }
    private static int headSize;
    private static void sort() {
        headSize= nums.length;

        //建堆
        for(int i=((headSize>>1)-1);i>=0;i--){
            sfitDown(i);
        }
        while (headSize>1){
            //交换堆顶元素的位置  堆-1
            swap(0,--headSize);
            //对0位置进行siftDown（恢复堆的性质）
            sfitDown(0);
        }
    }

    private static void sfitDown(int index) {

         int temple=nums[index];
         //当前堆的中间值
         int half=headSize>>1;

         while (half>index){
             int childIndex=(index << 1)+1;

             int child=nums[childIndex];

             int rightIndex=childIndex+1;

             if(rightIndex<headSize&&child<nums[rightIndex]){
                 child=nums[childIndex=rightIndex];
             }

             if(temple>=child)
                 break;
             nums[index]=child;
             index=childIndex;
         }
         nums[index]=temple;

    }


}
