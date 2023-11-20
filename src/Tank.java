public class Tank extends Personagem{
    private Double bloqueio = 1.01;

    public Tank(String nome) {
        super(nome, "Tank");
    }

    @Override
    public void setVida(int vida) {
        if(vida < super.getVida()){
            super.setVida((int) (vida * bloqueio));
        } else {
            super.setVida(vida);
        }
    }

    public Tank clonar() {
        Tank clone = new Tank(this.getNome() + " (Clone)");
        clone.setVida(this.getVida());
        clone.setAtaque(this.getAtaque());
        clone.setDefesa(this.getDefesa());
        return clone;
    }
}
