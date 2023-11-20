public class Dano extends Personagem{
    private Integer municao = 5;

    public Dano(String nome) {
        super(nome, "Dano");
    }

    public void recarregar() {
        this.municao = 3;
    }

    @Override
    public void atacar(Personagem alvo) {
        if(this.municao > 0) {
            super.atacar(alvo);
            this.municao--;
        } else {
            System.out.println("Sem munição! Recarrergando...");
            this.recarregar();
        }
    }

    @Override
    public void imprimirEstado() {
        super.imprimirEstado();
        System.out.println("Munição: " + this.municao);
    }

    public Dano clonar() {
        Dano clone = new Dano(this.getNome() + " (Clone)");
        clone.setVida(this.getVida());
        clone.setAtaque(this.getAtaque());
        clone.setDefesa(this.getDefesa());
        clone.setMunicao(this.getMunicao());
        return clone;
    }

    public Integer getMunicao() {
        return municao;
    }

    public void setMunicao(int municao) {
        this.municao = municao;
    }
}
