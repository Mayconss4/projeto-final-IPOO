import greenfoot.*; 

/**
 * Tanque que se movimenta e atira automaticamente para dar animação a tela inicial.
 * @author Maycon
 * @version 19/12/2024
 */
public class TanqueAnimado extends Actor
{   
    //Imagens que serão usadas para a formação do tanque
    private GreenfootImage tanqueBase; 
    private GreenfootImage armaBase; 
    private int contadorDeTiros; 
    /**
     * Construtor da classe inicializa variaveis para um estado válido de objeto
     * e chama métos pertinentes também para o bom funcionamento do objeto.
     */
    public TanqueAnimado()
    {
        // Define a imagem do tanque
        definirImagemPadrao();
        contadorDeTiros = 0; 
    }
    /**
     * Define ações do objeto
     */
    public void act()
    {
        // Movimenta o tanque horizontalmente
        move(4);
        estaNaBorda();
        atirarEntreIntervalos();
    }
    /**
     * Muda a direção do objeto quando ele atinge a borda do mundo
     */
    public void estaNaBorda(){
        if(isAtEdge()){
            turn(180);
        }
    }
    /**
     * Dispara um projetil a cada 50 chamadas do método
     */
    public void atirarEntreIntervalos(){
        // Incrementa o contador de tiros
        contadorDeTiros++;
        // Atira automaticamente após o intervalo configurado
        if (contadorDeTiros >= 50) {
            atirar();
            contadorDeTiros = 0; // Reinicia o contador
        }
    }
    /**
     * Cria e adiociona objetos tiro ao mundo.
     */
    private void atirar()
    {
        Tiro tiro = new Tiro();
        getWorld().addObject(tiro, getX(), getY());
        tiro.setRotation(getRotation());
    }
    /**
     * Define a imagem padrão do tanque.
     */
    public void definirImagemPadrao() {
        // Obtém a imagem base associada ao ator
        tanqueBase = new GreenfootImage("Hull_02.png");
        
        // Altera a escala da sprite para 50px-50px (tamanho original estava grande demais)
        tanqueBase.scale(50, 50);
    
        // Carrega a sprite da arma que terá de ser sobreposta
        armaBase = new GreenfootImage("Gun_05.png");
        armaBase.scale(40, 17);
        
        tanqueBase.drawImage(armaBase, 10, 16);
        setImage(tanqueBase);
    }
}
