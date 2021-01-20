package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main_7662_이중우선순위큐 {
	//트리맵을 사용해야하는데 ArrayList를 사용했다
	static int T,N;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(in.readLine());
		TreeMap<Long, Long> map = new TreeMap<>();
		for(int test_case=0; test_case<T; test_case++) {
			N = Integer.parseInt(in.readLine());
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				String order = st.nextToken();
				long num = Long.parseLong(st.nextToken());
				
				if(order.equals("I")) {
					if(map.containsKey(num)) {
						map.put(num, map.get(num)+1);
					}else {
						map.put(num, 1L);
					}
				}else{
					if(map.size()==0) continue;	//빈 리스트
					if(num == -1) {	//최솟값 삭제
						long minKey = map.firstKey();
						long next = map.get(minKey)-1;
						if(next==0) map.remove(minKey);
						else map.put(minKey, next);
					}
					else {
						long maxKey = map.lastKey();
						long next = map.get(maxKey)-1;
						if(next==0) map.remove(maxKey);
						else map.put(maxKey, next);
					}
				}
			}//연산 끝
			if(map.size() == 0) {
				out.write("EMPTY");
			}else {
				out.write(Long.toString(map.lastKey())+" "+Long.toString(map.firstKey()));
			}
			out.newLine();
			map.clear();
		}
		out.flush();
		out.close();
	}

}
