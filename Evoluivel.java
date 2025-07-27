public abstract class Evoluivel implements Upgradavel {

    protected String nome;
    protected int nivel;
    protected int experiencia;

    protected static final int NIVEL_MAXIMO = 50;
    protected static final int XP_PARA_PROXIMO_NIVEL = 100;

    public Evoluivel(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.experiencia = 0;
    }

    public void ganharExperiencia(int pontos) {
        if (pontos > 0) {
            this.experiencia += pontos;
            System.out.println(this.nome + " ganhou " + pontos + " de XP. (Total: " + this.experiencia + ")");
        }
    }

    public abstract String descreverPersonagem();

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }
}
