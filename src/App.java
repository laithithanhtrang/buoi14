import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // 1C
        // 2C
        // 3B
        // 4A
        // 5A,B
        // 7A
        // 8D
        
        // bai 1
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> numberList = new ArrayList<Integer>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Ban muon them vao list?");
        String input = scan.nextLine();
        while (!input.equals("Q")) {
            list.add(input);
            input = scan.nextLine();
        }
        System.out.println(list);
        for (String str : list) {
            if (isNumeric(str)) {
                int number = Integer.parseInt(str);
                numberList.add(number);
            }
        }
        Collections.sort(numberList);
        System.out.println(numberList);

        // bai2
        System.out.println("Nhap vao mot so nguyen duong >8 va <14");
        int n = scan.nextInt();
        if (n < 8 || n > 14) {
            System.exit(0);
        }
        ArrayList<Integer> secondList = new ArrayList<Integer>();
        for (int i = -10; i < 11; i++) {
            secondList.add(i);
        }
        Collections.shuffle(secondList);
        for (int i = 0; i < n; i++) {
            System.out.println(secondList.get(i));
        }
        System.out.println("Nhap gia tri can so sanh tu ban phim");
        int y = scan.nextInt();
        findClosetPair(secondList, n, y);
        scan.close();

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void findClosetPair(ArrayList<Integer> arr, int n, int x) {
        int res_l = 0, res_r = 0; // luu index cua hai so l va r
        int l = 0, r = n - 1, diff = Integer.MAX_VALUE; // khoi tao bien diff la vo han de luu tru su khac biet giua x
                                                        // và các cặp
        // khoi tao hai bien l va r la index dau va cuoi cua cap cho truoc

        while (l < r) {
            if (Math.abs(arr.get(l) + arr.get(r) - x) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(arr.get(l) + arr.get(r) - x);
            }

            if (arr.get(l) + arr.get(r) > x)
                r--;
            else
                l++;
        }

        System.out.println("Hai cap so gan nhat la  " + arr.get(res_l) + " va  " + arr.get(res_r));
    }
}
