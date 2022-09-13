package sort;

public class SelectSort extends Sort{



    static void selectSort(){

        int index;
        for(int i=0;i<nums.length;i++){
              index=i;
            for(int j=i;j<nums.length;j++){
              if(nums[j]<nums[index]) {
                  index = j;
              }
            }
            //找到最小值
            if(index!=i){
                int temp=nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
            }

        }

    }

    public static void main(String[] args) {
     selectSort();
     printNums();
    }
}
