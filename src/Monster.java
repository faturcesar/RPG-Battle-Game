public class Monster extends GameCharacter {
    public Monster() {
        this("Goblin", GameConfig.MONSTER_MAX_HP, GameConfig.MONSTER_DAMAGE);
    }

    public Monster(String name, int maxHp, int damage) {
        super(name, maxHp, damage);
    }

    public void attack(GameCharacter target) {
        if (target != null && target.isAlive() && isAlive()) {
            System.out.println(getName() + " menyerang " + target.getName() + "!");
            target.receiveDamage(getDamage());
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
            System.out.println(getName() + " sudah dikalahkan.");
        }
    }

    @Override
    public void showStatus() {
        super.showStatus();
        System.out.println("Peran   : Monster");
    }
}