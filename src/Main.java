import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("         RPG BATTLE GAME        ");
        System.out.println("================================");
        System.out.print("Masukkan nama pemain: ");
        String nama = input.nextLine();
        if (nama.trim().isEmpty()) {
            nama = "Pemain";
        }

        // Constructor overloading: Player(String) dan Monster().
        Player player = new Player(nama);
        Monster monster = new Monster();

        // Constructor alternatif untuk statistik karakter yang ditentukan sendiri.
        Player karakterUji = new Player("Pemain Uji", 120, 25);
        Monster monsterUji = new Monster("Orc", 100, 18);
        System.out.println("\nKarakter berhasil dibuat.");
        System.out.println("Constructor alternatif: " + karakterUji.getName()
                + " dan " + monsterUji.getName());
        System.out.println("\nMonster muncul!");
        monster.showStatus();

        // Pemanggilan method melalui variabel referensi bertipe interface.
        Attackable penyerang = player;
        Healable penyembuh = player;

        boolean bermain = true;
        while (bermain && player.isAlive() && monster.isAlive()) {
            System.out.println("\n========== BATTLE ==========");
            System.out.println("1. Serang Monster");
            System.out.println("2. Pulihkan HP");
            System.out.println("3. Lihat Status");
            System.out.println("4. Lewati Giliran");
            System.out.println("5. Keluar");
            System.out.print("Pilih aksi: ");

            String pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    penyerang.attack(monster);
                    break;
                case "2":
                    penyembuh.heal();
                    break;
                case "3":
                    System.out.println("\n--- STATUS PEMAIN ---");
                    player.showStatus();
                    System.out.println("\n--- STATUS MONSTER ---");
                    monster.showStatus();
                    continue;
                case "4":
                    System.out.println(player.getName() + " melewati giliran.");
                    break;
                case "5":
                    bermain = false;
                    System.out.println("Permainan dihentikan.");
                    continue;
                default:
                    System.out.println("Pilihan tidak tersedia.");
                    continue;
            }

            if (monster.isAlive() && player.isAlive() && bermain) {
                monster.attack(player);
            }
        }

        if (!player.isAlive()) {
            System.out.println("\n================================");
            System.out.println("          GAME OVER!             ");
            System.out.println("           KAMU KALAH!           ");
            System.out.println("================================");
        } else if (!monster.isAlive()) {
            System.out.println("\n================================");
            System.out.println("        SELAMAT! KAMU MENANG!    ");
            System.out.println("================================");
        }

        input.close();
    }
}