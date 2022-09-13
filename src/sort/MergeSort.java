package sort;

import java.util.Arrays;

public class MergeSort extends Sort{

    static  int[] leftArray;

    public static void main(String[] args) {

        sort(0,nums.length);
        printNums();

    }


    static void sort(int begin,int end){

        if(end-begin<2){
            return;
        }

        int mid=(begin+end)>>1;
        sort(begin,mid);
        sort(mid,end);
        merge(begin,mid,end);
    }

    private static void merge(int begin,int mid, int end) {

        int lt=0;
        int l=begin;
        int le=mid-begin;
        int r=mid;
        int re=end;
        int[] leftArray=new int[le];
        for(int i=lt;i<le;i++){
            leftArray[i]=nums[begin+i];
        }
        //左边还没有结束
        while (lt<le){
           if(r<re&&nums[r]<leftArray[lt]){
               nums[l++]=nums[r++];
           }else{
               nums[l++]=leftArray[lt++];
           }
        }

    }


}
