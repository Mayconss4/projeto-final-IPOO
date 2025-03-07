import greenfoot.*; 

/**
 * A classe CampoDeBatalhaUm define onde toda a batalha acontecerá
 * ela é responsavel por adicionar os objetos que irão compor o jogo.
 * @author Maycon
 * @version 18/12/2024
 */
public class CampoDeBatalhaUm extends World
{
    //Variável para armazenar a pontuação
    private int pontuacao;
    //Atributo exibir o placar
    private Placar placar;
    //Contador para gerar TanqueDois
    private int contadorTanques;
    //Limite de tanques no mundo
    private int limiteTanques;
    //A fase atual do jogo
    private int fase;      
    //variavel para checar se esta na fase final
    private boolean faseFinal;
    //Atributo que armazena a fase atual do jogo
    private MostrarFase mostrarFase; 
    /**
     * Construtor da classe responsavel por iniciar atributos garantindo um estado
     * de objeto válido e chamando o método pertinente a construção do primeiro campo
     * de batalha.
     */
    public CampoDeBatalhaUm()
    {    
        super(900, 550, 1); 
        
        //inicialização de variaveis para um estado valido de objeto
        pontuacao = 0;
        placar = new Placar("Pontuação: " + pontuacao, 30);
        contadorTanques = 0; 
        limiteTanques = 2;
        fase = 1;
        faseFinal = false;
        mostrarFase = new MostrarFase("Fase: " + fase, 30);
        
        prepare();
    }
    
    /**
     * Define a tela vitoria caso a pontuacao atinja 1000 pontos
     */
    public void act()
    {
        if (pontuacao >= 1000 && !faseFinal) {
            Greenfoot.setWorld(new Vitoria());
        }
    }
    /**
     * Método para gerar um novo TanqueDois em posição aleatória
     */ 
    private void gerarTanqueDois()
    {   
        // Posição X aleatória
        int x = Greenfoot.getRandomNumber(getWidth());
        // Posição Y aleatória
        int y = Greenfoot.getRandomNumber(getHeight()); 

        TanqueDois tanqueDois = new TanqueDois(); 
        // Adiciona o tanque no mundo com as posições aleatórias
        addObject(tanqueDois, x, y); 
    }
    /**
     * Incrementa a pontuação a cada tanque abatido
     */
    public void adicionarPontuacao(int pontos)
    {
        pontuacao += pontos; 
        // Atualiza o texto do placar
        placar.setText("Pontuação: " + pontuacao); 
    }
    /**
     * Método que é usado para definir as caracteristicas do mundo
     */
    private void mudarFundo()
    {
        GreenfootImage background = getBackground();
        switch (fase) {
            case 1:
                background.setColor(new Color(240, 230, 140));
                break;
            case 2:
                background.setColor(new Color(0, 255, 0));
                break;
        }
        background.fill();
    }
    /**
     * Método chamado para gerar outro TanqueDois quando o prévio for destruído
     */
    public void tanqueDoisDestruido()
    {
        if ((getObjects(TanqueDois.class).size() < limiteTanques) && (pontuacao <= 800)) 
        {
            gerarTanqueDois(); 
        }
    }
    /**
     * Retorna o valor atual da variável fase
     */
    public int getFase() {
        return fase;  
    }
    /**
     * Monta as caracteristicas padrão do mundo e adiciona os primeiros objetos
     */
    private void prepare()
    {
        TanqueUm tanqueUm = new TanqueUm();
        addObject(tanqueUm, 150, 300);

        TanqueDois inimigo1 = new TanqueDois();
        addObject(inimigo1, 450, 100);
        
        TanqueDois inimigo2 = new TanqueDois();
        addObject(inimigo2, 150, 100);
        
        AviaoDeSuprimentos aviao = new AviaoDeSuprimentos();
        addObject(aviao, 250, 200); 
        
        addObject(placar, 100, 30); 
        addObject(mostrarFase, 800, 30);
        
        mudarFundo();
        Greenfoot.setWorld(new TelaInicial());
    }
}

