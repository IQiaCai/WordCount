import java.io.*;
import java.util.*;
public class WordCount {
	public static void main(String[] args){
		FileOper fileoper=new FileOper();
		fileoper.Scan();
	}
}
class FileOper{
	Scanner input=new Scanner(System.in);
	public void Scan() {
		String oper = input.next();
		String path = input.next();
		if(oper.equals("-c")) {
			System.out.printf("字符数：%d",this.cCount(path));
		}
		else if(oper.equals("-w")) {
			System.out.printf("单词数：%d",this.wCount(path));
		}
	}
	public int cCount(String path) {
		int count=0;
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("文件不存在");
			System.exit(0);
		}
		FileReader f=null;
		BufferedReader f1=null;
		try {
			f=new FileReader(file);
			f1=new BufferedReader(f);
			while(f1.read()!=-1) {
				count++;
			}
			f1.close();
			f.close();
		} catch (Exception e) {
			//TODO Auto-generated catch block
			System.out.println(e);
		}
		return count;
	}
	public int wCount(String path) {
		int count=0;
		File file = new File(path);
		if(!file.exists()) {
			System.out.println("文件不存在");
			System.exit(0);
		}
		FileReader f=null;
		BufferedReader f1=null;
		try {
			f=new FileReader(file);
			f1=new BufferedReader(f);
			String str;
			while((str=f1.readLine())!=null) {
				String[] strs=str.split("[, ]");
				count+=strs.length;
			}
			f1.close();
			f.close();
		} catch (Exception e) {
			//TODO Auto-generated catch block
			System.out.println(e);
		}
		return count;
	}
}