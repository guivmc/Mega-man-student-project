package mega_man;

import Entities.EntityManager;
import Graphic.GameCamera;
import Input.KeyManager;
import Levels.Level;
import States.GameState;
import States.HelpState;
import States.MenuState;
import States.PausedState;
import States.State;


public class Handler 
{
    private Game game;
    private Level level;
    private State gameState, menuState, helpState, pausedState;
    
    private boolean paused;
    
    public Handler(Game game)
    {
        this.game = game;
        
        gameState = new GameState(this);
        menuState = new MenuState(this);
        helpState = new HelpState(this);
        pausedState = new PausedState(this);
        
        paused = false;
    }
    
    
    //Sets
    public void setGame(Game game)
    {
        this.game = game;
    }
    
    public void setLevel(Level level)
    {
        this.level = level;
    }
    
    public void setState(State state)
    {
        State.setState(state);
    }
    
    public void setPaused(boolean isPaused)
    {
        this.paused = isPaused;
    }
    
    //Gets
    public Game getGame()
    {
        return game;
    }
    
    public Level getLevel()
    {
        return level;
    }
    
    public int getWindowWidth()
    {
        return game.getWidth();
    }
    
    public int getWindowHeight()
    {
        return game.getHeight();
    }
    
    public KeyManager getKeyManager()
    {
        return game.getKeyManager();
    }
    
    public GameCamera getGameCamera()
    {
        return game.getGameCamera();
    }
    
    public boolean getPaused()
    {
        return paused;
    }
   
   
    
    //GetStates
    public State getMenuState()
    {
        return menuState;
    }
    
    public State getHelpState()
    {
        return helpState;
    }
    
    public State getGameState()
    {
        return gameState;
    }
    
    public State getPausedState()
    {
        return pausedState;
    }
}