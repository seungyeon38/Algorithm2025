package comparable_comparator_활용문제;

import java.io.*;
import java.util.*;

public class boj11651_좌표정렬하기2_comparable_pq_648ms {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int N = Integer.parseInt(br.readLine()); // 점의 개수 (1~100000)
        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int n = 0; n < N; n++) {
            String[] point = br.readLine().split(" ");

            int point_x = Integer.parseInt(point[0]); // -100000~100000
            int point_y = Integer.parseInt(point[1]);
            Point p = new Point(point_x, point_y);
            pq.add(p);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }
        // br.close();
        System.out.println(sb.toString());
    }

}

class Point implements Comparable<Point> {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        if (this.y == p.y) {
            return this.x - p.x;
        } else
            return this.y - p.y;
    }
}