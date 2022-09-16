package sort;

/**
 *  冒泡
 */
public class BubbleSort extends Sort{


    public static void main(String[] args) {

        toBubleSort();
        printNums();
    }


    /**
     * 冒泡排序
     */
   static void toBubleSort(){
       //不具备排序的条件
       if(nums.length<=1){
           return;
       }
       //默认有序
       boolean flag;
        for(int i=1;i<nums.length;i++){
             flag=true;
            for(int j=0;j< nums.length-i;j++){
               //进行转换
              if(nums[j]>nums[j+1]){
                  int temp=nums[j];
                  nums[j]=nums[j+1];
                  nums[j+1]=temp;
                  //进行过排序
                  flag=false;
              }
              if(flag){
               break;
              }
            }

        }

    }

}
