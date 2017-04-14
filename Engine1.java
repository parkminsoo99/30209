import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Engine1 {
   Scanner scan = new Scanner(System.in);
   String filePath = "c:\\test\\book.txt";

   public void displayMenu() {
      System.out.println("");
      System.out.println("���� ���� ���α׷η��Դϴ�.");
      System.out.println("1. ��ü ��� ���");
      System.out.println("2. ���� �˻�");
      System.out.println("3. �ű� ���� �߰�");
      System.out.println("4. ���� ���� ���");
      System.out.println("5. �� �˻�");
      System.out.println("0. ���α׷� ����");
   }

   int InputChoice() {
      int choice = -1;
      System.out.print("�޴��� �����ϼ���. : ");
      choice = scan.nextInt();
      scan.nextLine();
      System.out.println();
      return choice;
   }

   int InputChoice1() {
      int choice = -1;
      System.out.print("�󼼰˻� �޴��� �����ϼ���. : ");
      choice = scan.nextInt();
      scan.nextLine();
      System.out.println();
      return choice;
   }

   public void printBooks() throws FileNotFoundException {

      int count = 1;
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String str = "";

      try {
         while ((str = br.readLine()) != null) {
            System.out.println("(" + count + ")" + str);
            count++;
         }
         br.close();
      } catch (IOException e) {
         System.out.println("å ������ �о� �� �� �����ϴ�.");
         System.out.println("����� ������ ã�� �� �����ϴ�.");
         e.printStackTrace();
      }
   }

   public void deleteBook() throws IOException {
      String n = filePath + ".n";
      int count = 1;
      System.out.print("������ å ��ȣ�� �Է��� �ּ��� :");
      int deletebooknumber = scan.nextInt();

      System.out.println("å ��ȣ : " + deletebooknumber);
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      BufferedWriter bw = new BufferedWriter(new FileWriter(n, false));
      String str = "";
      while ((str = br.readLine()) != null) {
         if (count != deletebooknumber) {
            bw.write(str);
            bw.write("\r\n");
         }
         count++;
      }
      bw.close();
      br.close();
      FileInputStream fis = new FileInputStream(n);
      FileOutputStream fos = new FileOutputStream(filePath);

      int data = 0;
      while ((data = fis.read()) != -1) {
         fos.write(data);
      }
      fis.close();
      fos.close();
      File f = new File(n);
      f.deleteOnExit();
   }

   public void insertBook() throws IOException {
		book1 b = new book1();
		int a=-1;
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
		System.out.println("�߰� �� å�� ������ �Է��ϼ���.");
		System.out.print("å �̸� : ");
		b.setName(scan.nextLine());
		System.out.print("�� �� : ");
		b.setAuthor(scan.nextLine());
		System.out.print("���ǻ� : ");
		b.setPublisher(scan.nextLine());
		System.out.print("�� �� : ");
		b.setPrice(scan.nextLine());
		System.out.println(b.toString());
		bw.write(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPublisher() + "\t" + b.getPrice());
		System.out.println("����� �Է��ϼ̽��ϱ�? ");
		System.out.println("1.����� �Է��߽��ϴ�.");
		System.out.println("2.�ٽ��Է��ϰڽ��ϴ�. ");
		a = scan.nextInt();
			switch (a) {
			case 1:
				bw.newLine();
				bw.close();
				break;
			case 2:
				insertBook1();
				break;
			default:
				System.out.println("�ٽ� �Է����ּ���");
			}
	}
	public void insertBook1() throws IOException {
		book1 b = new book1();
		int a=-1;
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
		System.out.println("�߰� �� å�� ������ �Է��ϼ���.");
		System.out.print("å �̸� : ");
		b.setName(scan.nextLine());
		b.setName(scan.nextLine());
		System.out.print("�� �� : ");
		b.setAuthor(scan.nextLine());
		System.out.print("���ǻ� : ");
		b.setPublisher(scan.nextLine());
		System.out.print("�� �� : ");
		b.setPrice(scan.nextLine());
		System.out.println(b.toString());
		bw.write(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPublisher() + "\t" + b.getPrice());
		System.out.println("����� �Է��ϼ̽��ϱ�? ");
		System.out.println("1.����� �Է��߽��ϴ�.");
		System.out.println("2.�ٽ� �Է��ϰڽ��ϴ�. ");
		a = scan.nextInt();
		switch (a) {
		case 1:
			bw.newLine();
			bw.close();
			break;
		case 2:
			insertBook1();
			break;
		default:
			System.out.println("�ٽ� �Է����ּ���");
		}
}
   public void searchBook() throws FileNotFoundException {
	  int count=1;
      System.out.println("�˻��� Ű���带 �Է��ϼ���. : ");
      String keyword = scan.nextLine();
      String str = "";
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      try {
         while ((str = br.readLine()) != null) {

            if (str.contains(keyword)) {
               System.out.println("("+count+")"+str);
               count++;
            }
         }
         br.close();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   public void searchBook1() throws FileNotFoundException {
	   int count=1;
      int chi = -1;
      int Menuchi = 0;
      String str1 = "";
      BufferedReader br = new BufferedReader(new FileReader(filePath));   
      System.out.println("1. å �̸����� �˻��ϱ�");
      System.out.println("2. ���ڷ� �˻��ϱ�");
      System.out.println("3. �������� �˻��ϱ�");
      System.out.println("0. �޴��� ���ư���");
      while (chi != 0) {
         chi = InputChoice1();
         switch (chi) {
         case 1:
            Menuchi = 0;
            break;
         case 2:
            Menuchi = 1;
            break;
         case 3:
        	 searchBook();
        	 break;
         case 0:
        	 displayMenu();
        	 InputChoice1();
            break;
         default:
            System.out.println("�ٽ� �Է����ּ���");
         }
      System.out.println("�˻��� Ű���带 �Է��ϼ���. : ");
      String keyword = scan.nextLine();
      System.out.println(keyword);
      try {
         while ((str1 = br.readLine()) != null) {
            String ary[] = str1.split("\t");
            if (ary[Menuchi].contains(keyword)) {
            	System.out.println("("+count+")"+str1);
            	count++;
            }
         }
         br.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   
      }
   }
}