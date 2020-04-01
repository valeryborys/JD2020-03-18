package by.it.borys.jd01_05;


import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double[] A = step1();
        step2(A);
        step3();
    }

    private static double[] step1() {
        int i = 0;
        double[] z = new double[30];
        System.out.println("Массив A[]");
        for (double x = 5.33; x <= 9; x += (9 - 5.33) / 30) {
            z[i] = cbrt(pow(x, 2) + 4.5);
            System.out.printf("%s[%d] = %6.5f ", "A", i, z[i]);
            if (i <= z.length) {
                i++;
            } else break;
            if (i % 5 == 0) System.out.println();
        }
        System.out.println();
        return z;


    }

    private static void step2(double[] A) {
        int Blength = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 3.5) {
                Blength++;

            }

        }
        double[] B = new double[Blength];
        System.out.println("Массив B[] из элементов массива A > 3.5");
        int k = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 3.5) {
                B[k] = A[i];
                k++;
            }
        }
        double mul = 1;
        for (int j = 0; j < B.length; j++) {
            mul *= B[j];
            System.out.printf("%s[%d] = %6.5f ", "B", j, B[j]);
            if ((j + 1) % 5 == 0) System.out.println();
        }
        double midgeom = pow(mul, (1. / B.length));
        System.out.println();
        System.out.println("Cреднее геометрическое массива B = " + midgeom);
        System.out.println();
    }

    public static void step3() {
        int[] A = new int[31];
        int k = 0;
        System.out.println(" Массив А (индекс  по строкам)");
        System.out.println("╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗");

        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (random() * 348 + 103);

            System.out.printf("║ %s[%2d]=%d ", "A", i + 1, A[i]);
            if ((i + 1) % 5 == 0 && (i + 1) < A.length) {
                System.out.println("║");
                System.out.println("╠═══════════╬═══════════╬═══════════╬═══════════╬═══════════╣");

            }

            if (A[i] * 0.1 > i) {
                k++;
            }
        }
        if (A.length % 5 != 0) {
            int nullcolums = 6 - A.length % 5;
            for (int i = 0; i < nullcolums; i++) {
                System.out.print("║           ");
            }
        } else System.out.print("║");
        System.out.println();
        System.out.println("╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝");
        int j = 0;
        int[] B = new int[k];
        for (int i = 0; i < A.length; i++) {
            if (A[i] * 0.1 > i) {
                B[j] = A[i];
                j++;
            }
        }
        sort(B);
        System.out.println(" Массив B (индекс  по столбцам)");
        int colums = (int) Math.ceil(B.length / 7.);
        switch (colums) {
            case 1:
                System.out.println("╔═══════════╗");
                for (int m = 0; m < B.length; m++) {
                    for (int i = m; i < B.length; i += 7) {
                        System.out.printf("║ %s[%2d]=%d ║", "B", i + 1, B[i]);
                    }
                    System.out.println();
                    if (m < B.length - 1) System.out.println("╠═══════════╣");

                }
                System.out.println("╚═══════════╝");
                break;
            case 2:
                System.out.println("╔═══════════╦═══════════╗");
                for (int m = 0; m < 7; m++) {
                    int count = 0;
                    for (int i = m; i < B.length; i += 7) {
                        System.out.printf("║ %s[%2d]=%d ", "B", i + 1, B[i]);
                        count++;
                    }

                    if (count == 1) {
                        System.out.print("║");
                        System.out.println("           ║");
                    } else System.out.println("║");
                    if (m <= 5) System.out.println("╠═══════════╬═══════════╣");

                }
                System.out.println("╚═══════════╩═══════════╝");
                break;
            case 3:
                System.out.println("╔═══════════╦═══════════╦═══════════╗");
                for (int m = 0; m < 7; m++) {
                    int count = 0;
                    for (int i = m; i < B.length; i += 7) {
                        System.out.printf("║ %s[%2d]=%d ", "B", i + 1, B[i]);
                        count++;
                    }

                    if (count == 2) {
                        System.out.print("║");
                        System.out.println("           ║");
                    } else System.out.println("║");
                    if (m <= 5) System.out.println("╠═══════════╬═══════════╬═══════════╣");

                }
                System.out.println("╚═══════════╩═══════════╩═══════════╝");
                break;

            case 4:
                System.out.println("╔═══════════╦═══════════╦═══════════╦═══════════╗");
                for (int m = 0; m < 7; m++) {
                    int count = 0;
                    for (int i = m; i < B.length; i += 7) {
                        System.out.printf("║ %s[%2d]=%d ", "B", i + 1, B[i]);
                        count++;
                    }

                    if (count == 3) {
                        System.out.print("║");
                        System.out.println("           ║");
                    } else System.out.println("║");
                    if (m <= 5) System.out.println("╠═══════════╬═══════════╬═══════════╬═══════════╣");

                }
                System.out.println("╚═══════════╩═══════════╩═══════════╩═══════════╝");
                break;
            case 5:
                System.out.println("╔═══════════╦═══════════╦═══════════╦═══════════╦═══════════╗");
                for (int m = 0; m < 7; m++) {
                    int count = 0;
                    for (int i = m; i < B.length; i += 7) {
                        System.out.printf("║ %s[%2d]=%d ", "B", i + 1, B[i]);
                        count++;
                    }

                    if (count == 4) {
                        System.out.print("║");
                        System.out.println("           ║");
                    } else System.out.println("║");
                    if (m <= 5) System.out.println("╠═══════════╬═══════════╬═══════════╬═══════════╬═══════════╣");

                }
                System.out.println("╚═══════════╩═══════════╩═══════════╩═══════════╩═══════════╝");
                break;
        }


    }

    private static void sort(int[] arr) {
        int i = 1;
        int temp;
        while (i < arr.length) {
            if (i == 0 || arr[i - 1] <= arr[i]) {
                i++;
            } else {
                temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;

            }
        }
    }
}

