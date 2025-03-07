import greenfoot.*; 

/**
 * A classe municao define um ator que será inserido no mundo 
 * e será recolhido pelo tanque do jogador com a intenção de incrementar
 * seus tiros.
 * @author Maycon
 * @version 18/12/2024
 */
public class Municao extends Actor
{   
    private GreenfootImage municao;
    /**
     * Construtor que chama o método responsavel pela
     * configuração padronizada na munição
     */
    public Municao(){
        definirImagemPadrao();
    }
    /**
     * Define os padrões para a imagem do ator munição
     */    
    public void definirImagemPadrao(){
        municao = getImage(); 
        municao.scale(50, 50);
        setImage(municao);
    }
}
