public class Mago extends Evoluivel {

    private int poderMagico;

    public Mago(String nome) {
        super(nome);
        this.poderMagico = 15;
    }

    @Override
    public void subirNivel() throws NivelMaximoAtingidoException, ExperienciaInsuficienteException {
    
        if (this.nivel >= NIVEL_MAXIMO) {
            throw new NivelMaximoAtingidoException(this.nome + " já está no nível máximo (" + NIVEL_MAXIMO + ")!");
        }
        
        if (this.experiencia < XP_PARA_PROXIMO_NIVEL) {
            int xpFaltante = XP_PARA_PROXIMO_NIVEL - this.experiencia;
            throw new ExperienciaInsuficienteException("XP insuficiente para " + this.nome + ". Faltam " + xpFaltante + " XP.");
        }

        this.nivel++;
        this.experiencia -= XP_PARA_PROXIMO_NIVEL;
        this.poderMagico += 8;

        System.out.println("🔮 LEVEL UP! 🔮 " + this.nome + " alcançou o nível " + this.nivel + "!");
    }

    @Override
    public String descreverPersonagem() {
        return String.format("MAGO: %s | Nível: %d | XP: %d/%d | Poder Mágico: %d",
                this.nome, this.nivel, this.experiencia, XP_PARA_PROXIMO_NIVEL, this.poderMagico);
    }
}
