package b_lecture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1230_암호문3ByLinkedList {
	static int NODE_MAX = 5000;
	
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static class LinkedList {
		Node head;
		Node tail;
		Node[] nodeArr;
		int nodeCnt;
		
		public LinkedList() {
			head = null;
			nodeArr = new Node[NODE_MAX];
			nodeCnt = 0;
		}
		
		Node getNewNode(int data) {
			nodeArr[nodeCnt] = new Node(data);
			return nodeArr[nodeCnt++];
		}
		
		void insert(int idx, int[] nums) {
			int st = 0;
			if(idx == 0) { // 맨 앞에 삽입해야 하는경우
				// 첫 숫자만 하나 넣어놓는다.
				if(head != null) {
					Node newNode = getNewNode(nums[0]);
					newNode.next = head;
					head = newNode;					
				} else {
					head = getNewNode(nums[0]);
				}
				// 하나 넣어놨으니 이동
				idx = 1;
				st = 1;
			}
			Node cur = head;
			for (int i = 1; i < idx; i++) {
				cur = cur.next;
			}
			
			for (int i = st; i < nums.length; i++) {
				Node newNode = getNewNode(nums[i]);
				newNode.next = cur.next;
				cur.next = newNode;
				cur = cur.next;
			}
			if(cur.next == null) {
				tail = cur;
			}
		}
		
		void delete(int idx, int cnt) {
			Node cur = head;
			if(idx == 0) { // head를 지우는 경우
				for (int i = 0; i < cnt; i++) {
					cur = cur.next;
				}
				head = cur;
				return;
			}
			for (int i = 1; i < idx; i++) {
				cur = cur.next;
			}
			Node prevNode = cur;
			for (int i = 0; i < cnt; i++) {
				cur = cur.next;
			}
			prevNode.next = cur.next;
			if(prevNode.next == null) {
				tail = prevNode;
			}
		}
		
		void add(int data) {
			Node cur = tail;
			Node newNode = getNewNode(data);
			cur.next = newNode;
			tail = newNode;
		}
		
		void print() {
			Node cur = head;
			int cnt = 0;
			while(cnt++ < 10) {
				System.out.print(cur.data+" ");
				cur = cur.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			LinkedList list = new LinkedList();
			int N = Integer.parseInt(br.readLine());
			int[] inputArr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				inputArr[i] = Integer.parseInt(st.nextToken());
			}
			list.insert(0, inputArr);
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				char command = st.nextToken().charAt(0);
				int x, y;
				switch(command) {
					case 'I':
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						int[] tmpArr = new int[y];
						for (int j = 0; j < y; j++) {
							tmpArr[j] = Integer.parseInt(st.nextToken());
						}
						list.insert(x, tmpArr);
						break;
					case 'D':
						x = Integer.parseInt(st.nextToken());
						y = Integer.parseInt(st.nextToken());
						list.delete(x, y);
						break;
					case 'A':
						y = Integer.parseInt(st.nextToken());
						for (int j = 0; j < y; j++) {
							list.add(Integer.parseInt(st.nextToken()));
						}
						break;
				}
			}
			System.out.print("#"+tc+" ");
			list.print();
		}
	}
}
