package sort;

public class CountingSort extends Sort{


    public static void main(String[] args) {

        countingSort();
        printNums();

    }

    static void countingSort(){


        //首先找到最大，最小值
        int minNum=Integer.MAX_VALUE;
        int maxNum=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            if(minNum>nums[i]){
                minNum=nums[i];
            }
            if(maxNum<nums[i]){
                maxNum=nums[i];
            }
        }


        //创建区间(最大,最小值)集合
        int [] templeNums=new int[maxNum-minNum+1];

        //区间赋值
        for (int i=0;i<nums.length;i++){
            templeNums[nums[i]-minNum]++;
        }

        int tempIndex=0;
        //取值排序
        for(int i=0;i<templeNums.length;i++){

            if(templeNums[i]>0){
                while (templeNums[i]>0) {
                    nums[tempIndex] =i+minNum;
                    --templeNums[i];
                     tempIndex++;
                }
            }

        }


    }


}
