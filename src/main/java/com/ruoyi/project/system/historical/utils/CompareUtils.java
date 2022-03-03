package com.ruoyi.project.system.historical.utils;

/**
 * 浮点数比较
 *
 * @author ray
 * @date 2021/11/22 20:59
 */
public class CompareUtils {
    public static boolean isEqual(double a, double b) {
        if (Double.isNaN(a) || Double.isNaN(b) || Double.isInfinite(a) || Double.isInfinite(b)) {
            return true;
        }
        return (a - b) < 0.0001d;
    }
}
