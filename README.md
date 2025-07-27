<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trabalho Final POO I - Sistema de Evolução de Personagem (RPG)</title>
    
    <!-- Tailwind CSS -->
    <script src="https://cdn.tailwindcss.com"></script>
    
    <!-- Google Fonts: Inter -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;700;900&display=swap" rel="stylesheet">

    <!-- Prism.js for code highlighting -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/themes/prism-tomorrow.min.css" rel="stylesheet" />

    <style>
        /* Custom styles to complement Tailwind */
        body {
            font-family: 'Inter', sans-serif;
            background-color: #111827; /* bg-gray-900 */
            color: #d1d5db; /* text-gray-300 */
        }
        .gradient-text {
            background: linear-gradient(to right, #4f46e5, #a855f7);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
        }
        .section-card {
            background-color: #1f2937; /* bg-gray-800 */
            border: 1px solid #374151; /* border-gray-700 */
            border-radius: 0.75rem; /* rounded-xl */
            padding: 2rem;
            margin-bottom: 2rem;
            box-shadow: 0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05);
        }
        h2 {
            font-weight: 700;
            font-size: 1.875rem; /* text-3xl */
            margin-bottom: 1.5rem;
            border-left: 4px solid #4f46e5; /* border-indigo-600 */
            padding-left: 1rem;
        }
        h3 {
            font-weight: 600;
            font-size: 1.5rem; /* text-2xl */
            margin-top: 2rem;
            margin-bottom: 1rem;
            color: #9ca3af; /* text-gray-400 */
        }
        p, li {
            line-height: 1.75;
            font-size: 1.125rem; /* text-lg */
        }
        code[class*="language-"] {
            font-size: 1rem !important; /* text-base */
            line-height: 1.75 !important;
        }
        .btn {
            display: inline-block;
            padding: 0.75rem 1.5rem;
            border-radius: 0.5rem;
            font-weight: 600;
            text-align: center;
            transition: transform 0.2s, box-shadow 0.2s;
            background-color: #4f46e5; /* bg-indigo-600 */
            color: white;
        }
        .btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 20px rgba(79, 70, 229, 0.5);
        }
    </style>
</head>
<body class="antialiased">

    <!-- Header -->
    <header class="text-center py-12 px-4 bg-gray-900">
        <h1 class="text-5xl md:text-6xl font-black tracking-tight gradient-text">
            Sistema de Evolução de Personagem (RPG)
        </h1>
        <p class="mt-4 text-xl text-gray-400">Trabalho Final de Programação Orientada a Objetos I</p>
        <p class="mt-2 text-lg text-gray-500">
            <strong>Alunos:</strong> [Nome do Aluno 1] & [Nome do Aluno 2]
        </p>
    </header>

    <main class="container mx-auto px-4 py-8 max-w-4xl">

        <!-- Entregáveis Section -->
        <section id="entregaveis" class="section-card">
            <h2 class="gradient-text">Portal do Projeto</h2>
            <p class="mb-8">Todos os materiais do projeto estão centralizados aqui. Use os links abaixo para acessar o código-fonte, o relatório detalhado e o vídeo de apresentação.</p>
            <div class="grid grid-cols-1 md:grid-cols-3 gap-6 text-center">
                <a href="https://github.com/seu-usuario/seu-repositorio-rpg" target="_blank" class="btn">
                    Ver Código-Fonte
                </a>
                <a href="#relatorio" class="btn">
                    Ler Relatório
                </a>
                <a href="#video" class="btn">
                    Assistir Vídeo
                </a>
            </div>
        </section>

        <!-- Teoria e Prática Section -->
        <section id="teoria" class="section-card">
            <h2>Teoria Aplicada na Prática</h2>
            <p>Esta seção explica os conceitos de POO que fundamentaram nosso projeto, com exemplos práticos retirados diretamente do nosso código.</p>

            <!-- Classes Abstratas -->
            <div>
                <h3>1. Classes Abstratas: O Molde do Personagem</h3>
                <p>Uma classe abstrata é como a planta de um carro: ela define as partes essenciais, mas você não pode dirigir a planta. Você precisa construir um carro real a partir dela. No nosso projeto, `Evoluivel` é a nossa classe abstrata. Ela define que todo personagem terá `nome`, `nivel` e `experiencia`, e força as classes filhas a implementarem o método `descreverPersonagem()`.</p>
                <pre class="mt-4 rounded-lg"><code class="language-java">
// A "planta" do personagem. Não pode ser instanciada.
public abstract class Evoluivel {
    protected String nome;
    protected int nivel;
    protected int experiencia;

    public Evoluivel(String nome) {
        this.nome = nome;
        this.nivel = 1;
        this.experiencia = 0;
    }
    
    // Método concreto: a lógica é a mesma para todos.
    public void ganharExperiencia(int pontos) {
        this.experiencia += pontos;
    }

    // Método abstrato: força as classes filhas a implementarem.
    public abstract String descreverPersonagem();
}
                </code></pre>
            </div>

            <!-- Interfaces -->
            <div>
                <h3>2. Interfaces: O Contrato de Habilidade</h3>
                <p>Uma interface é como uma "certificação". Ela não diz o que você é, mas garante que você tem a habilidade de fazer algo. No nosso caso, a interface `Upgradavel` garante que qualquer classe que a implemente terá a capacidade de `subirNivel()`. Isso nos dá flexibilidade para que, no futuro, até mesmo itens possam subir de nível, não apenas personagens.</p>
                <pre class="mt-4 rounded-lg"><code class="language-java">
// O "contrato" que define a habilidade de subir de nível.
public interface Upgradavel {
    void subirNivel() throws NivelMaximoAtingidoException, 
                             ExperienciaInsuficienteException;
}

// A classe abstrata implementa a interface, passando a
// responsabilidade para as classes concretas.
public abstract class Evoluivel implements Upgradavel {
    // ... corpo da classe
}
                </code></pre>
            </div>

            <!-- Polimorfismo -->
            <div>
                <h3>3. Polimorfismo: A Mágica em Ação</h3>
                <p>Polimorfismo significa "muitas formas". É a consequência poderosa de usar herança e interfaces. Ele nos permite tratar objetos diferentes (`Guerreiro`, `Mago`) da mesma maneira, desde que compartilhem uma base comum (`Evoluivel`). Isso simplifica o código drasticamente.</p>
                <pre class="mt-4 rounded-lg"><code class="language-java">
// Podemos tratar objetos de tipos diferentes da mesma forma.
Evoluivel aragorn = new Guerreiro("Aragorn");
Evoluivel gandalf = new Mago("Gandalf");

// O método chamado é o específico de cada classe (Guerreiro ou Mago).
System.out.println(aragorn.descreverPersonagem());
System.out.println(gandalf.descreverPersonagem());
                </code></pre>
            </div>

            <!-- Tratamento de Exceções -->
            <div>
                <h3>4. Tratamento de Exceções: Construindo Software Seguro</h3>
                <p>Um programa robusto sabe como lidar com falhas. Em vez de usar exceções genéricas, criamos as nossas próprias para representar regras de negócio do jogo, como `ExperienciaInsuficienteException`. Isso torna os erros mais claros e o tratamento mais específico.</p>
                <pre class="mt-4 rounded-lg"><code class="language-java">
// Lançando nossa exceção personalizada dentro do método subirNivel()
if (this.experiencia < XP_PARA_PROXIMO_NIVEL) {
    throw new ExperienciaInsuficienteException("XP insuficiente...");
}

// Capturando o erro de forma elegante com try-catch
try {
    gandalf.subirNivel();
} catch (ExperienciaInsuficienteException e) {
    System.err.println("AVISO: " + e.getMessage());
}
                </code></pre>
            </div>
        </section>

        <!-- Relatório Section -->
        <section id="relatorio" class="section-card">
            <h2 class="gradient-text">Relatório do Projeto</h2>
            <div class="prose prose-lg prose-invert max-w-none">
                <h3>Introdução</h3>
                <p>Este projeto visa aplicar os conceitos fundamentais de Programação Orientada a Objetos — Classes Abstratas, Interfaces e Tratamento de Exceções — na construção de um sistema de gerenciamento para personagens de RPG...</p>
                
                <h3>Decisões de Design</h3>
                <h4>Sobre a Classe Abstrata: `Evoluivel`</h4>
                <p>A decisão foi estratégica. Um "Evoluivel" genérico não deve existir em nosso jogo; ele é um conceito, um molde. Torná-la abstrata nos deu duas vantagens cruciais: 1) Evitar Instanciação e 2) Forçar Contratos com métodos abstratos...</p>
                
                <h4>Sobre a Interface: `Upgradavel`</h4>
                <p>A interface `Upgradavel` representa a capacidade de evoluir. Foi a melhor escolha por sua flexibilidade. No futuro, poderíamos ter outras classes (ex: `ItemMagico`) que não são personagens, mas que também podem subir de nível, implementando esta mesma interface...</p>

                <h4>Sobre as Exceções Personalizadas</h4>
                <p>Criamos `ExperienciaInsuficienteException` e `NivelMaximoAtingidoException` para dar semântica aos erros. Em vez de um `IllegalArgumentException` genérico, o nome da exceção diz exatamente qual regra de negócio foi violada, permitindo um tratamento específico e tornando o código mais legível...</p>

                <h3>Desafios e Aprendizados</h3>
                <p>O maior desafio foi decidir a divisão de responsabilidades entre a classe abstrata e a interface. O aprendizado foi entender que POO não é apenas sobre criar classes, mas sobre modelar um problema de forma coesa e flexível, e que o tratamento de erros pode ser elegante e informativo.</p>
            </div>
        </section>

        <!-- Vídeo Section -->
        <section id="video" class="section-card">
            <h2 class="gradient-text">Vídeo de Apresentação</h2>
            <div class="aspect-w-16 aspect-h-9 rounded-lg overflow-hidden border-2 border-gray-700">
                <!-- Substitua o 'src' pelo link do seu vídeo no YouTube, Vimeo, etc. -->
                <iframe 
                    src="https://www.youtube.com/embed/dQw4w9WgXcQ" 
                    frameborder="0" 
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" 
                    allowfullscreen
                    class="w-full h-full">
                </iframe>
            </div>
        </section>

    </main>

    <!-- Footer -->
    <footer class="text-center py-6 px-4 bg-gray-900 border-t border-gray-800">
        <p class="text-gray-500">
            POO I - Período: 2025.1 - Professor: Davi Taveira Alencar Alarcão
        </p>
    </footer>
    
    <!-- Prism.js script -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/components/prism-core.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prism/1.29.0/plugins/autoloader/prism-autoloader.min.js"></script>
</body>
</html>
