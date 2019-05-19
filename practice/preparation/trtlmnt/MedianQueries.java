package com.sbs.communicationcontrol.services.document;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.PriorityQueue;


class MedianQueries {
  public static void main(String args[]) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter wr = new PrintWriter(System.out);
    int N = Integer.parseInt(br.readLine().trim());
    int[] A = new int[N];
    String[] inp = br.readLine().split(" ");
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(inp[i]);
    }
    int Q = Integer.parseInt(br.readLine().trim());
    for (int i = 0; i < Q; i++) {
      String[] inp1 = br.readLine().split(" ");
      int L = Integer.parseInt(inp1[0]);
      int R = Integer.parseInt(inp1[1]);
      int out_ = solve(N, A, L, R);
      System.out.println(out_);
    }
    wr.close();
    br.close();
  }

  private static int solve(int n, int[] array, int left, int right) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int i = left - 1; i < right; i++) {
      minHeap.offer(array[i]);
    }

    int len = (right - left + 1);
    boolean isEven = len % 2 == 0;

    int middle = isEven ? len / 2 : len / 2 + 1;
    int i = 0;
    while (!minHeap.isEmpty() && i++ < middle - 1) {
      minHeap.poll();
    }
    return minHeap.poll();
  }
}