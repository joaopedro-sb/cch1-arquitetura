public class Suporte extends Personagem {
    private Integer mana = 100;
    private Double cura = 1.05;

    public Suporte(String nome) {
        super(nome, "Suporte");
    }

    public void buffar(Personagem aliado) {
        if (mana < 20) {
            System.out.println(super.getNome() + " sem mana para buffar!");
            return;
        }

        if("Dano".equals(aliado.getClasse())) {
            aliado.setAtaque(aliado.getAtaque() + 10);
        } else if("Tank".equals(aliado.getClasse())) {
            aliado.setDefesa(aliado.getDefesa() + 10);
        }

        System.out.println(super.getNome() + " buffou " + aliado.getNome());
        mana -= 20;
    }

    public void curar(Personagem aliado) {
        if (mana < 10) {
            System.out.println(super.getNome() + " sem mana para curar!");
            return;
        }
        aliado.setVida((int) (aliado.getVida() * cura));
        mana -= 10;
        System.out.println(super.getNome() + " curou " + aliado.getNome());
    }

    @Override
    public void imprimirEstado() {
        super.imprimirEstado();
        System.out.println("Mana: " + this.mana);
    }

    public Suporte clonar() {
        Suporte clone = new Suporte(this.getNome() + " (Clone)");
        clone.setVida(this.getVida());
        clone.setAtaque(this.getAtaque());
        clone.setDefesa(this.getDefesa());
        clone.setMana(this.getMana());
        return clone;
    }

    public void restaurarMana() {
        this.setMana(this.getMana() + 10);
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Double getCura() {
        return cura;
    }

    public void setCura(double cura) {
        this.cura = cura;
    }
}
