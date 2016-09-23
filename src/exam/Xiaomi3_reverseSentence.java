package exam;

import java.util.Scanner;

// 把一个句子中的单词倒序输出（Easy）
public class Xiaomi3_reverseSentence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        while (in.hasNext()) {
        	result = new StringBuilder();
        	String sentence = in.nextLine();
        	String[] words = sentence.split(" ");
        	for (int i = words.length - 1; i >= 0; i--) {
        		result.append(words[i]);
        		if (i > 0) {
        			result.append(" ");
        		}
        	}
        }
        
        System.out.println(result);

        in.close();
    }

}
