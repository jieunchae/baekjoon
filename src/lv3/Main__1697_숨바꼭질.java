package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main__1697_숨바꼭질 {
	//처음에 메모리ㅍ초과
	static int N,K;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100010];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		pq.add(new int[] {N,0});
		while(!pq.isEmpty()) {
			int[] now = pq.poll();	//[0]이 현재위치 [1]은 이동횟수
			if(now[0] == K) {
				out.write(Integer.toString(now[1]));
				break;
			}
			if(now[0]-1 >= 0 && !visited[now[0]-1]) {
				pq.add(new int[] {now[0]-1,now[1]+1});
				visited[now[0]-1] = true;
			}
			if(now[0]+1 <= 100000 && !visited[now[0]+1]) {
				pq.add(new int[] {now[0]+1,now[1]+1});
				visited[now[0]+1] = true;
			}
			if(now[0]*2 >=0 && now[0]*2 <= 100000 && !visited[now[0]*2]) {
				pq.add(new int[] {now[0]*2,now[1]+1});
				visited[now[0]*2] = true;
			}
		}
		out.flush();
		out.close();
	}

}
