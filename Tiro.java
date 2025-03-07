import greenfoot.*;  

/**
 * Classe para os tiros disparados pelos tanques.
 * @author Maycon
 * @version 18/12/2024
 * 
 */
public class Tiro extends Actor{
    /**
     * Construtor da classe
     */
    public Tiro()
    {
        definirImagemDoTiro();       
    }
    /**
     * Define as ações do objeto
     */
    public void act()
    {
        move(10);
        estaNaBorda();
    }
    /**
     * Remove o objeto tiro do mundo se ele atingir a borda
     */
    public void estaNaBorda(){
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
    /**
     * Método usado para definir a imagem do tiro
     * ja que o projetil será simplesmente uma "imagem"
     * vermelha que se desloca no mundo
     */
    public void definirImagemDoTiro(){
        // Define a imagem do tiro
        GreenfootImage tiro = new GreenfootImage(10, 5); 
        tiro.setColor(Color.RED);
        tiro.fillRect(0, 0, 10, 5);
        setImage(tiro); 
    }
}
