public class SistemaRPG {

    public static void main(String[] args) {

        Guerreiro aragorn = new Guerreiro("Aragorn");
        Mago gandalf = new Mago("Gandalf");

        System.out.println("\n--- Início da Jornada ---\n");
        separadosem();
        System.out.println(aragorn.descreverPersonagem());
        System.out.println(gandalf.descreverPersonagem());
        separador();

        separadosem();
        System.out.println("(Tentando evoluir Gandalf sem experiência)\n");
        try {
            gandalf.subirNivel();
        } catch (NivelMaximoAtingidoException | ExperienciaInsuficienteException e) {
            
            System.err.println("AVISO: " + e.getMessage());
        }
        separador();
        separadosem();
        System.out.println("(Aragorn derrota um inimigo e ganha XP.)\n");
        aragorn.ganharExperiencia(120);
        System.out.println(aragorn.descreverPersonagem());
        separador();
        separadosem();
        System.out.println("(Tentando evoluir Aragorn com XP suficiente...)\n");
        try {
            aragorn.subirNivel();
        } catch (NivelMaximoAtingidoException | ExperienciaInsuficienteException e) {
            System.err.println("AVISO: " + e.getMessage());
        }
        System.out.println(aragorn.descreverPersonagem());
        separador();

        separadosem();
        System.out.println("(Simulando Gandalf no nível máximo...)\n");
        gandalf.nivel = 50;
        gandalf.ganharExperiencia(500);
        System.out.println(gandalf.descreverPersonagem());
        separador();

        separadosem();
        System.out.println("(Tentando evoluir Gandalf no nível máximo...)\n");
        try {
            gandalf.subirNivel();
        } catch (NivelMaximoAtingidoException | ExperienciaInsuficienteException e) {
            System.err.println("AVISO: Gandalf já está no nível máximo! (50)");
        }
        separador();
    }

    private static void separador() {
        System.out.println("------------------------------------------------------------------\n");
    }
    private static void separadosem() {
        System.out.println("------------------------------------------------------------------");
    }
}
