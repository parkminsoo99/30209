import java.io.IOException;

public class Main {
   
   public static void main(String[] args) throws IOException {
      Engine1 e = new Engine1();
      int choice = -1;
      while (choice != 0) {
         e.displayMenu();
         choice = e.InputChoice();
         switch (choice) {
         case 1:
            e.printBooks();
            break;
         case 2:
            e.searchBook();
            break;
         case 3:
            e.insertBook();
            break;
         case 4:
            e.deleteBook();
            break;
         case 5:
            e.searchBook1();
         case 0:
            System.out.println("종료 합니다.");
            System.exit(0);
            break;
         default:
            System.out.println("다시 입력해주세요");
         }
      }
   }
}