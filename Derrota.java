import greenfoot.*;  

/**
 * A clsse derrota é responsável por mostrar ao jogador caso
 * ele perca o jogo. Essa demonstração acompanha textos e som 
 * que induz a experiência.
 * @author Maycon 
 * @version 18/12/2024
 */
public class Derrota extends World
{   
    //Variavel responsavel por guadar a música de derrota
    GreenfootSound somDeFundo;
    //Variavel para definir a cor padrão do mundo bem como definir as mensagens na tela
    GreenfootImage background;
    
    /**
     * Construtor da classe com a função de inicializar
     * variavel e chamar todos os métodos inerentes a
     * um estado de objeto válido.
     */
    public Derrota()
    {   
        super(900, 550, 1);
        
        background = getBackground();
        
        tocarMusicaDeDerrota();
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
        background.setColor(new Color(200, 0, 0)); 
        background.fill();
    }
    /**
     * Define o que será escrito na tela para o usuário.
     */
    public void textoInformativoAoUsuario(){
        // Adiciona texto na tela inicial
        background.setColor(Color.WHITE);
        background.setFont(new Font("Arial", true, false, 23));
        background.drawString("VOCÊ PERDEU!", 350, 250);
        background.drawString("PRESSIONE ENTER PARA INICIAR UM NOVO JOGO", 170, 300);
    }
    /**
     * Toca música sinalizando a derrota.
     */
    public void tocarMusicaDeDerrota(){
        somDeFundo = new GreenfootSound("derrota.mp3");
        somDeFundo.playLoop();
    }
}
