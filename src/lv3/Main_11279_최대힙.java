package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11279_�ִ��� {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		for(int t=0; t<N; t++) {
			int num = Integer.parseInt(in.readLine());
			if(num == 0) {	//�迭���� ���� �������� ���, ����
				if(pq.isEmpty()) out.write("0");
				else out.write(Integer.toString(pq.poll()));
				out.newLine();
				
			}else {	//�迭�� �ִ´�
				pq.add(num);
			}
		}
		out.flush();
		out.close();

	}
}
