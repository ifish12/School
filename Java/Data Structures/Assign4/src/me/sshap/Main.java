package me.sshap;
import com.sun.org.apache.xpath.internal.operations.Bool;
import me.sshap.Link;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = 0;
        int m = 0;
        int x = 1; // counter for removal
        System.out.print("Enter number n: ");
        n = kb.nextInt();
        System.out.print("Enter number m: ");
        m = kb.nextInt();

        // Building the circle
        Link<Integer> head = new Link<Integer>();
        Link<Integer> last = new Link<Integer>();
        for (int c = 0; c < n; c++) {
            if(c==0){
                head.element = c+1;
                head.next = head;
                last = head;
            }
            else {
                Link<Integer> tmp = new Link<Integer>();
                tmp.next = head;
                last.next = tmp;
                tmp.element = c+1;
                last = tmp;
            }
        }
        Boolean f = true;
        Link<Integer> count = new Link<Integer>();


        while(head.next != null){
             for (int w = 1; w <= m; w++){
                if (w == m - 1) {
                    if (count == head) {
                        System.out.println("Deleting:" + count.next.element);
                        head = head.next;
                        count.next = head;
                    }
                    else {
                        System.out.println("Deleting:" + count.next.element);
                        count.next = count.next.next;

                    }
                }
                if(f) {
                    count = head;
                    f = false;
                }
                count = count.next;

            }
        }

    }
}
