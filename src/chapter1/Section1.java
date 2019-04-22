package chapter1;

public class Section1 {
    // 是否素数
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 平方根（牛顿迭代法）
    public static double sqrt(double n) {
        if (n < 0) {
            return Double.NaN;
        }
        double precision = 1e-15, r = 1;
        while (Math.abs(n / r - r) > precision) {
            r = (n / r + r) / 2;
        }
        return r;
    }

    // 二分查找，数组必须是有序的
    public static int binarySearch(int key, int[] a) {
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            // 找到中间值索引
            int mid = (lo + hi) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(3));
    }
}
