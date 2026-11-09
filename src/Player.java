public class Player extends GameCharacter implements Attackable, Healable {
    public Player(String name) {
        this(name, GameConfig.PLAYER_MAX_HP, GameConfig.PLAYER_DAMAGE);
    }

    public Player(String name, int maxHp, int damage) {
        super(name, maxHp, damage);
    }

    @Override
    public void attack(GameCharacter target) {
        if (target != null && target.isAlive() && isAlive()) {
            System.out.println(getName() + " menyerang " + target.getName() + "!");
            target.receiveDamage(getDamage());
        }
    }

    @Override
    public void heal() {
        if (!isAlive()) {
            System.out.println("Pemain sudah kalah dan tidak dapat memulihkan HP.");
        } else if (getHp() == getMaxHp()) {
            System.out.println("HP pemain masih penuh.");
        } else {
            int hpSebelum = getHp();
            setHp(getHp() + GameConfig.HEAL_AMOUNT);
            System.out.println(getName() + " memulihkan " + (getHp() - hpSebelum) + " HP.");
        }
    }

    @Override
    public void receiveDamage(int amount) {
        if (amount <= 0) {
            System.out.println("Damage harus lebih dari 0.");
        } else if (isAlive()) {
            setHp(getHp() - amount);
            System.out.println(getName() + " menerima damage " + amount + ".");
        } else {
            System.out.println(getName() + " sudah tidak memiliki HP.");
        }
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("Peran   : Pemain");
    }
}