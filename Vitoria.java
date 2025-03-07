import greenfoot.*;  

/**
 * A clsse Vitória é responsável por mostrar ao jogador caso
 * ele vença o jogo. Essa demonstração acompanha textos e som 
 * que induz a experiência.
 * Maycon 
 * @version 18/12/2024
 */
public class Vitoria extends World
{   
    GreenfootSound somDeFundo;
    GreenfootImage background;
    /**
     * Construtor da classe com a função de inicializar
     * variavel e chamar todos os métodos inerentes a
     * um estado de objeto válido.
     */
    public Vitoria()
    {   
        super(900, 550, 1);
        
        background = getBackground();
        
        tocarMusicaDeVitoria();
        definirCorDoMundo();
        textoInformativoAoUsuario();
    }
    /**
     * Método unicamente responsável por iniciar mais um jogo.
     */
    public void act()
    {
        // Um novo campo de batalha é construido se o usuário desejar um novo jogo
        if (Greenfoot.isKeyDown("enter")) {
            somDeFundo.stop();
            Greenfoot.setWorld(new CampoDeBatalhaUm());
        }
    }
    /**
     * Define a cor do mundo.
     */ 
    public void definirCorDoMundo(){
        // Configura o fundo da tela inicial
        background.setColor(new Color(0,128,0)); 
        background.fill();
    }
    /**
     * Define o que será escrito na tela para o usuário.
     */
    public void textoInformativoAoUsuario(){
        // Adiciona texto na tela inicial
        background.setColor(Color.WHITE);
        background.setFont(new Font("Arial", true, false, 23));
        background.drawString("VOCÊ VENCEU!", 350, 250);
        background.drawString("PRESSIONE ENTER PARA INICIAR UM NOVO JOGO", 170, 300);
    }
    /**
     * Toca música sinalizando a vitória.
     */
    public void tocarMusicaDeVitoria(){
        somDeFundo = new GreenfootSound("vitoria.mp3");
        somDeFundo.playLoop();
    }
}
