package ra.dev;

import java.util.Scanner;

public class Main {

   static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.println("\n+-----------------------------------------------------+");
            System.out.println("|                     QUẢN LÝ CỬA HÀNG                |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|                 1. Quản lý danh mục.                |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|                 2. Quản lý sản phẩm.                |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|                 3. Thoát (Thoát khỏi ứng dụng).     |");
            System.out.println("+-----------------------------------------------------+\n");
            System.out.print("LỰA CHỌN CỦA BẠN LÀ: ");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    Menu.displayMenu1();
                    break;
                case 2:
                    Menu.displayMenu2();
                    break;
                case 3:
                    System.exit(0);
            }
        }while (true);
    }
}

