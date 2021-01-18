package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_1463_1로만들기 {
	static int N;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		//BFS -PQ??
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		q.add(new int[] {0,N});
		while(!q.isEmpty()) {
			int[] now = q.poll();	//now[0]->연산횟수 now[1] -> 숫자
			if(now[1] == 1) {
				out.write(Integer.toString(now[0]));
				break;
			}
			if(now[1]%3 == 0) {
				q.add(new int[] {now[0]+1,now[1]/3});
			}
			if(now[1]%2 == 0) {
				q.add(new int[] {now[0]+1,now[1]/2});
			}
			q.add(new int[] {now[0]+1, now[1]-1});
		}//BFS끝
		out.flush();
		out.close();
		

	}

}
