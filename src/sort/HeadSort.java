package sort;

public class HeadSort extends Sort{


    public static void main(String[] args) {
        sort();
        printNums();
    }

    static int heapSize;
    static void sort(){
        //原地建堆
        heapSize= nums.length;
        for(int i=(heapSize>>1)-1;i>=0;i--){
            siftDown(i);
        }
        while (heapSize>1){
            //交换堆顶元素和尾部元素
            swap(0,--heapSize);
            //对0位置进行siftDown(恢复堆的性质)
            siftDown(0);
        }
    }



    static void siftDown(int index){
        int element=nums[index];
        int half=heapSize>>1;
        while (index<half){ //index必须是非叶子节点

            int childIndex=(index<<1)+1;

            int child=nums[childIndex];

            int rightIndex=childIndex+1;
            //右子节点比左子节点大
            if(rightIndex<heapSize && nums[rightIndex] > child){
                child=nums[childIndex=rightIndex];
            }

            //大于等于子节点
            if(element>=child)
                break;
            nums[index]=child;
            index=childIndex;
        }
        nums[index]=element;

    }



}
