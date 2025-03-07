import greenfoot.*; 

/**
 * A classe avião de suprimentos
 * @author Maycon 
 * @version 15/12/2024
 */

public class AviaoDeSuprimentos extends Actor
{
    private GreenfootImage aviao;
    private int intervaloEntreMunicoes;
    private int intervaloEntreMudancaDeAngulo;
    private int angulo;
    /**
     * O construtor da classe é reponsavel por garantir um estado válido de objeto
     * inicializando variaveis e chamando o método pertinente ao objeto.
     */
    public AviaoDeSuprimentos(){
        intervaloEntreMunicoes = 0;
        intervaloEntreMudancaDeAngulo = 0;
        angulo = 45;
        definirImagemPadrao(); 
    }
    /**
     * O método act() é responsável por chamar os métodos que definem a velocidade do 
     * avião, que mudam sua direção e que define quando adicionar munições ao mundo.
     */
    public void act()
    {
        move(3);
        estaNaBorda();
        mudarDeAngulo();
        intervaloEntreEntregasMunicoes();
    }
    /**
     * Método para que as direções do voo do avião 
     * aconteçam de maneira aleatoria.
     */
    public void mudarDeAngulo(){
        intervaloEntreMudancaDeAngulo++;
        if(intervaloEntreMudancaDeAngulo >= 50){
            int angulo = Greenfoot.getRandomNumber(90)-45;
            turn(angulo);
            intervaloEntreMudancaDeAngulo = 0;
        }
    }
    /**
     * Muda de direção se o avião atingir a borda do mundo
     */
    public void estaNaBorda(){
        if(isAtEdge()){
            turn(180);
        }
    }
    /**
     * Monitora o intervalo em que as municoes devem ser deixadas
     * no campo de batalha
     */
    public void intervaloEntreEntregasMunicoes(){
        intervaloEntreMunicoes++;
        if (intervaloEntreMunicoes >= 800){
            entregarMunicoes();
            intervaloEntreMunicoes = 0;
        }
    }
    /**
     * Deixa municoes no mundo de modo que o tanque do jogador tenha saida caso suas 
     * municoes iniciais acabem
     */
    public void entregarMunicoes(){
        Municao municao = new Municao();
        getWorld().addObject(municao, getX(), getY());
    }
    /**
     * O método definirImagemPadrao() é usado para construir a imagem inicial do aviao
     * diminuindo sua imagem original visto que era muito grande
     */
    public void definirImagemPadrao(){
        aviao = getImage(); 
        aviao.scale(50, 50);
        setImage(aviao);
    }
}

