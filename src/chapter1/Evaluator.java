package chapter1;

import java.util.Stack;

/**
 * 解析字符串来进行计算，使用两个栈，一个操作数栈，一个操作符栈
 */
public class Evaluator {
    public static void main(String[] args) {
        String expression = "( 1 + ( 2 * ( 3 + 4 ) ) )";
        Stack<String> ops = new Stack<>();
        Stack<Double> values = new Stack<>();
        for (String c : expression.split("\\s+")) {
            if (c.isEmpty()) {
                continue;
            }
            switch (c) {
                case "(":
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    ops.push(c);
                    break;
                case ")":
                    String op = ops.pop();
                    Double value1 = values.pop();
                    Double value2 = values.pop();
                    switch (op) {
                        case "+":
                            values.push(value1 + value2);
                            break;
                        case "-":
                            values.push(value1 - value2);
                            break;
                        case "*":
                            values.push(value1 * value2);
                            break;
                        case "/":
                            values.push(value1 / value2);
                    }
                    break;
                default:
                    values.push(Double.valueOf(c));
            }
        }
        System.out.println(String.format("%s\n%s\n%s", ops, values, values.pop()));
    }
}
