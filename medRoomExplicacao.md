# Mega-man-student-project

Atenção: foi pedido que o jogo seja desenvolvido unsando uma framework, porém eu desenvolvi o que pode ser muito bem
considerado uma framework, como por exemplo a clase Entity.

Pacotes:

  Entities:
    Neste pacote você encontrará a framework Entity e Creature que servem de base para criação de todos os personagens, sejam eles
    jogadores, inimigos ou apenas objetos interativos, como o disparo da arma. Também há um gerenciador de entidades que serve para gerenciar
    esses personagens na tela.
  
  Graphic: 
    Aqui temos de o pocato resposável por carregar as imagens (Sprites e Texturas), gerenciar animções de entidades e controlar a
    câmera do jogador.
  
  Input:
    Gerencia as teclas predefinidas para o jogo.
    
   Level:
    Gerencia os níveis do jogo.
    
   Satate:
    Framework que controla o estado do jogo, ou seja, diz quando o jogo deve apresentar o menu, o level e a tela de pause.
    
   Tiles:
    Pacote dedicado ao controle das texturas
    
   Utils:
    Pacote dedicado a controlar possíveis erros ao carregar uma textura, evitando assim um crash.
      
   Mega-Man:
    Aqui temos a framework Game(Engine) e Display, elas servem para se dar início ao programa e a tela grafica. Laucher é a classe Main.
    Handler serve para auxiliar na comunicação entre Game, entidades, teclas e estados de jogo.
   
   Res:
    Apenas imagens e fontes utilizadas no jogo.
 
 Notas: Em meu github é possível encontrar outros projetos similares desenvolvidos em C++ porém que estão ainda em desenvolvimento,
 como o Pokemon test e o SFMl_Project.
 Este jogo aqui tem bugs.
 
    
      
