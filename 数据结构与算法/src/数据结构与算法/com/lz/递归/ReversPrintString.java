package 数据结构与算法.com.lz.递归;

// 反向打印字符串
public class ReversPrintString {

	public static String f(int n, String str) {
//		if(n < str.length()) {
//			return  f(n+1, str) + str.charAt(n);
//		}
//		return "";
		return f(n+1, str);
	}
	
	public static void main(String[] args) {
		int n = 0;
		String str = "abcde";
		System.out.println(f(n, str));
	}
	
}
