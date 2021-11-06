package lvc.cds;

import ods.ArrayStack;
import ods.ArrayStack2;

public class App {

    public static void testArrayStack(ArrayStack<Integer> as, int m, int pos) {
        if (pos == -1) {
            for (int i = 0; i < m; i++) {
                as.add(as.size(), m);
            }
        } else {
            for (int i = 0; i < m; i++) {
                as.add(pos, m);
            }
        }
    }
    public static void testArrayStack2(ArrayStack2<Integer> as, int m, int pos) {
        if (pos == -1) {
            for (int i = 0; i < m; i++) {
                as.add(as.size(), m);
            }
        } else {
            for (int i = 0; i < m; i++) {
                as.add(pos, m);
            }
        }
    }

    public static void testAddAtBeginning(){
        for (int size = 10; size < 1_000_000; size *= 5) {
            var count = 0.0;
            for (int i = 0; i < 10; i++) {
                ArrayStack<Integer> as1 = new ArrayStack<>();
                var start = System.nanoTime();
                testArrayStack(as1, size, 0);
                var elapsed = System.nanoTime() - start;
                count += elapsed;
            }
            var avg = count / 10;
            System.out.println("With size: " + size + "," + " 10 add's took, on average, " + avg / CONVERT + " secs");
        }
        System.out.println();
    }

    public static void testAddAtEnd(){
        for (int size = 10; size < 1_000_000; size *= 5) {
            var count = 0.0;
            for (int i = 0; i < 10; i++) {
                ArrayStack<Integer> as1 = new ArrayStack<>();
                var start = System.nanoTime();
                testArrayStack(as1, size, -1);
                var elapsed = System.nanoTime() - start;
                count += elapsed;
            }
            var avg = count / 10;
            System.out.println("With size: " + size + "," + " 10 add's took, on average, " + avg / CONVERT + " secs");
        }
        System.out.println();
    }

    public static void test2AddAtBeginning(){
         for (int size = 10; size < 1_000_000; size *= 5) {
            var count = 0.0;
            for (int i = 0; i < 10; i++) {
                ArrayStack2<Integer> as1 = new ArrayStack2<>();
                var start = System.nanoTime();
                testArrayStack2(as1, size, 0);
                var elapsed = System.nanoTime() - start;
                count += elapsed;
            }
            var avg = count / 10;
            System.out.println("With size: " + size + "," + " 10 add's took, on average, " + avg / CONVERT + " secs");
        }
    }

    public static void test2AddAtEnd(){
        for (int size = 10; size < 1_000_000; size *= 5) {
            var count = 0.0;
            for (int i = 0; i < 10; i++) {
                ArrayStack2<Integer> as1 = new ArrayStack2<>();
                var start = System.nanoTime();
                testArrayStack2(as1, size, -1);
                var elapsed = System.nanoTime() - start;
                count += elapsed;
            }
            var avg = count / 10;
            System.out.println("With size: " + size + "," + " 10 add's took, on average, " + avg / CONVERT + " secs");
        }

    }
    public static double CONVERT = 1_000_000_000.0;

    public static void main(String[] args) {

        testAddAtBeginning();
        //I would expect testAddAtBeginning to take O(m^2) because each add takes O(m) time and we are doing this O(m) times. We can see this when the code is run.
        //For example we would expect the times to grow by 25x because the size is being increased by a factor of 5 so 5^2 would give us this growth of 25x. 
        //When run, I saw a quadratic relationship when dividing the 5th and 4th time I saw roughly the 25x increase in time that I would expect base off
        //of my inital analsys.


        testAddAtEnd();
        //I would expect testAddAtEnd to take O(m) because each add takes O(1) time and we are doing this O(m) times. We can see this when the code is run.
        //For example we would expect the times to grow by 5x because the size is being increased by a factor of 5 and we expect O(m) this gives us the growth 
        //of 5x. When run, I saw a linear relationship when dividing the 5th and 4th time I saw roughly the 5x increase in time.
        
        
        test2AddAtBeginning();
        //I would expect test2AddAtBeginning to take O(m^2) becasue each add takes O(m) time and we are doing this O(m) times. We can see this when the code is run.
        //For example we would expect the times to grow by 25x because tje size is being increased by a factor of 5 so 5^2 would give us this growth of 25x. 
        //When run, I saw a quadratic relationship when dividing the 5th and 4th time I saw roughly the 25x increase in time, however, it was slightly more because
        //we now have to resize more often. 

        test2AddAtEnd();
        //I would expect test2AddAtEnd to take O(m) becasue each add takes O(1) time and we are doing this O(m) times. We can see this when the code is run.
        //For example we would expect the times to grow by 5x because the size is being increased by a factor of 5 and we expect O(m) so, this gives us the growth 
        //of 5x. When run, I saw a linear relationship when dividing the 5th and 4th time I saw roughly the 5x increase in time. However, again there was a slight 
        //increase in time due to the fact that we are having to resize more often.

    }
}
