package ra.dev;

import java.util.Scanner;

public class Menu {
    static Catalog[] listCatalog = new Catalog[100];
    static int indexCatalog = 0;
    static Product[] listProduct = new Product[1000];
    static int indexProduct = 0;
    static Scanner sc = new Scanner(System.in);

    //****************************QUẢN LÝ DANH MỤC******************************
    public static void displayMenu1() {
        do {
            System.out.println("\n+-----------------------------------------------------+");
            System.out.println("|                  QUẢN LÝ DANH MỤC                   |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    1. Nhập thông tin n danh mục.                    |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    2. Hiển thị thông tin danh mục theo độ ưu tiên.  |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    3. Cập nhật thông tin danh mục theo ID.          |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    4. Thoát (Trở lại menu Quản lý cửa hàng).        |");
            System.out.println("+-----------------------------------------------------+\n");
            System.out.print("LỰA CHỌN CỦA BẠN LÀ: ");
            int choiceCatalog = Integer.parseInt(sc.nextLine());
            switch (choiceCatalog) {
                case 1:
                    addCatalog(sc);
                    break;
                case 2:
                    showListCatalog();
                    break;
                case 3:
                    editListCatalog();
                    break;
                case 4:
                    return;
                default:
                    System.out.println(" Vui lòng chọn trong khoảng 1-4");
            }
        } while (true);
    }

    // ---------------------thêm danh mục-------------------
    public static void addCatalog(Scanner sc) {
        System.out.print("Nhập số lượng catalog muốn thêm: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Catalog: " + (i + 1));
            listCatalog[indexCatalog] = new Catalog();
            listCatalog[indexCatalog].inputData();
            indexCatalog++;
            System.out.println("Thêm thành công!");
        }
    }

    //-------------------sắp xếp theo mức độ ưu tiên----------------------
    public static void showListCatalog() {
        System.out.println("Hiện tại có " + indexCatalog + " danh mục.");
        Catalog temp;
        for (int i = 0; i < indexCatalog - 1; i++) {
            for (int j = i + 1; j < indexCatalog; j++) {
                if (listCatalog[i].getPriority() > listCatalog[j].getPriority()) {
                    temp = listCatalog[i];
                    listCatalog[i] = listCatalog[j];
                    listCatalog[j] = temp;
                }
            }
        }
        System.out.println("+------------------------------------------------------------------+");
        System.out.printf("%-16s%-20s%-15s%-10s\n", "|   CatalogId", "|    CatalogName", "|   Priority", "| CatalogStatus |");
        for (int i = 0; i < indexCatalog; i++) {
            listCatalog[i].displayData();
        }
        System.out.println("+------------------------------------------------------------------+\n\n\n");
    }

    //-----------------------Cập nhập thông tin theo mã danh mục---------------------
    public static void editListCatalog() {
        if (indexCatalog == 0) {
            System.err.println("Vui lòng tạo danh mục sản phẩm trước khi chỉnh sửa. ");
        } else {
            System.out.print("Nhập mã Id muốn cập nhập: ");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < indexCatalog; i++) {
                if (listCatalog[i].getCatalogId() == n) {
                    System.out.print("Tên cũ: \"" + listCatalog[i].getCatalogName() + "\"; Tên mới : ");
                    listCatalog[i].setCatalogName(sc.nextLine());
                    System.out.print("Mức độ ưu tiên cũ: \"" + listCatalog[i].getPriority() + "\"; Mức độ mới : ");
                    listCatalog[i].setPriority(Integer.parseInt(sc.nextLine()));
                    System.out.print("Trạng thái cũ: \"" + listCatalog[i].isCatalogStatus() + "\"; Trạng thái mới : ");
                    listCatalog[i].setCatalogStatus(Boolean.parseBoolean(sc.nextLine()));
                    System.out.println("Cập nhập thành công!");
                }
            }
        }
    }

    //********************QUẢN LÝ SẢN PHẨM*****************
    public static void displayMenu2() {
        do {
            System.out.println("\n+-----------------------------------------------------+");
            System.out.println("|                  QUẢN LÝ SẢN PHẨM                   |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    1. Nhập thông tin cho n sản phẩm.                |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    2. Tính giá bán cho tất cả sản phẩm.             |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    3. Hiển thị thông tin các sản phẩm.              |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    4. Sắp xếp sản phẩm theo giá bán tăng dần.       |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    5. Tìm kiếm sản phẩm theo tên sản phẩm.          |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    6. Thống kê sản phẩm sắp hết hàng (quantity<=5). |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    7. Cập nhật trạng thái của sản phẩm theo Id.     |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    8. Bán hàng.                                     |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    9. Nhập hàng.                                    |");
            System.out.println("+-----------------------------------------------------+");
            System.out.println("|    10. Thoát (Trở lại menu Quản lý cửa hàng).       |");
            System.out.println("+-----------------------------------------------------+\n");
            System.out.print("LỰA CHỌN CỦA BẠN LÀ: ");
            int choiceCase2 = Integer.parseInt(sc.nextLine());
            switch (choiceCase2) {
                case 1:
                    addProduct(sc);
                    break;
                case 2:
                    calExportPriceListProduct();
                    break;
                case 3:
                    showListproduct();
                    break;
                case 4:
                    sortlistProduct();
                    break;
                case 5:
                    searchListproduct();
                    break;
                case 6:
                    countlistProduct();
                    break;
                case 7:
                    updateProductStatus();
                    break;
                case 8:
                    SaleProduct();
                    break;
                case 9:
                    break;
                case 10:
                    return;
                default:
                    System.out.println(" Vui lòng chọn trong khoảng 1-10");

            }
        } while (true);
    }

    //---------------------- add them san pham vao list----------------------
    public static void addProduct(Scanner sc) {
        if (indexCatalog == 0) {
            System.out.println("Vui lòng tạo danh mục sản phẩm trước khi thêm sản phẩm. ");
        } else {
            System.out.println("\n+----------------------------------------+");
            System.out.printf("%-20s %-20s\n", "|     CatalogId", "|    CatalogName    |");
            System.out.println("+----------------------------------------+");
            for (int i = 0; i < indexCatalog; i++) {
                System.out.printf("|          %-10d|    %-15s|\n", listCatalog[i].getCatalogId(), listCatalog[i].getCatalogName());
            }
            System.out.println("+----------------------------------------+\n");

            System.out.println("Nhập ID của catalog muốn thêm sản phẩm: ");
            int idinput = Integer.parseInt(sc.nextLine());
            boolean checkpoint = true;
            for (int i = 0; i < indexCatalog; i++) {
                if (listCatalog[i].getCatalogId() == idinput) {
                    System.out.print("Nhập số lượng sản phẩm muốn thêm vào danh mục \"" + listCatalog[i].getCatalogName() + "\": ");
                    int count = Integer.parseInt(sc.nextLine());
                    for (int j = 0; j < count; j++) {
                        System.out.println("Nhập thông tin của sản phẩm " + (j + 1));
                        listProduct[indexProduct] = new Product();
                        listProduct[indexProduct].inputData();
                        listProduct[indexProduct].setCatalog(listCatalog[i]);
                        indexProduct++;
                    }
                } else {
                    checkpoint = false;
                }
            }
            if (!checkpoint) {
                System.out.println("catalog với Id " + idinput + " chưa được khởi tạo!\nVui lòng khởi tạo catalog với Id mới hoặc chọn catalog với Id đã tồn tại.");
            }
        }
    }

    //-----------------------tinh gia cho cac san pham-------------------------
    public static void calExportPriceListProduct() {
        if (indexProduct == 0) {
            System.out.println("Vui lòng thêm sản phẩm trước khi tính giá.");
        } else {
            for (int i = 0; i < indexProduct; i++) {
                listProduct[i].calExportPrice();
            }
            System.out.println("Đã tính xong giá cho các sản phẩm.");
        }
    }

    //------------------------hien thi cac san pham---------------------------------
    public static void showListproduct() {
        System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|   %-12s|     %-15s|     %-10s|  %-13s|  %-13s| %-9s|    %-16s| %-14s|    %-11s|\n", "ProductId", "ProductName", "Title", "ImportPrice",
                "ExportPrice", "Quantity", "Descriptions", "ProductStatus", "Catalog");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");

        for (int i = 0; i < indexProduct; i++) {
            listProduct[i].displayData();
        }
    }

    //--------------------sap xep theo gia ban tang dan---------------------------------
    public static void sortlistProduct() {
        if (indexProduct == 0) {
            System.out.println("Vui lòng thêm sản phẩm trước khi sắp xếp.");
        } else {
            Product temp;
            for (int i = 0; i < indexProduct - 1; i++) {
                for (int j = i + 1; j < indexProduct; j++) {
                    if (listProduct[i].getExportPrice() > listProduct[j].getExportPrice()) {
                        temp = listProduct[i];
                        listProduct[i] = listProduct[j];
                        listProduct[j] = temp;
                    }
                }
            }
            System.out.println("Đã sắp xếp xong!");
        }
    }

    //--------------Tìm kiếm sản phẩm theo tên sản phẩm------------------------------------
    public static void searchListproduct() {
        int count = 0;
        System.out.print("Nhập tên sản phẩm muốn tìm kiếm: ");
        String inputSearch = sc.nextLine();
        System.out.println("\n+----------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|   %-12s|     %-15s|     %-10s|  %-13s|  %-13s| %-9s|    %-16s| %-14s|    %-11s|\n", "ProductId", "ProductName", "Title", "ImportPrice",
                "ExportPrice", "Quantity", "Descriptions", "ProductStatus", "Catalog");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------+");

        for (int i = 0; i < indexProduct; i++) {
            if (listProduct[i].getProductName().startsWith(inputSearch)) {
                listProduct[i].displayData();
                count++;
            }
        }
        System.out.println("Tìm thấy " + count + " sản phẩm.");

    }

    //------------------Thống kê số lượng và in thông tin các sản phẩm sắp hết hàng (quantity<=5)-------------
    public static void countlistProduct() {
        int count = 0;
        System.out.printf("%-15s%-20s%-15s%-15s%-15s%-10s%-20s%-15s%-15s\n", "ProductId", "ProductName", "Title", "ImportPrice",
                "ExportPrice", "Quantity", "Descriptions", "ProductStatus", "Catalog");
        for (int i = 0; i < indexProduct; i++) {
            if (listProduct[i].getQuantity() <= 5) {
                listProduct[i].displayData();
                count++;
            }
        }
        System.out.println(" số lượng sản phẩm sắp hết hàng là: " + count);
    }

    //---------------Cập nhật trạng thái của sản phẩm theo mã sản phẩm--------------------------
    public static void updateProductStatus() {
        System.out.println("Nhập Id sản phẩm muốn update: ");
        String inputID = sc.nextLine();
        boolean checkpoint = false;
        for (int i = 0; i < indexProduct; i++) {
            if (listProduct[i].getProductId().equals(inputID)) {
                listProduct[i].setProductStatus(!listProduct[i].isProductStatus());
                System.out.println("Đã cập nhập trạng thái thành công !");
                checkpoint = false;
                break;
            } else {
                checkpoint = true;
            }
        }
        if (checkpoint) {
            System.out.println("Id không tồn tại.");
        }

    }
    //-------------------------- ban san pham---------------------------------------
public static void SaleProduct(){
    System.out.println("Nhập tên sản phẩm muốn bán: ");
    String inputName= sc.nextLine();
    for (int i = 0; i <indexProduct; i++) {
        if (listProduct[i].getProductName().equals(inputName)){
            System.out.println("Nhập số lượng sản phẩm muốn bán: ");
            int inputQuatity=Integer.parseInt(sc.nextLine());
            while (inputQuatity<0|| inputQuatity>listProduct[i].getQuantity()){
                System.out.println("Nhập sai số lượng, vui lòng nhập trong khoảng \"1- "+listProduct[i].getQuantity()+"\":");
                 inputQuatity=Integer.parseInt(sc.nextLine());
            }
            listProduct[i].setQuantity(listProduct[i].getQuantity()-inputQuatity);
            break;
        }else {
            System.out.println("Vui lòng chọn lại. ");
            Menu.SaleProduct();
            break;
        }
    }
}
//------check vali rong-------------------------
//    public static void checkVali(){
//        String inputvalue = sc.nextLine();
//        while (inputvalue.trim().length()==0) {
//            System.err.print("Không được để trống, hãy nhập lại: ");
//            inputvalue = sc.nextLine();
//        }
//    }
}
