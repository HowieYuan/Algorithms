package dataStructure.queue;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description
 * @date 2018-10-10
 * @time 16:48
 */
public class CircularQueue {
    private int[] nums;
    private int length;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        this.head = 0;
        this.tail = 0;
    }

    public int out() {
        if (head == tail) {
            return -1;
        }
        int value = nums[head];
        head = (head + 1) % length;
        return value;
    }

    public int add(int value) {
        if ((tail + 1) % length == head) {
            return -1;
        }
        nums[tail] = value;
        tail = (tail + 1) % length;
        return 1;
    }

}
