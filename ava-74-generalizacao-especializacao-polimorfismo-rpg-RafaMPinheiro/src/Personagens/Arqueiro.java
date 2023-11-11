package Personagens;

public class Arqueiro extends Personagem {
    @Override
    public int getForca() {
        return 3;
    }

    @Override
    public int getPontaria() {
        return 5;
    }

    @Override
    public int getMagica() {
        return 2;
    }

    @Override
    public String toString() {
        String toString = "Arqueiro ";
        if (getEscudo() == null) {
            toString += "sem escudo e ";
        }
        if (getArmaPrincipal() == null) {
            if (getArmaSecundaria() == null) {
                toString += "desarmado";
            } else {
                toString += "armado com " + getArmaSecundaria().nome;
            }
        } else {
            toString += "armado com " + getArmaPrincipal().nome;
        }
        return toString;
    }
}
