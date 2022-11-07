package 算法高频题;

import java.util.Arrays;

public class 会议室 {


    public static void main(String[] args) {
        int[][] meets={{15,20},{0,4},{5,10}};

//        int[][] meets={{15,20},{0,30},{5,10}};
        System.out.println(canAttendMeetings(meets));

    }

    public static boolean canAttendMeetings(int[][] intervals) {

        // 按照会议的开始时间，从小到大排序
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
       for(int i=1;i<intervals.length;i++){

           if(intervals[i][0]<intervals[i-1][1]){
               return false;
           }

       }
       return true;

    }



}
