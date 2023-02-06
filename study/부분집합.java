package study;

public class 부분집합 {
	static int[] arr = {1,2,3,4,5};
    public static void main(String[] args) {
        powerset(0, new boolean[arr.length]);
    }
    
    static void powerset(int idx, boolean[] sel) {
        if(idx == arr.length) {          
            for(int i=0; i<sel.length; i++) {
                if(sel[i]) {
                	System.out.print(arr[i]+" ");                	
                }
            }System.out.println();
            return;
        }     
        sel[idx]=true;
        powerset(idx+1, sel);
        sel[idx]=false;
        powerset(idx+1, sel);
    }
    
}
