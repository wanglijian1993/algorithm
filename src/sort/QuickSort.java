package sort;

public class QuickSort extends Sort{


    public static void main(String[] args) {

        quickSort(0,nums.length);
        printNums();

    }

   static void quickSort(int begin,int end){

        if(end-begin<2){
            return;
        }
        int mid=pivotIndex(begin,end);
        quickSort(begin,mid);
        quickSort(mid+1,end);


    }

    public static int pivotIndex(int begin,int end){
        //备份begin位置的元素
        int pivot=nums[begin];
        end--;


        while (begin<end){
            while (begin<end) {
                if (nums[end] > pivot) { //右边元素>左边
                    end--;
                }
                //右边元素<=左边元素
                else {
                    nums[begin++] = nums[end];
                    break;
                }
            }

            while (begin<end){
                if(nums[begin]<pivot){
                    begin++;
                }else{
                    nums[end--]=nums[begin];
                    break;
                }
            }

        }
        //将轴点元素放入最终的位置
        nums[begin]=pivot;
        //返回轴点元素
        return begin;
    }

}
