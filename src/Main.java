import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer turno = 0;
        String vencedor = "";
        Boolean empate = false, exit = false;
        List<Personagem> timeUm = new ArrayList<>();
        List<Personagem> timeDois = new ArrayList<>();
        List<Personagem> clones = new ArrayList<>();

        timeUm.add(new Suporte("SereneSavior"));
        timeUm.add(new Dano("ThunderStriker"));
        timeUm.add(new Tank("IronGuardian"));

        timeDois.add(new Suporte("HealWarden"));
        timeDois.add(new Dano("ShadowSlayer"));
        timeDois.add(new Tank("SteelTitan"));

        Random random = new Random();

        while(vencedor.isEmpty()){
            turno++;

            if(turno == 201){
                empate = true;
                break;
            }

            System.out.println("\nTurno: " + turno);

            //Na linha abaixo, a cada 10 turnos, os personagens são clonados e adicionados ao time, com os mesmos atributos.
            if(turno == 10){
                System.out.println("---------------- Os clones surgiram! ----------------\n");
                timeUm.forEach(personagem -> clones.add(personagem.clonar()));
                timeUm.addAll(clones);
                clones.clear();

                timeDois.forEach(personagem -> clones.add(personagem.clonar()));
                timeDois.addAll(clones);
                clones.clear();
            }

            System.out.println("--- Movimento: Time 1 ---");
            for(int i = 0; i < timeUm.size(); i++){
                exit = false;
                Personagem personagemUm = timeUm.get(i);
                if(personagemUm.getVida() > 0) {
                    for(int j = 0; j < timeDois.size(); j++){
                        if(timeDois.get(j).getVida() > 0){
                            exit = true;
                            break;
                        }
                    }

                    if(!exit) {
                        break;
                    }

                    Personagem personagemDois = timeDois.get(random.nextInt(timeDois.size()));
                    while (personagemDois.getVida() == 0){
                        personagemDois = timeDois.get(random.nextInt(timeDois.size()));
                    }
                    personagemUm.atacar(personagemDois);
                    if(personagemUm.getClasse() == "Suporte"){
                        Personagem aliado = timeUm.get(random.nextInt(timeUm.size()));
                        while (aliado.getVida() == 0 || aliado.getClasse() == "Suporte"){
                            aliado = timeUm.get(random.nextInt(timeUm.size()));
                        }
                        Suporte suporte = (Suporte) personagemUm;
                        suporte.buffar(aliado);

                        aliado = timeDois.get(random.nextInt(timeUm.size()));
                        while (aliado.getVida() == 0 || aliado.getClasse() == "Suporte"){
                            aliado = timeUm.get(random.nextInt(timeUm.size()));
                        }
                        suporte.curar(aliado);
                    }else{
                        personagemUm.resetarBuffs();
                    }
                }
            }

            System.out.println("--- Movimento: Time 2 ---");
            for(int i = 0; i < timeUm.size(); i++){
                exit = false;
                Personagem personagemUm = timeDois.get(i);
                if(personagemUm.getVida() > 0) {
                    for(int j = 0; j < timeUm.size(); j++){
                        if(timeUm.get(j).getVida() > 0){
                            exit = true;
                            break;
                        }
                    }
                    if(!exit) {
                        break;
                    }
                    Personagem personagemDois = timeUm.get(random.nextInt(timeUm.size()));
                    while (personagemDois.getVida() == 0){
                        personagemDois = timeUm.get(random.nextInt(timeUm.size()));
                    }
                    personagemUm.atacar(personagemDois);
                    if(personagemUm.getClasse() == "Suporte"){
                        Personagem aliado = timeDois.get(random.nextInt(timeUm.size()));
                        while (aliado.getVida() == 0 || aliado.getClasse() == "Suporte"){
                            aliado = timeDois.get(random.nextInt(timeDois.size()));
                        }
                        Suporte suporte = (Suporte) personagemUm;
                        suporte.buffar(aliado);

                        aliado = timeDois.get(random.nextInt(timeDois.size()));
                        while (aliado.getVida() == 0 || aliado.getClasse() == "Suporte"){
                            aliado = timeUm.get(random.nextInt(timeUm.size()));
                        }
                        suporte.curar(aliado);

                        ((Suporte) personagemUm).restaurarMana();
                    }else{
                        personagemUm.resetarBuffs();
                    }
                }
            }

            vencedor = "Time 2";
            for (Personagem personagem : timeUm) {
                if(personagem.getVida() > 0) {
                    vencedor = "";
                    break;
                }
            }

            if (vencedor.isEmpty()) {
                vencedor = "Time 1";
                for (Personagem personagem : timeDois) {
                    if (personagem.getVida() > 0) {
                        vencedor = "";
                        break;
                    }
                }
            }
        }

        if (empate) {
            System.out.println("\n----------------- Empate! -----------------");
        } else {
            System.out.println("\n----------------- " + vencedor + " venceu no turno " + turno + "!!!!! -----------------");
        }
    }
}