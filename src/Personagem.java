public abstract class Personagem {
    private String nome = "Personagem modelo";
    private Integer vidaTotal;
    private Integer vida;
    private Integer ataqueTotal;
    private Integer ataque;
    private Integer defesaTotal;
    private Integer defesa;
    private String classe;

    public Personagem(String nome, String classe) {
        switch (classe) {
            case "Dano" -> {
                this.vidaTotal = 100;
                this.ataqueTotal = 60;
                this.defesaTotal = 5;
            }
            case "Tank" -> {
                this.vidaTotal = 500;
                this.ataqueTotal = 15;
                this.defesaTotal = 40;
            }
            case "Suporte" -> {
                this.vidaTotal = 150;
                this.ataqueTotal = 10;
                this.defesaTotal = 10;
            }
        }
        this.nome = nome;
        this.classe = classe;
        this.vida = this.vidaTotal;
        this.ataque = this.ataqueTotal;
        this.defesa = this.defesaTotal;
    }

    public void atacar(Personagem alvo) {
        Integer vidaAntesDoAtaque = alvo.getVida();
        Double defesa = alvo.getDefesa() / 100.0;
        Integer dano = this.ataque - (int)(this.ataque * defesa);
        if (dano > 0) {
            alvo.setVida(vidaAntesDoAtaque - dano);
        }
        if(alvo.getVida() == 0){
            System.out.println(this.getNome() + " matou " + alvo.getNome() + " ao causar " + vidaAntesDoAtaque + " de dano!");
        }else {
            dano = vidaAntesDoAtaque - alvo.getVida();
            System.out.println(this.getNome() + " atacou " + alvo.getNome() + " e causou " + dano + " de dano.");
        }
    }

    public void imprimirEstado() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Vida: " + this.vida);
        System.out.println("Ataque: " + this.ataque);
        System.out.println("Defesa: " + this.defesa);
    }

    public void resetarBuffs() {
        this.ataque = this.ataqueTotal;
        this.defesa = this.defesaTotal;
    }

    public abstract Personagem clonar();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if(vida > this.vidaTotal) {
            this.vida = this.vidaTotal;
        } else if (vida < 0) {
            this.vida = 0;
        } else {
            this.vida = vida;
        }
    }

    public Integer getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public Integer getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getVidaTotal() {
        return vidaTotal;
    }

    public void setVidaTotal(int vidaTotal) {
        this.vidaTotal = vidaTotal;
    }
}
