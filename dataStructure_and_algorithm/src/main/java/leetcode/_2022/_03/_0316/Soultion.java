package leetcode._2022._03._0316;

public class Soultion {
    /**
     *  此想法 是将 找到不i为零的数将其放在正常的位数， 然后通过条件将后面的置为0；
     * @param nums
     */
    public static void moveZeros(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }


    public static void moveZeros1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0, j = 0, k = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[j] = nums[i];
                j++;
            } else {
                result[nums.length - 1 - k] = 0;
                k++;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }


    public static void moveZeros2(int[] nums){
        // 计数到底存在 几个零
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0){
                count ++;
            }else {
                // 将不为0的数字向前移动 当前已经存在 零 的个数下标即可
                nums[j - count] = nums[j];
            }

        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void moveZeros3(int [] nums){
        int insertPosition = 0;
            for (int num : nums)    {
                    if (num != 0) {
                            nums[insertPosition++] = num;
                        }
                }
            while (insertPosition < nums.length){
                    nums[insertPosition++] = 0;
                }
        }

    public static void moveZeros4(int [] nums){
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

        public static void main(String[] args) {
            int[] ints = {1, 0, 2, 4, 0, 13};
            moveZeros4(ints);
            for (int i = 0; i < ints.length; i++) {
                System.out.println(ints[i]);
            }
//        moveZeros1(ints);
        }


    }
