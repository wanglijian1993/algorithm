package sort;

public class InsertSort extends Sort{


    /**
     * 插入排序
     */
   static void insertSort(){
        for(int i=1;i<nums.length;i++){
           //记录要插入的值
           int tempNum=nums[i];

           //记录下要移动的位置
           int j=i;
           while (tempNum<nums[j-1]&&j>0){
               nums[j]=nums[j-1];
               j--;
           }
           if(j!=i){
               nums[j]=tempNum;
           }

        }

    }

    /**
     * 位置移动
     * @param startIndex
     * @param endIndex
     */
    static void move(int startIndex,int endIndex){
        for(int i=endIndex;i>startIndex;i--){
           nums[i]=nums[i-1];
        }
    }


    public static void main(String[] args) {
        insertSort();
        printNums();
    }
}
