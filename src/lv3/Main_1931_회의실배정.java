package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1931_회의실배정 {
	public static class meeting{
		int start;
		int end;
		int hour;
		public meeting(int start, int end, int hour) {
			super();
			this.start = start;
			this.end = end;
			this.hour = hour;
		}
	}
	static int N;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		PriorityQueue<meeting> pq = new PriorityQueue<>(new Comparator<meeting>() {
			@Override
			public int compare(meeting o1, meeting o2) {
				if(o1.end != o2.end)
					return o1.end-o2.end;
				else return o1.start-o2.start;
			}
		});
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new meeting(start,end,end-start));
		}
		
		int now = 0;
		int ans = 0;
		while(!pq.isEmpty()) {
			meeting top = pq.poll();
			if(top.start >= now) { //회의가능
				ans ++;
				now = top.end;
			}else continue;
		}
		
		out.write(Integer.toString(ans));
		out.flush();
		out.close();
	}

}
