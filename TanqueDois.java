import greenfoot.*; 

/**
 * A classe TanqueDois é responsavel pelos objetos que tentaram abater
 * o tanque do jogador e os métodos pertinentes.
 * @author Maycon 
 * @version 15/12/2024
 */

public class TanqueDois extends Actor
{
    private GreenfootImage tanque;
    private GreenfootImage armaDoTanque;
    // Intervalo entre os tiros do tanque
    private int tempoDeCarregamento;
    
    /**
     * O construtor da classe é reponsavel por garantir um estado válido de objeto
     * inicializando variaveis e chamando o método pertinente ao objeto.
     */
    public TanqueDois(){
        tempoDeCarregamento = 0;
        definirImagemPadrao();
    }
    /**
     * O método act() é responsável por chamar métodos pertinentes 
     * as ações de tamque e tomar as devidas decisões a partir disso.
     */
    public void act()
    {
        move(6);
        estaNaBorda();
        mudarDeDirecao();
        atirarEntreIntervalos();
        levouTiro();
    }
    /**
     * A cada 75 chamadas do método 1 disparo é efetuado.
     */
    public void atirarEntreIntervalos(){
        tempoDeCarregamento++;
        if (tempoDeCarregamento >= 70)
        {
            atirar();
            tempoDeCarregamento = 0; 
        }
    }
    /**
     * Método para que as direções do trajeto do tanque
     * aconteçam de maneira aleatoria.
     */
    public void mudarDeDirecao(){
        if(Greenfoot.getRandomNumber(100)<=10){
            int angulo = Greenfoot.getRandomNumber(90)-45;
            turn(angulo);
        }
    }
    /**
     * Muda de direção se o tanque atingir a borda do mundo
     */
    public void estaNaBorda(){
        if(isAtEdge()){
            turn(180);
        }
    }
    /**
     * O método atirar() é composto por uma sequência de manipulações de imagens 
     * que criam visualmente um design de tiro.
     */
    public void atirar() {
        // Simula o recuo da arma
        movimentarArma(5, 16); 
        // Cria e dispara o projétil
        criarProjetil();
        GreenfootSound somDeTiro = new GreenfootSound("tiro_2.mp3");
        somDeTiro.play();
        Greenfoot.delay(5);
        // Retorna a arma à posição inicial
        movimentarArma(10, 16); 
    }
    /**
     * Cria um objeto do tipo TiroInimigo e o adiciona ao mundo
     */
    private void criarProjetil()
    {
        // Cria um novo tiro e o adiciona ao mundo
        TiroInimigo tiro = new TiroInimigo();
        getWorld().addObject(tiro, getX(), getY());
        // Define a direção do tiro
        tiro.setRotation(getRotation()); 
    }
    /**
     * O método movimentarArma(int posX, int posY) troca a posição da arma do tanque
     * simulando assim o recuo de um tiro
     */
    public void movimentarArma(int posX, int posY){
        setImage("Hull_06b.png");
        tanque = getImage();
        tanque.scale(50, 50);
        tanque.drawImage(armaDoTanque, posX, posY);
    }
    /**
     * O método definirImagemPadrao() é usado para construir a imagem inicial do tanque
     * e sua arma visto que o tanque é composto por duas imagens sobrepostas.
     */
    public void definirImagemPadrao(){
        tanque = getImage(); 
        tanque.scale(50, 50);
    
        armaDoTanque = new GreenfootImage("Gun_04b.png");
        armaDoTanque.scale(40, 17);
        
        int posX = 10; 
        int posY = 16; 

        tanque.drawImage(armaDoTanque, posX, posY);
                    
        setImage(tanque);
        setRotation(-90);
    }
    /**
     * Método para verificar se o tanque foi atingido por algum projetil
     */
    public void levouTiro(){
        Tiro projetil = (Tiro) getOneIntersectingObject(Tiro.class);
        if (projetil != null) 
        {
            serAbatido();  
        }
    }
    /**
     * Remove ao o tanque Inimigo após ser atingido por um tiro
     */
    private void serAbatido() {
        CampoDeBatalhaUm mundo = (CampoDeBatalhaUm) getWorld(); 
        mundo.adicionarPontuacao(100); 
        getWorld().removeObject(this);   
        // Notifica o mundo que um TanqueDois foi destruído e precisa gerar um novo
        mundo.tanqueDoisDestruido();
    }
    
}
