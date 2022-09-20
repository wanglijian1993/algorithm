package sort;

public class RadixSort extends Sort{


    public static void main(String[] args) {
        sort();

    }


    protected static void sort() {
        // 找出最大值
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        // 个位数: nums[i] / 1 % 10 = 3
        // 十位数：nums[i] / 10 % 10 = 9
        // 百位数：nums[i] / 100 % 10 = 5
        // 千位数：nums[i] / 1000 % 10 = ...

        for (int divider = 1; divider <= max; divider *= 10) {
            countingSort(divider);
        }
    }

    protected static void countingSort(int divider) {
        // 开辟内存空间，存储次数
        int[] counts = new int[10];
        // 统计每个整数出现的次数
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i] / divider % 10]++;
        }
        // 累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // 从后往前遍历元素，将它放到有序数组中的合适位置
        int[] newnums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            newnums[--counts[nums[i] / divider % 10]] = nums[i];
        }

        // 将有序数组赋值到nums
        for (int i = 0; i < newnums.length; i++) {
            nums[i] = newnums[i];
        }
    }
}
