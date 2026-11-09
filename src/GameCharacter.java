public abstract class GameCharacter {
    private String name;
    private int hp;
    private final int maxHp;
    private int damage;

    public GameCharacter(String name, int maxHp, int damage) {
        this.name = name;
        this.maxHp = Math.max(1, maxHp);
        this.hp = this.maxHp;
        this.damage = Math.max(0, damage);
    }

    public GameCharacter(String name, int maxHp) {
        this(name, maxHp, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, Math.min(hp, maxHp));
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = Math.max(0, damage);
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void showStatus() {
        System.out.println("Nama   : " + name);
        System.out.println("HP     : " + hp + "/" + maxHp);
        System.out.println("Damage : " + damage);
    }

    public abstract void receiveDamage(int amount);
}