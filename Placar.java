import greenfoot.*; 
/**
 * Confgura o placar na tela do jogo
 * @author Maycon
 * @version 18/12/2024
 */
public class Placar extends Actor
{
    private GreenfootImage imagem;
    private String texto;
    private int tamanhoFonte;
    /**
     * Construtor que inicializa variáveis garantindo um 
     * estado válido de objeto 
     */
    public Placar(String texto, int tamanhoFonte)
    {
        this.texto = texto;
        this.tamanhoFonte = tamanhoFonte;
        atualizarImagem();
    }
    /**
     * Define um novo valor para o atributo
     * texto e chama o método para atualizar
     * a informação para o usuário
     */
    public void setText(String texto)
    {
        this.texto = texto;
        atualizarImagem();
    }
    /**
     * Atualiza a informação na tela
     */
    private void atualizarImagem()
    {
        imagem = new GreenfootImage(texto, tamanhoFonte, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(imagem);
    }
}
