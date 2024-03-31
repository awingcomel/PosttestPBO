import java.util.ArrayList;
import java.util.Scanner;

class Pizza {
    private int id;
    private String alamat;
    private String noTelepon;
    private double harga;
    private String pembayaran;
    private String kurir;

    // Constructor
    public Pizza(int id, String alamat, String noTelepon, double harga, String pembayaran, String kurir) {
        this.id = id;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.harga = harga;
        this.pembayaran = pembayaran;
        this.kurir = kurir;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public String getKurir() {
        return kurir;
    }

    public void setKurir(String kurir) {
        this.kurir = kurir;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Alamat: " + alamat + "\n" +
               "No Telepon: " + noTelepon + "\n" +
               "Harga: " + harga + "\n" +
               "Pembayaran: " + pembayaran + "\n" +
               "Kurir: " + kurir;
    }
}

class PizzaBiasa extends Pizza {
    public PizzaBiasa(int id, String alamat, String noTelepon, double harga, String pembayaran, String kurir) {
        super(id, alamat, noTelepon, harga, pembayaran, kurir);
    }

    // Metode tambahan khusus untuk PizzaBiasa, jika diperlukan
}

class PizzaSpesial extends Pizza {
    private String toppingSpesial;

    public PizzaSpesial(int id, String alamat, String noTelepon, double harga, String pembayaran, String kurir, String toppingSpesial) {
        super(id, alamat, noTelepon, harga, pembayaran, kurir);
        this.toppingSpesial = toppingSpesial;
    }

    public String getToppingSpesial() {
        return toppingSpesial;
    }

    public void setToppingSpesial(String toppingSpesial) {
        this.toppingSpesial = toppingSpesial;
    }
}


public class Pizza_Dominos {
    private static ArrayList<Pizza> pizzaDatabase = new ArrayList<>();
    private static int nextId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nDomino's Pizza System");
            System.out.println("1. Tambah Pizza");
            System.out.println("2. Tampilkan Semua Pizza");
            System.out.println("3. Update Pizza");
            System.out.println("4. Hapus Pizza");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    tambahPizza();
                    break;
                case 2:
                    tampilkanSemuaPizza();
                    break;
                case 3:
                    updatePizza();
                    break;
                case 4:
                    hapusPizza();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Menu tidak ada");
            }
        }
        scanner.close();
    }

    private static void tambahPizza() {
        // Metode tambahPizza() di-overload untuk menerima parameter berbeda
        System.out.println("\nTambah Pizza");
        System.out.println("Pilih jenis pizza:");
        System.out.println("1. Pizza Biasa");
        System.out.println("2. Pizza Spesial");
        System.out.print("Pilihan Anda: ");
        int jenisPizza = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();
        System.out.print("No Telepon: ");
        String noTelepon = scanner.nextLine();
        System.out.print("Harga: ");
        double harga = scanner.nextDouble(); // Harga diubah menjadi double
        scanner.nextLine(); // Consume newline
        System.out.print("Pembayaran: ");
        String pembayaran = scanner.nextLine();
        System.out.print("Kurir: ");
        String kurir = scanner.nextLine();
    
        // Overloading tambahPizza() berdasarkan jenis pizza yang dipilih
        if (jenisPizza == 1) {
            PizzaBiasa newPizza = new PizzaBiasa(nextId++, alamat, noTelepon, harga, pembayaran, kurir);
            pizzaDatabase.add(newPizza);
        } else if (jenisPizza == 2) {
            System.out.print("Topping Spesial: ");
            String toppingSpesial = scanner.nextLine();
            PizzaSpesial newPizza = new PizzaSpesial(nextId++, alamat, noTelepon, harga, pembayaran, kurir, toppingSpesial);
            pizzaDatabase.add(newPizza);
        } else {
            System.out.println("Pilihan tidak valid");
            return;
        }
    
        System.out.println("Pizza berhasil ditambahkan!");
    }
    
    
        

    private static void tampilkanSemuaPizza() {
        System.out.println("\nDaftar Pizza:");
        for (Pizza pizza : pizzaDatabase) {
            System.out.println("ID: " + pizza.getId());
            System.out.println("Alamat: " + pizza.getAlamat());
            System.out.println("No Telepon: " + pizza.getNoTelepon());
            System.out.printf("Harga: %d\n", (int) pizza.getHarga()); // Menggunakan format integer
            System.out.println("Pembayaran: " + pizza.getPembayaran());
            System.out.println("Kurir: " + pizza.getKurir());
            System.out.println("------------------------");
        }
    }    

    private static void updatePizza() {
        System.out.print("\nMasukkan ID pizza yang akan diupdate: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (Pizza pizza : pizzaDatabase) {
            if (pizza.getId() == id) {
                found = true;
                System.out.print("Alamat baru: ");
                String alamat = scanner.next();
                System.out.print("No Telepon baru: ");
                String noTelepon = scanner.next();
                System.out.print("Harga baru: ");
                double harga = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.print("Pembayaran baru: ");
                String pembayaran = scanner.nextLine();
                System.out.print("Kurir baru: ");
                String kurir = scanner.nextLine();

                pizza.setAlamat(alamat);
                pizza.setNoTelepon(noTelepon);
                pizza.setHarga(harga);
                pizza.setPembayaran(pembayaran);
                pizza.setKurir(kurir);
                System.out.println("Pizza berhasil diupdate!");
                break;
            }
        }
        if (!found) {
            System.out.println("Pizza dengan ID tersebut tidak ditemukan");
        }
    }

    private static void hapusPizza() {
        System.out.print("\nMasukkan ID pizza yang akan dihapus: ");
        int id = scanner.nextInt();
        boolean removed = false;
        for (int i = 0; i < pizzaDatabase.size(); i++) {
            if (pizzaDatabase.get(i).getId() == id) {
                pizzaDatabase.remove(i);
                removed = true;
                System.out.println("Pizza berhasil dihapus!");
                break;
            }
        }
        if (!removed) {
            System.out.println("Pizza dengan ID tersebut tidak ditemukan");
        }
    }
}