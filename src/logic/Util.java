package logic;

public class Util {
	public static void swap(int[] a, int i, int j)
	{
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}
}
