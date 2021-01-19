package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_7576_≈‰∏∂≈‰ {
	static int N,M;
	static int[][] map;
	static int[][] dt = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		int total_num = 0;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					total_num++;
				}else if(map[i][j] == 1){
					q.add(i);
					q.add(j);
					q.add(0);	
				}
			}
		}
		
		//BFS
		int x,y,day = 0;
		int tomato = 0;
		while(!q.isEmpty()) {
			x = q.poll();
			y = q.poll();
			day = q.poll();
			for(int d=0; d<4; d++) {
				int nx = x+dt[d][0];
				int ny = y+dt[d][1];
				if(nx>=0 && nx<N && ny>=0 && ny<M && map[nx][ny] == 0) {
					map[nx][ny] = 1;
					tomato++;
					q.add(nx);
					q.add(ny);
					q.add(day+1);
				}
			}
		}
		
		if(total_num-tomato==0) out.write(Integer.toString(day));
		else out.write("-1");
		out.flush();
		out.close();
	}

}
