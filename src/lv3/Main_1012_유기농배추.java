package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
	static int T,N,M,K;
	static int arr[][];
	static int[][] dt = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(in.readLine());
		for(int test_case=0; test_case<T; test_case++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(in.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			//처리
			int idx = 2;
			ArrayDeque<Integer> queue = new  ArrayDeque<Integer>();
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] == 1) {
						arr[i][j] = idx;
						//BFS
						queue.add(i);
						queue.add(j);
						while(!queue.isEmpty()) {
							int x = queue.poll();
							int y = queue.poll();
							//System.out.println(x+" "+y);
							for(int d=0; d<4; d++) {
								int nx = x+dt[d][0];
								int ny = y+dt[d][1];
								if(nx>=0 && nx<N && ny>=0 && ny<M && arr[nx][ny] == 1) {
									queue.add(nx);
									queue.add(ny);
									arr[nx][ny] = idx;
								}
							}
						}
						idx++;
					}
				}
			}//맵돌기 끝
			out.write(Integer.toString(idx-2));
			out.newLine();
		}
		out.flush();
		out.close();
	
	}

}
