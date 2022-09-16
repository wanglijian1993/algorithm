package sort;

public class QuickSort extends Sort{


    public static void main(String[] args) {
        quictSort(0,nums.length);
        printNums();



    }

    public static void quictSort(int begin,int end){

        if(end-begin<2)
            return;

        int mid=pivotIndex(begin,end);

        quictSort(begin,mid);
        quictSort(mid+1,end);

    }

    private static int pivotIndex(int begin,int end) {

        int povit=nums[begin];
        end--;
        while (end>begin){

            while (end>begin) {
                if (povit < nums[end]) {
                    end--;
                } else {
                    nums[begin++] = nums[end];
                      break;
                }
            }

            if(end>begin) {

                if (povit > nums[begin]) {
                    begin++;
                } else {
                    nums[end--]=nums[begin];
                    break;
                }
            }

        }


        nums[begin]=povit;
        return begin;

    }


}
