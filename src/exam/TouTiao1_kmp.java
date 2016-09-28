package exam;
import java.util.Scanner;

/* String Shifting
 * 定义字符串的shift操作为：shift("ABCD", 0) = "ABCD", shift("ABCD", 1) = "BCDA", ...（注：即循环左移）。如果shift(string, x) = string, 称为一次匹配，其中0<=x<n.
 * 输入：一个字符串
 * 输出：对其执行[0, n)次shift操作，能出现匹配的次数
 */
public class TouTiao1_kmp {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int L = str.length();
		StringBuilder sb = new StringBuilder(str);
		sb.append(str);
		
		int count = 0;
		for (int i = 1; i < L; ) {
			int pos = kmp(sb.substring(i), str);
			if (pos != -1 && pos < L) {	// !
				count++;
				i += i + pos + 1;	// i的增量
			} else {
				break;
			}
		}
		
		System.out.println(count);
		
		sc.close();
	}

	private static int kmp(String str, String pat) {
		int i = 0, j = 0;
		int sLen = str.length();
		int pLen = pat.length();
		int[] next = new int[pLen];
		
		getNext(pat, next);
		
		while (i < sLen && j < pLen) {
			if (str.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			} else {
				if (next[j] == -1) {
					i++;
					j = 0;
				} else {
					j = next[j];
				}
			}
			
			if (j == pLen) {
				return i - j;
			}
		}
			
		return -1;
	}

	private static void getNext(String pat, int[] next) {
		int j = 0;
		int k = -1;
		int len = pat.length();
		next[0] = -1;
		
		while (j < len - 1) {
			if (k == -1 || pat.charAt(k) == pat.charAt(j)) {
				j++;
				k++;
				next[j] = k;
			} else {
				k = next[k];
			}
		}
	}
}

/* Hodor的C++代码

#include<cstring>
#include<cstdio>

using namespace std;

#define eps 1e-8
#define inf 0x7f3f3f3f
#define debug puts("BUG")

#define read freopen("in","r",stdin)
#define N 1000010

char s[N];
int next[N];
void get_next(char *substr, int sublen)
{
    next[0] = -1;
    for(int i=1,j=-1;i<sublen;i++)
    {
        while(j>-1&&substr[j+1]!=substr[i])j=next[j] ;
        if(substr[j+1]==substr[i])j++;
        next[i]=j;
    }
}
int main()
{
    //read;
    while (~scanf("%s",s))
    {
        int l = (int) strlen(s);
        get_next(s,l);
        int t = l-1-next[l-1];
        if (l%t == 0) printf("%d\n",l/t);
        else printf("1\n");
    }
    return 0;
}
*/