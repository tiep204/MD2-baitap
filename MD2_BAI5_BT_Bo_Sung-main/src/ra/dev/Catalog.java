package ra.dev;

import java.util.Scanner;

public class Catalog {
    public int catalogId;
    public String catalogName;
    public int priority;
    public boolean catalogStatus;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, int priority, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.priority = priority;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Mã danh Mục: ");
        String inputCatalogID = sc.nextLine();
        while (inputCatalogID.trim().length()==0) {
            System.err.print("Mã Id không được để trống, hãy nhập lại Id: ");
            inputCatalogID = sc.nextLine();
        }
        this.catalogId = Integer.parseInt(inputCatalogID);
        if (Menu.indexCatalog != 0) {
            boolean checkpoint = true;
            while (checkpoint) {
                for (int i = 0; i <= Menu.indexCatalog; i++) {
                    if (Integer.parseInt(inputCatalogID) == Menu.listCatalog[i].getCatalogId()) {
                        System.err.println("Id đã tồn tại hoặc trống, hãy nhập id mới: ");
                        inputCatalogID = sc.nextLine();
                        this.catalogId=Integer.parseInt(inputCatalogID);
                        break;
                    } else {
                        checkpoint = false;
                        break;
                    }
                }
            }
        }
        System.out.print("Tên danh mục: ");
        this.catalogName = sc.nextLine();
        while (this.catalogName.trim().length()==0) {
            System.err.print("Tên không được để trống, hãy nhập lại : ");
            this.catalogName = sc.nextLine();
        }
        if (Menu.indexCatalog != 0) {
            boolean checkpoint1 = true;
            while (checkpoint1) {
                for (int i = 0; i < Menu.indexCatalog; i++) {
                    if (Menu.listCatalog[i].getCatalogName().equals(this.catalogName)|| this.catalogName.trim().length()==0) {
                        System.err.println("Tên danh mục bị trống hoặc đã tồn tại, hãy nhập tên mới: ");
                        this.catalogName = sc.nextLine();
                        break;
                    } else {
                        checkpoint1 = false;
                    }
                }
            }
        }

        System.out.print("Độ ưu tiên của danh mục: ");
        this.priority = Integer.parseInt(sc.nextLine());
        System.out.print("Trạng thái danh mục: ");
        this.catalogStatus = Boolean.parseBoolean(sc.nextLine());
    }

    public void displayData() {
        System.out.println("+------------------------------------------------------------------+");
        System.out.printf("| %-14d| %-18s| %-13d| %-14b|\n", this.catalogId, this.catalogName, this.priority, this.catalogStatus);
    }
}
