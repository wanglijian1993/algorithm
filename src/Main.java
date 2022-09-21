import circle.CircleQueue;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//     System.out.println(fib2(60));

     //hascode =((j*31+a)*n+c)*n+k
//     String str="jack";
//        int hashcode=0;
//     for(int i=0;i<str.length();i++){
//         char c=str.charAt(i);
//        hashcode=hashcode*31+c;
//     }
//    System.out.println(hashcode);
//    System.out.println(str.hashCode() );
//        testCircleQueue();



    }

static void testCircleQueue(){
    CircleQueue<Integer> queue = new CircleQueue<Integer>();
    // 0 1 2 3 4 5 6 7 8 9
    for (int i = 0; i < 10; i++) {
        queue.enQueue(i);
    }
    // null null null null null 5 6 7 8 9
    for (int i = 0; i < 5; i++) {
        queue.deQueue();
    }
    // 15 16 17 18 19 5 6 7 8 9
    for (int i = 15; i < 20; i++) {
        queue.enQueue(i);
    }
    while (!queue.isEmpty()) {
        System.out.println(queue.deQueue());
    }
    System.out.println(queue);
}

    static void calculate(int j){

        for (int i=0;i<10;i++)

            j++;

        System.out.println("j in calculate() is: "+j);

    }

    /**
     * 斐波那契队列
     * 0 1 1 2 3 5 8 13
     * n=(n-1)+(n-2)
     * 时间复杂度
     * n=
     * 1+2+4+8=2^0 + 2^1 + 2^2 + 2^3 =2^4-1=2^(n-1) - 1 =0.5 * 2^n - 1
     * O(2^n)
     */
    private static int fib1(int n){
        if(n<=1){
            return n;
        }
        return fib1(n-1)+fib1(n-2);
    }

    private static int fib2(int n){
        if(n<=1){
            return n;
        }
        int first=0;
        int second=1;
        for(int i=0;i<n-1;i++){
            int sum=first+second;
            first=second;
            second=sum;
        }
        return second;

    }

    /**
     * log2(n)
     * 取n的对数
     * 举例
     * 8 log2(3)
     * 16 log2(4)
     * @param n
     */
    public static void test1(int n){

        while ((n=n/2)>0){
            System.out.println("test");
        }
    }

    /**
     * log5(n)
     * @param n
     */
    public static void test2(int n){
        while ((n=n/5)>0){
            System.out.println("test");
        }
    }

    /**
     * log2(n)*2+log2(n)*(3N=1)+1
     *  3*log2(n)+3n*log2(n)
     * @param n
     */
    public static void test3(int n){
        /**
         * (int i=1;i<n;i=i*2) log2(n)
         * log2(n)*(3N+1)
         */
        for(int i=1;i<n;i=i*2){
            for(int j=0;j<n;j++){
                System.out.println("test");
            }
        }

    }



}
