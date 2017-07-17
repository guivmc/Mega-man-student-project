package Graphic;

import java.awt.image.BufferedImage;


public class Assets
{
    public static final int playerW = 25, playerH = 25, TILE = 16;
    
    //State image
    public static BufferedImage logo;
    
    //tile set 2
    public static BufferedImage brokenfence, rocks, backgroundGreen,
                                street1, street2,
                                brokenstreet1, brokenstreet2,
                                pipes1, pipes2, pipeUp, pipeDown,
                                car, upperGrave, bottomGrave, trashBlockB;
    //player sheet
    public static BufferedImage[] playerIdleL, playerIdleR, playerWalkL, playerWalkR, playerClimb, playerWalkAttackL, playerWalkAttackR;
    public static BufferedImage playerAttackIdleL, playerAttackIdleR, 
                                playerAttackJumpL, playerAttackJumpR,
                                playerJumpL, playerJumpR;
                                
    
    //Bosses sheet
    public static BufferedImage[] trashManEnter, trashManAttack, trashManAttackSides, trashManAttackUp;
    public static BufferedImage trashManIdle, trashManAttackIdle, trashManAttackSidesIdle, trashManAttackUpIdle;
    
    public static void init()
    {
        //State sheet                      
        SpriteSheet stateSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/Mega-Man-logo.png"));
        logo = stateSheet.crop(0, 150, 630, 130);
        
        //tile sheet
        SpriteSheet trashManStage = new SpriteSheet(ImageLoader.loadImage("/res/textures/TrashManStage.png"));
        
        backgroundGreen = trashManStage.crop(TILE * 8, TILE * 7, TILE, TILE);
        
        brokenfence = trashManStage.crop(0, 0, TILE, TILE);
        
        rocks = trashManStage.crop(TILE, 0, TILE, TILE);
        
        street1 = trashManStage.crop(0, TILE, TILE, TILE);
        street2 = trashManStage.crop(0, TILE * 2, TILE, TILE);
        brokenstreet1 = trashManStage.crop(TILE * 2, 0, TILE, TILE);
        brokenstreet2 = trashManStage.crop(TILE * 3, 0, TILE, TILE);
        
        pipes1 = trashManStage.crop(TILE * 4, 0, TILE, TILE);
        pipes2 = trashManStage.crop(TILE * 5, 0, TILE, TILE);
        pipeUp = trashManStage.crop(TILE * 4, TILE, TILE, TILE);
        pipeDown = trashManStage.crop(TILE * 5, TILE, TILE, TILE);
        
        
        
        //StaticEntity
        car = trashManStage.crop(TILE * 4, TILE * 7, TILE * 5, TILE * 2);
        
        upperGrave = trashManStage.crop(TILE * 3, TILE * 10, TILE * 3, TILE * 3);
        bottomGrave = trashManStage.crop(TILE * 6, TILE * 10, TILE * 3, TILE * 2);
        
        trashBlockB = trashManStage.crop( 0, TILE * 10, TILE * 2, TILE * 2);
        
        
        //load player sheet
        SpriteSheet playerSheetL = new SpriteSheet(ImageLoader.loadImage("/res/textures/mega2.png")); 
        SpriteSheet playerSheetR = new SpriteSheet(ImageLoader.loadImage("/res/textures/mega2R.png")); 
        
        
        playerIdleL = new BufferedImage[2];
        playerIdleL[0] = playerSheetL.crop(3, 17, playerW, playerH);
        playerIdleL[1] = playerSheetL.crop(28, 17, playerW, playerH);
        
        playerIdleR = new BufferedImage[2];
        playerIdleR[0] = playerSheetR.crop(653, 17, playerW, playerH);
        playerIdleR[1] = playerSheetR.crop(628, 17, playerW, playerH);
        
        playerWalkL = new BufferedImage[3];
        playerWalkL[0] = playerSheetL.crop(83, 17, playerW, playerH);
        playerWalkL[1] = playerSheetL.crop(105, 17, playerW, playerH);
        playerWalkL[2] = playerSheetL.crop(130, 17, playerW, playerH);
        
        playerWalkR = new BufferedImage[3];//577, 550, 526
        playerWalkR[0] = playerSheetR.crop(577, 17, playerW, playerH);
        playerWalkR[1] = playerSheetR.crop(550, 17, playerW, playerH);
        playerWalkR[2] = playerSheetR.crop(526, 17, playerW, playerH);
        
        playerClimb = new BufferedImage[2];
        playerClimb[0] = playerSheetL.crop(220, 13, playerW, playerH);
        playerClimb[1] = playerSheetR.crop(440, 13, playerW, playerH);
        
        playerWalkAttackL = new BufferedImage[3];
        playerWalkAttackL[0] = playerSheetL.crop(325, 17, 30, playerH);
        playerWalkAttackL[1] = playerSheetL.crop(355, 17, 30, playerH);
        playerWalkAttackL[2] = playerSheetL.crop(391, 17, 30, playerH);
        
        playerWalkAttackR = new BufferedImage[3];
                                                //327
        playerWalkAttackR[0] = playerSheetR.crop(327, 17, 30, playerH);
                                                //297
        playerWalkAttackR[1] = playerSheetR.crop(297, 17, 30, playerH);
                                                //260
        playerWalkAttackR[2] = playerSheetR.crop(260, 17, 30, playerH);
        
        playerJumpL = playerSheetL.crop(193, 10, 28, 30);
        
        playerJumpR = playerSheetR.crop(460, 10, 28, 30);
        
        playerAttackIdleL = playerSheetL.crop(293, 17, 30, playerH);
        playerAttackIdleR = playerSheetR.crop(360, 17, 30, playerH);
        
        playerAttackJumpL = playerSheetL.crop(425, 10, 31, 30);
        playerAttackJumpR = playerSheetR.crop(228, 10, 30, 30);
        
        //Bosses sheet
        SpriteSheet bossSheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/bosses.png"));
        
        //Trash Man
        trashManEnter = new BufferedImage[5];
        trashManEnter[0] = bossSheet.crop(20, 492, 22, 30);
        trashManEnter[1] = bossSheet.crop(62, 492, 22, 30); 
        trashManEnter[2] = bossSheet.crop(104, 492, 22, 30);  
        trashManEnter[3] = bossSheet.crop(146, 492, 22, 30);  
        trashManEnter[4] = bossSheet.crop(188, 492, 22, 30);  
        
        trashManIdle = bossSheet.crop(230, 492, 22, 30);
        
        trashManAttack = new BufferedImage[4];
        trashManAttack[0] = bossSheet.crop(268, 492, 28, 30);
        trashManAttack[1] = bossSheet.crop(352, 492, 28, 30);
        trashManAttack[2] = bossSheet.crop(394, 492, 43, 30);
        trashManAttack[3] = bossSheet.crop(436, 492, 43, 30);
        
        trashManAttackIdle = bossSheet.crop(436, 492, 43, 30);
        
        trashManAttackSides = new BufferedImage[3];
        trashManAttackSides[0] = bossSheet.crop(478, 492, 22, 30);
        trashManAttackSides[1] = bossSheet.crop(519, 492, 43, 30);
        trashManAttackSides[2] = bossSheet.crop(561, 492, 43, 30);
        
        trashManAttackSidesIdle = bossSheet.crop(561, 492, 43, 30);
        
        trashManAttackUp = new BufferedImage[4];
        trashManAttackUp[0] = bossSheet.crop(606, 494, 22, 30);
        trashManAttackUp[1] = bossSheet.crop(648, 494, 22, 30);
        trashManAttackUp[2] = bossSheet.crop(690, 492, 26, 30);
        trashManAttackUp[3] = bossSheet.crop(732, 492, 26, 30);
        
        trashManAttackUpIdle = bossSheet.crop(732, 492, 26, 30);
    }
}
