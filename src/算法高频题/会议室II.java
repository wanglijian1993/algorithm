package 算法高频题;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 需要开几间会议室
 */
public class 会议室II {
    public static void main(String[] args) {
       int[][] meets={{0,6},{4,14},{8,22},{16,24},{25,26}};
       System.out.println(minMeetingRooms1(meets));
    }

     /*
      *贪心算法
      */
    public static int minMeetingRooms(int[][] intervals) {

        if(intervals==null) return 0;
        int[] begins=new int[intervals.length];
        int[] ends=new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            begins[i]=intervals[i][0];
            ends[i]=intervals[i][1];
        }

        Arrays.sort(begins);
        Arrays.sort(ends);

        //会议结束时间下标，和对应会议室数量
        int ides=0,rooms=0;
        for(int begin:begins){
            if(begin>=ends[ides]){
                ides++;
            }else{
                rooms++;
            }

        }
        return rooms;

    }


    public static int minMeetingRooms1(int[][] intervals){

        if(intervals==null){
            return 0;
        }
        //对会议室开始的时间进行排序
        Arrays.sort(intervals,(m1,m2) -> m1[0]-m2[0]);
        //创建一个堆存储会议室结束时间
        PriorityQueue<Integer> heap=new PriorityQueue();
        //存放会议室第一个结束的时间
        heap.add(intervals[0][1]);

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=heap.peek()){
                heap.remove();
            }
            heap.add(intervals[i][1]);
        }
        return heap.size();


    }



}
