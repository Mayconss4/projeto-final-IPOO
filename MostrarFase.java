import greenfoot.*; 
/**
 * Mostra em qual fase o jogador está
 * @author Maycon
 * @version 18/12/2024
 **/

public class MostrarFase extends Actor
{
    private GreenfootImage imagem;
    /**
     * O construtor da classe define a fase e a insere no mundo
     */
    public MostrarFase(String texto, int tamanhoFonte)
    {
        imagem = new GreenfootImage(texto, tamanhoFonte, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(imagem);
    }
    /**
     * Atualiza o texto da fase
     */
    public void setText(String texto)
    {
        // Limpa o texto anterior
        imagem.clear(); 
        imagem.drawString(texto, 0, imagem.getHeight() / 2); 
        // Atualiza a imagem
        setImage(imagem); 
    }
}
