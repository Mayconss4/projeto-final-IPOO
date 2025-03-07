import greenfoot.*; 
/**
 * Exibe ao jogador quantos tiros ainda restam.
 * @author Maycon
 * @version 18/12/2024
 */
public class TirosRestantes extends Actor
{
    private GreenfootImage imagem;
    private String texto;
    private int tamanhoFonte;
    /**
     * O construtor da classe é reponsavel por garantir um estado válido de objeto
     * inicializando variaveis e chamando o método pertinente ao objeto.
     */
    public TirosRestantes(String texto, int tamanhoFonte)
    {
        this.texto = texto;
        this.tamanhoFonte = tamanhoFonte;
        atualizarImagem();
    }
    /**
     * Define um novo valor para o atributo texto
     * e chama o método para que a mudança seja
     * refletida para o usuário.
     */
    public void setText(String texto)
    {
        this.texto = texto;
        atualizarImagem();
    }
    /**
     * Atualiza a informação com o novo texto de quantos
     * tiros ainda restam.
     */
    private void atualizarImagem()
    {
        imagem = new GreenfootImage(texto, tamanhoFonte, Color.BLACK, new Color(0, 0, 0, 0));
        setImage(imagem);
    }
}
