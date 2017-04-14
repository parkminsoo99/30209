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
      System.out.println("도서 관리 프로그로램입니다.");
      System.out.println("1. 전체 목록 출력");
      System.out.println("2. 도서 검색");
      System.out.println("3. 신규 도서 추가");
      System.out.println("4. 노후 도서 폐기");
      System.out.println("5. 상세 검색");
      System.out.println("0. 프로그램 종료");
   }

   int InputChoice() {
      int choice = -1;
      System.out.print("메뉴를 선택하세요. : ");
      choice = scan.nextInt();
      scan.nextLine();
      System.out.println();
      return choice;
   }

   int InputChoice1() {
      int choice = -1;
      System.out.print("상세검색 메뉴를 선택하세요. : ");
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
         System.out.println("책 정보를 읽어 올 수 없습니다.");
         System.out.println("저장된 파일을 찾을 수 없습니다.");
         e.printStackTrace();
      }
   }

   public void deleteBook() throws IOException {
      String n = filePath + ".n";
      int count = 1;
      System.out.print("삭제할 책 번호를 입력해 주세요 :");
      int deletebooknumber = scan.nextInt();

      System.out.println("책 번호 : " + deletebooknumber);
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
		System.out.println("추가 할 책의 정보를 입력하세요.");
		System.out.print("책 이름 : ");
		b.setName(scan.nextLine());
		System.out.print("저 자 : ");
		b.setAuthor(scan.nextLine());
		System.out.print("출판사 : ");
		b.setPublisher(scan.nextLine());
		System.out.print("가 격 : ");
		b.setPrice(scan.nextLine());
		System.out.println(b.toString());
		bw.write(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPublisher() + "\t" + b.getPrice());
		System.out.println("제대로 입력하셨습니까? ");
		System.out.println("1.제대로 입력했습니다.");
		System.out.println("2.다시입력하겠습니다. ");
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
				System.out.println("다시 입력해주세요");
			}
	}
	public void insertBook1() throws IOException {
		book1 b = new book1();
		int a=-1;
		BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
		System.out.println("추가 할 책의 정보를 입력하세요.");
		System.out.print("책 이름 : ");
		b.setName(scan.nextLine());
		b.setName(scan.nextLine());
		System.out.print("저 자 : ");
		b.setAuthor(scan.nextLine());
		System.out.print("출판사 : ");
		b.setPublisher(scan.nextLine());
		System.out.print("가 격 : ");
		b.setPrice(scan.nextLine());
		System.out.println(b.toString());
		bw.write(b.getName() + "\t" + b.getAuthor() + "\t" + b.getPublisher() + "\t" + b.getPrice());
		System.out.println("제대로 입력하셨습니까? ");
		System.out.println("1.제대로 입력했습니다.");
		System.out.println("2.다시 입력하겠습니다. ");
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
			System.out.println("다시 입력해주세요");
		}
}
   public void searchBook() throws FileNotFoundException {
	  int count=1;
      System.out.println("검색할 키워드를 입력하세요. : ");
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
      System.out.println("1. 책 이름으로 검색하기");
      System.out.println("2. 저자로 검색하기");
      System.out.println("3. 통합으로 검색하기");
      System.out.println("0. 메뉴로 돌아가기");
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
            System.out.println("다시 입력해주세요");
         }
      System.out.println("검색할 키워드를 입력하세요. : ");
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