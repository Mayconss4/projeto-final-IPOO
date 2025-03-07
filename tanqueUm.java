import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A classe TanqueUm é responsável pelo tanque do jogador
 * bem como suas funcionalidades e ações, como atirar, se movimentar e 
 * até mesmo ser abatido.
 * 
 * @author Maycon 
 * @version 16/12/2024
 */
public class TanqueUm extends Actor
{
    private GreenfootImage tanqueBase; 
    private GreenfootImage armaBase; 
    // Atributo que conta os tiros para serem usados na pontuação
    private int contadorDeTiros;
    TirosRestantes tirosRestantes;
    public TanqueUm() {
        contadorDeTiros = 0;
        definirImagemPadrao();
    }
    
    public void act() {
        
        if(getWorld() != null){
            if (Greenfoot.isKeyDown("up")) {
            move(4); 
            }
            
            if (Greenfoot.isKeyDown("down")) {
                move(-4);
            }
           
            if (Greenfoot.isKeyDown("left")) {
                turn(-5); 
            }
            
            if (Greenfoot.isKeyDown("right")) {
                turn(5); 
            }
            
            if (Greenfoot.isKeyDown("f")) {
                atirar();
                contadorDeTiros++;
            }
            if(contadorDeTiros > 100){
                serAbatido();
            }
            if(contadorDeTiros == 0){
                informarTirosRestantes();
                contadorDeTiros++;
            }
            levouTiro();
            recolherMunicao();
        }
    }
    /**
     * Recolhe as munições deixadas pelo avião de suprimentos de modo
     * que novos tiros ficam disponiveis.
     */
    public void recolherMunicao(){
        if (getWorld() != null) { 
            if (isTouching(Municao.class)) {
                removeTouching(Municao.class); 
                if(contadorDeTiros >= 10){
                    contadorDeTiros -= 6;
                }
                atualizarTirosRestantes();
            }
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
        GreenfootSound somDeTiro = new GreenfootSound("tiro.mp3");
        somDeTiro.play();
        Greenfoot.delay(2);
        // Retorna a arma à posição inicial
        movimentarArma(10, 16); 
        
        atualizarTirosRestantes();
    }
    /**
     * Atualiza a informação de tiros restantes para o usuário.
     */
    public void atualizarTirosRestantes(){
        tirosRestantes.setText("Tiros restantes: " + (100 - contadorDeTiros));
    }
    /**
     * Cria um informativo de tiros para o usuario
     */
    public void informarTirosRestantes(){
        tirosRestantes = new TirosRestantes("Tiros Restantes: " + 100, 24);
        getWorld().addObject(tirosRestantes, 350, 30);
    }
    
    /**
     * Cria um objeto do classe Tiro e o adiciona no mundo
     */
    private void criarProjetil() {
        // Cria um novo tiro e o adiciona ao mundo
        Tiro tiro = new Tiro();
        getWorld().addObject(tiro, getX(), getY());
        tiro.setRotation(getRotation()); 
        
    }
    /**
     * Movimenta a arma ao atirar para criar um efeito visual de recuo.
     */
    public void movimentarArma(int posX, int posY) {
        // Cria uma nova imagem baseada na imagem do tanque
        GreenfootImage novaImagem = new GreenfootImage(tanqueBase);
        
        // Redimensiona e sobrepõe a imagem da arma na posição desejada
        GreenfootImage arma = new GreenfootImage(armaBase);
        arma.scale(40, 17);
        novaImagem.drawImage(arma, posX, posY);
        
        // Define a nova imagem como a imagem do tanque
        setImage(novaImagem);
    }
    /**
     * O método definirImagemPadrao() é usado para construir a imagem inicial do tanque
     * e sua arma visto que o tanque é composto por duas imagens sobrepostas.
     */
    public void definirImagemPadrao() {
        // Obtém a imagem base associada ao ator
        tanqueBase = new GreenfootImage("Hull_02.png");
        
        // Altera a escala da sprite para 50px-50px (tamanho original estava grande demais)
        tanqueBase.scale(50, 50);
    
        // Carrega a sprite da arma que terá de ser sobreposta
        armaBase = new GreenfootImage("Gun_05.png");
        armaBase.scale(40, 17);
        
        // Define a posição inicial para sobrepor a imagem da arma
        movimentarArma(10, 16);
        
        // Define a rotação inicial do tanque
        setRotation(-90);
    }
    /**
     * Verifica se o tanque foi atingido por algum projetil
     * e caso tenha sido atingido o tanque é abatido.
     */
    public void levouTiro(){
        TiroInimigo projetil = (TiroInimigo) getOneIntersectingObject(TiroInimigo.class);
        if (projetil != null) 
        {
            serAbatido();  
        }
    }
    /**
     * Caso o tanque tenha sido atingido por algum projetil
     * ou suas balas acabem, ele é abatido.
     */
    private void serAbatido() {
        Greenfoot.setWorld(new Derrota());
    }
}
