import greenfoot.*; 

/**
 * A tela inicial é o primeiro contato do jogador com a aplicação
 * e é nela que o jogador aprende tudo que é necessário para fazer um bom jogo
 * @author Maycon 
 * @version 18/12/2024
 */
public class TelaInicial extends World
{   
    GreenfootImage background;
    /**
     * O construtor da tela inicial é reponsavel por garantir um estado válido de objeto
     * inicializando variaveis e chamando métodos pertinentes ao objeto.
     */
    public TelaInicial()
    {   
        super(900, 550, 1);
        background = getBackground();
        definirCorDoMundo();
        textoInformativoAoUsuario();
        adicionarTanques();
    }
    /**
     * Ao apertar enter o jogadoré direcionado para o campo de batalha definitivo.
     */
    public void act()
    {
        //Quando ENTER é pressionado uma instancia de CampoDeBatalhaUm é gerada e ai sim da-se inicio ao jogo
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new CampoDeBatalhaUm());
        }
    }
    /**
     * Define a cor para o background do mundo.
     */
    public void definirCorDoMundo(){
        background.setColor(new Color(70, 130, 180));
        background.fill();
    }
    /**
     * Define a cor do texto.
     */
    public void definirCorDoTexto(){
        background.setColor(Color.WHITE);
    }
    /**
     * Define o que será escrito para o jogador.
     */
    public void textoInformativoAoUsuario(){
        definirCorDoTexto();
        background.setFont(new Font("Arial", true, false, 23));
        background.drawString("Combate remasterizado", 320, 65);
        background.drawString("O seu tanque, jogador, é o que possui a cor marrom você o controlará usando", 10, 90);
        background.drawString("as setinhas de navegação de seu teclado, (→ ← ↑ ↓) e fará seus disparos ", 10, 115);
        background.drawString("por meio da tecla 'f' (FOGO). Seu objetivo é destruir todos os combatentes", 10, 140);
        background.drawString("inimigos. Lembre-se que seus tiros são limitados (100), sem eles você não", 10, 165);
        background.drawString("consegue eliminar as tropas inimigas e consequentemente é automaticamente ", 10, 190);
        background.drawString("abatido! Mas calma, o avião que sobrevoa o campo de batalha é seu aliado", 10, 215);
        background.drawString("e deixa de maneira estratégica munições para que você recolha e consiga", 10, 240);
        background.drawString("completar a missão, entretanto, lembre-se que você pode pegar os suprimen-", 10, 265);
        background.drawString("tos apenas quando estiver com 90 tiros restantes ou menos. Você vence as", 10, 290);
        background.drawString("tropas inimigas se abater todos os 10 tanques que estão acaminho do campo", 10, 315);
        background.drawString("de batalha e isso é equivalente a atingir 1000 pontos. Seja cuidadoso, caso", 10, 340);
        background.drawString("um tiro te acerte não há mais volta.", 10, 365);
        background.drawString("PRESSIONE ENTER PARA INICIAR", 250, 415);
    }
    /**
     * Adiciona os objetos que servem de animação para proporcionar certo dinamismo 
     * a leitura do funcionamento do jogo.
     */
    public void adicionarTanques(){
        TanqueAnimado tanque1 = new TanqueAnimado();
        TanqueAnimado tanque2 = new TanqueAnimado();
        addObject(tanque1, 100, 530);
        addObject(tanque2, 500, 20);
    }
    
}
