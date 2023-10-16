//package pro;
//
//class UserSolution
//{
//	public class Node {
//		int id;
//		int v;
//		Node next;
//
//		public Node() {
//		}
//
//		public Node(int id, int v) {
//			super();
//			this.id = id;
//			this.v = v;
//		}
//
//		public Node(int id, int v, Node next) {
//			super();
//			this.id = id;
//			this.v = v;
//			this.next = next;
//		}
//	}
//	public Node[] node = new Node[200055];
//	public int cnt = 0;
//	public int[] version = new int[100055];
//	public int[] num = new int[100055];
//
//	public Node getNewNode(int id, Node next) {
//		Node newNode = node[cnt++];
//		newNode.id = id;
//		newNode.next = next;
//		newNode.v = ++version[id];
//		return newNode;
//	}
//
//	public class Team {
//		Node[] head = new Node[6];
//		Node[] tail = new Node[6];
//	}
//
//	public Team[] t = new Team[6];
//
//	public void init(){
//		cnt = 0;
//		for (int i = 0; i < 200055; i++) {
//			node[i] = new Node();
//		}
//		for (int i = 1; i <= 5; i++) {
//			t[i] = new Team();
//			for (int j = 1; j <= 5; j++) {
//				t[i].tail[j] = t[i].head[j] = getNewNode(0, null);
//			}
//		}
//		for (int i = 0; i <= 100000; i++) {
//			version[i] = 0;
//			num[i] = 0;
//		}
//	}
//
//	public void hire(int mID, int mTeam, int mScore){
//		Node newNode = getNewNode(mID, null);
//		t[mTeam].tail[mScore].next = newNode;
//		t[mTeam].tail[mScore] = newNode;
//		num[mID] = mTeam;
//	}
//
//	public void fire(int mID){
//		version[mID] = -1;
//	}
//
//	public void updateSoldier(int mID, int mScore){
//		hire(mID, num[mID], mScore);
//	}
//
//	public void updateTeam(int mTeam, int mChangeScore){
//		if(mChangeScore < 0) {
//			for (int i = 1; i <= 5; i++) {
//				int k = i + mChangeScore;
//				k = k < 1 ? 1 : (k > 5 ? 5 : k);
//				if(i == k) continue;
//
//				if(t[mTeam].head[i].next == null) continue;
//				t[mTeam].tail[k].next = t[mTeam].head[i].next;
//				t[mTeam].tail[k] = t[mTeam].tail[i];
//				t[mTeam].head[i].next = null;
//				t[mTeam].tail[i] = t[mTeam].head[i];
//			}
//		}
//		if(mChangeScore > 0) {
//			for (int i = 5; i >= 1; i--) {
//				int k = i + mChangeScore;
//				k = k < 1 ? 1 : (k > 5 ? 5 : k);
//
//				if(i == k) continue;
//
//				if(t[mTeam].head[i].next == null) continue;
//				t[mTeam].tail[k].next = t[mTeam].head[i].next;
//				t[mTeam].tail[k] = t[mTeam].tail[i];
//				t[mTeam].head[i].next = null;
//				t[mTeam].tail[i] = t[mTeam].head[i];
//			}
//		}
//	}
//
//	public int bestSoldier(int mTeam) {
//		for (int i = 5; i >= 1; i--) {
//			Node node = t[mTeam].head[i].next;
//			if(node == null) continue;
//
//			int ans = 0;
//			while(node != null) {
//				if(node.v == version[node.id]) {
//					ans = Math.max(ans, node.id);
//				}
//				node = node.next;
//			}
//			if (ans != 0) return ans;
//		}
//		return 0;
//	}
//}