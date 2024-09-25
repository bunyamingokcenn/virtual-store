import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Management {
    Scanner scan = new Scanner(System.in);

    //Markalar listesi
    TreeSet<Brand> brands = new TreeSet<>(new OrderBrandComparator());

    //Notebook listesi
    ArrayList<Notebook> notebooks = new ArrayList<>();

    //Telefon listesi
    ArrayList<Phone> phones = new ArrayList<>();


    //Yönetimi başlatmak için
    public void start(){
        //Markaları ekleme
        brands.add(new Brand("Samsung"));
        brands.add(new Brand("Lenovo"));
        brands.add(new Brand("Apple"));
        brands.add(new Brand("Huawei"));
        brands.add(new Brand("Casper"));
        brands.add(new Brand("Asus"));
        brands.add(new Brand("HP"));
        brands.add(new Brand("Xiaomi"));
        brands.add(new Brand("Monster"));


        //Çıkış durumunu sorgula
        boolean isExit=false;

        while(!isExit){

            System.out.println();
            System.out.println("---------------------------------------------------");
            System.out.println();

            //İşlemleri Liste
            listOperations();

            int selectedChoice = scan.nextInt();

            while (selectedChoice < 0 || selectedChoice > 3){
                System.out.println("Hatalı giriş, yeniden seçiniz: ");
                selectedChoice = scan.nextInt();
            }

            switch (selectedChoice){
                case 1:
                    notebookOperations();
                    break;
                case 2:
                    phoneOperations();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("ID" + "\t" + "Marka Adı");
                    System.out.println("--" + "\t" + "---------");
                    for (Brand brand : brands){
                        System.out.println(brand.getId()+ "\t" + brand.getName());
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Çıkış Yap");
                    isExit = true;
                    break;
            }
        }
    }

    //Karşılama Mesajı
    public void greeting(){
        System.out.println();
        System.out.println("PatikaStore Ürün Yönetim Paneline Hoş Geldiniz!");
    }

    //Ana menü listele
    public void listOperations(){
        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Telefon İşlemleri");
        System.out.println("3 - Marka Listele");
        System.out.println("0 - ÇIKIŞ YAP");
        System.out.println();
        System.out.print("Tercihiniz: ");
    }

    //Notebook işlemleri menüsü
    public void notebookOperations() {

        int choice;
        do {


            System.out.println();
            System.out.println("----------------------------");
            System.out.println();
            System.out.println("1 - Notebook Listele\n" +
                    "2 - Notebook Ekle\n" +
                    "3 - Notebook Sil\n" +
                    "0 - Çıkış Yap");
            System.out.println();
            System.out.print("Lütfen yapmak istediğiniz işlemi seçin: ");

            choice = scan.nextInt();

            if (choice >= 0 && choice <= 3) {
                switch (choice) {
                    case 1:
                        listNotebooks();
                        break;
                    case 2:
                        addNotebook();
                        break;
                    case 3:
                        removeNotebook();
                        break;

                }
            }
        } while (choice != 0);

    }

    //Notebook listeleme
    public void listNotebooks(){

        if (notebooks.isEmpty()){
            System.out.println();
            System.out.println("Sistemde şuan Notebook yok!");
        }else{
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s%-34s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s\n", "| ID", "| Ürün Adı", "| Fiyat", "| Markası", "| Depolama", "| Ekran Boyutu", "| RAM", "| Stok", "| İndirim Oranı", "| Batarya(mAh)", "| Depolama Tipi |");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Notebook notebook : notebooks){
                System.out.printf("| %-2d | %-31s | %-14.2f | %-14s | %-14d | %-14s | %-14d | %-14d | %-14d | %-14d | %-14s|\n", notebook.getID(),
                        notebook.getName(),
                        notebook.getPrice(),
                        notebook.getBrand().getName(),
                        notebook.getMemory(),
                        notebook.getScreenSize(),
                        notebook.getRam(),
                        notebook.getStock(),
                        notebook.getDiscountRate(),
                        notebook.getBatteryPower(),
                        notebook.getStorageType());
            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }


    }

    //Notebook ekleme
    public void addNotebook(){
        System.out.println("Eklemek istediğiniz Notebok bilgilerini girin;");

        //Ürün adı
        System.out.print("Adı: ");
        scan.nextLine();
        String name = scan.nextLine();

        //Ürün fiyatı
        System.out.print("Fiyatı: ");
        double price = scan.nextDouble();

        //Marka seçme
        System.out.println("Markalar");
        System.out.println("----------");

        Brand selectedBrand = null;

        for (Brand brand : brands){
            System.out.println(brand.getId() + " - " + brand.getName());
        }

        System.out.println();
        System.out.print("Marka Seçin: ");
        int brandChoice = scan.nextInt();

        for (Brand brand : brands){
            if (brand.getId() == brandChoice){
                selectedBrand = brand;
            }
        }

        //Depolama boyutu
        System.out.print("Depolaması: ");
        int memory = scan.nextInt();

        //Ekran boyutu
        System.out.print("Ekran boyutu: ");
        String screenSize = scan.next();
        scan.nextLine();

        //RAM
        System.out.print("RAM'i: ");
        int ram = scan.nextInt();

        //Stok adedi
        System.out.print("Stok adedi: ");
        int stock = scan.nextInt();

        //İndirim oranı
        System.out.print("İndirim oranı: ");
        int discountRate = scan.nextInt();

        //Batarya boyutu
        System.out.print("Batarya(mAh): ");
        int batteryPower = scan.nextInt();

        //Depolama tipi
        System.out.print("Depolama tipi(SSD/HDD): ");
        String storageType = scan.next();


        notebooks.add(new Notebook(name, price, selectedBrand, memory, screenSize, ram, stock, discountRate, batteryPower, storageType));

        System.out.println();
        System.out.println("Eklediğiniz Notebook Bilgileri");
        System.out.println("-------------------------------");
        System.out.println("Adı: " + name + "\n" +
                "Fiyatı: " + price + "\n" +
                "Markası: " + selectedBrand.getName() + "\n" +
                "Depolaması: " + memory + "\n" +
                "Ekran Boyutu: " + screenSize + "\n" +
                "RAM: " + ram + "\n" +
                "Stok: " + stock + "\n" +
                "İndirim Oranı: " + discountRate + "\n" +
                "Batarya(mAh): " + batteryPower + "\n" +
                "Depolama Tipi: " + storageType + "\n" );

    }

    //Notebook silme
    public void removeNotebook(){
        listNotebooks();

        System.out.print("Silmek istediğiniz notebook id'sini giriniz: ");
        int removeNotebook = scan.nextInt();

        if (removeNotebook > 0 && removeNotebook <= notebooks.size()){
            notebooks.removeIf(notebook -> notebook.getID() == removeNotebook);
            System.out.println("ID numarası " + removeNotebook + " olan Notebook silindi");
        } else {
            System.out.println("Ürün bulunamadı! ");
        }
    }

    //Telefon işlemleri menüsü
    public void phoneOperations(){
        int choice;
        do {


            System.out.println();
            System.out.println("----------------------------");
            System.out.println();
            System.out.println("1 - Telefon Listele\n" +
                    "2 - Telefon Ekle\n" +
                    "3 - Telefon Sil\n" +
                    "0 - Çıkış Yap");
            System.out.println();
            System.out.print("Lütfen yapmak istediğiniz işlemi seçin: ");

            choice = scan.nextInt();

            if (choice >= 0 && choice <= 3) {
                switch (choice) {
                    case 1:
                        listPhones();
                        break;
                    case 2:
                        addPhone();
                        break;
                    case 3:
                        removePhone();
                        break;

                }
            }
        } while (choice != 0);

    }

    //Telefon listeleme
    public void listPhones(){

        if (phones.isEmpty()){
            System.out.println();
            System.out.println("Sistemde şuan Telefon yok!");
        }else{
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s%-34s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-17s%-13s%-1s\n", "| ID", "| Ürün Adı", "| Fiyat", "| Markası", "| Depolama", "| Ekran Boyutu", "| Kamera Çözünürlüğü " , "| RAM", "| Stok", "| İndirim Oranı", "| Batarya(mAh)", "| Renk", "|");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (Phone phone : phones){
                System.out.printf("| %-2d | %-31s | %-14.2f | %-14s | %-14d | %-14s | %-18d | %-14d | %-14d | %-14d | %-15s| %-10s |\n", phone.getID(),
                        phone.getName(),
                        phone.getPrice(),
                        phone.getBrand().getName(),
                        phone.getMemory(),
                        phone.getScreenSize(),
                        phone.getCameraResolution(),
                        phone.getRam(),
                        phone.getStock(),
                        phone.getDiscountRate(),
                        phone.getBatteryPower(),
                        phone.getColor());

            }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }


    }

    //Telefon ekleme
    public void addPhone(){
        System.out.println("Eklemek istediğiniz Telefon bilgilerini girin;");

        //Ürün adı
        System.out.print("Adı: ");
        scan.nextLine();
        String name = scan.nextLine();

        //Ürün fiyatı
        System.out.print("Fiyatı: ");
        double price = scan.nextDouble();

        //Marka seçme
        System.out.println("Markalar");
        System.out.println("----------");

        Brand selectedBrand = null;

        for (Brand brand : brands){
            System.out.println(brand.getId() + " - " + brand.getName());
        }

        System.out.println();
        System.out.print("Marka Seçin: ");
        int brandChoice = scan.nextInt();

        for (Brand brand : brands){
            if (brand.getId() == brandChoice){
                selectedBrand = brand;
            }
        }

        //Depolama boyutu
        System.out.print("Depolaması: ");
        int memory = scan.nextInt();

        //Ekran boyutu
        System.out.print("Ekran boyutu: ");
        String screenSize = scan.next();
        scan.nextLine();

        //Kamera çözünürlüğü
        System.out.print("Kamera Çözünürlüğü: ");
        int cameraResolution = scan.nextInt();

        //RAM
        System.out.print("RAM'i: ");
        int ram = scan.nextInt();

        //Stok adedi
        System.out.print("Stok adedi: ");
        int stock = scan.nextInt();

        //İndirim oranı
        System.out.print("İndirim oranı: ");
        int discountRate = scan.nextInt();

        //Batarya boyutu
        System.out.print("Batarya(mAh): ");
        int batteryPower = scan.nextInt();

        //Renk seçimi
        System.out.print("Rengi: ");
        String color = scan.next();


        phones.add(new Phone(name, price, selectedBrand, memory, screenSize, cameraResolution, batteryPower, ram, color, discountRate, stock));

        System.out.println();
        System.out.println("Eklediğiniz Notebook Bilgileri");
        System.out.println("-------------------------------");
        System.out.println("Adı: " + name + "\n" +
                "Fiyatı: " + price + "\n" +
                "Markası: " + selectedBrand.getName() + "\n" +
                "Depolaması: " + memory + "\n" +
                "Ekran Boyutu: " + screenSize + "\n" +
                "Kamera Çözünürlüğü: " + cameraResolution + "\n" +
                "RAM: " + ram + "\n" +
                "Stok: " + stock + "\n" +
                "İndirim Oranı: " + discountRate + "\n" +
                "Batarya(mAh): " + batteryPower + "\n" +
                "Rengi: " + color + "\n" );

    }

    //Telefon silme
    public void removePhone(){
        listPhones();

        System.out.print("Silmek istediğiniz telefon id'sini giriniz: ");
        int removePhone = scan.nextInt();

        if (removePhone > 0 && removePhone <= phones.size()){
            phones.removeIf(notebook -> notebook.getID() == removePhone);
            System.out.println("ID numarası " + removePhone + " olan Telefon silindi");
        } else {
            System.out.println("Ürün bulunamadı! ");
        }
    }


}
