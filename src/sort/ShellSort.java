package sort;

public class ShellSort extends Sort{


    static void xirSort(){

       int len=nums.length;

       int temp;
       //进行/2的希尔

        for(int step=len/2;step>0;step/=2){

            for(int i=step;i<len;i++){
                temp=nums[i];
               int j=i-step;
                while (j>0&&nums[j]>temp){
                    nums[j+step]=nums[j];
                    j-=step;
                }
                nums[j+step]=temp;

            }

        }



    }

    public static void main(String[] args) {
        xirSort();
        printNums();
    }

}
