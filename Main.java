package Calc1;

import java.util.Scanner;


    class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Calculation calculation = new Calculation(sc.nextLine());
            calculation.getResult();
        }

        static class Calculation {
            private final String[] expression;
            private double x;
            private double y;
            private String sym;
            private static final String[] validSym = {"+", "-", "*", "/"};

            public Calculation(String s) {
                expression = s.split(" ");
            }

            public void getResult() {
                try {
                    x = Double.parseDouble(expression[0]);
                    y = Double.parseDouble(expression[2]);
                    if (isValidOperation()) {
                        if (sym.equals("/") && y == 0) {
                            System.out.println("Error! Division by zero");
                        } else {
                            calc();
                        }
                    } else {
                        System.out.println("Operation Error!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error! Not number");
                }
            }

            private void calc() {
                double res;
                if (sym.equals("+")) {
                    res = x + y;
                } else if (sym.equals("-")) {
                    res = x - y;
                } else if (sym.equals("*")) {
                    res = x * y;
                } else {
                    res = x / y;
                }
                System.out.println(res);
            }

            private boolean isValidOperation() {
                boolean isValid = false;
                for (String s : validSym) {
                    if (s.equals(expression[1])) {
                        isValid = true;
                        sym = s;
                        break;
                    }
                }
                return isValid;
            }
        }
    }

