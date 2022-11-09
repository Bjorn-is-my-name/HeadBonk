package Head_Bonk.Sprites;

import Head_Bonk.Game;
import Head_Bonk.GameClasses.Levels;
import Head_Bonk.GameClasses.Timer;
import Head_Bonk.ImageLoader;
import Head_Bonk.PlayerStates.DirectionState;
import Head_Bonk.PlayerStates.MovementState;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    public AffineTransform tx;
    public AffineTransformOp op;
    public int width;
    public int widthBeforeSlice;
    public int height;
    public int x;
    public int xBeforeJump;
    public int xAfterJump;
    public int y;
    public int yBeforeJump;
    public int yAfterJump;
    public boolean dustBeforeShowed = true;
    public boolean dustAfterShowed = true;
    public int horizontalSpeed;
    public int verticalSpeed;
    public String state;
    public String direction;
    public static boolean jumping = false;
    public static boolean falling = false;
    public static boolean slicing = false;
    public double velocity;
    public int collisionHeight;
    public boolean sideCollision = false;
    public boolean blockLeft = false;
    public boolean blockRight = false;
    public static int coins;

    public ArrayList<BufferedImage> temp = new ArrayList<>();

    public BufferedImage playerIdleStrip = ImageLoader.loadImage("/player/idle_strip.png");
    public ArrayList<BufferedImage> leftPlayerIdleImages = new ArrayList<>();
    public ArrayList<BufferedImage> rightPlayerIdleImages = new ArrayList<>();

    public BufferedImage playerRunStrip = ImageLoader.loadImage("/player/run_strip.png");
    public ArrayList<BufferedImage> leftPlayerRunImages = new ArrayList<>();
    public ArrayList<BufferedImage> rightPlayerRunImages = new ArrayList<>();

    public BufferedImage jumpUpStrip = ImageLoader.loadImage("/player/jump_up_strip.png");
    public ArrayList<BufferedImage> leftJumpUpImages = new ArrayList<>();
    public ArrayList<BufferedImage> rightJumpUpImages = new ArrayList<>();

    public BufferedImage beforeJumpStrip = ImageLoader.loadImage("/player/before_jump_strip.png");
    public ArrayList<BufferedImage> beforeJumpImages = new ArrayList<>();

    public BufferedImage jumpDownStrip = ImageLoader.loadImage("/player/jump_down_strip.png");
    public ArrayList<BufferedImage> leftJumpDownImages = new ArrayList<>();
    public ArrayList<BufferedImage> rightJumpDownImages = new ArrayList<>();

    public BufferedImage afterJumpStrip = ImageLoader.loadImage("/player/after_jump_strip.png");
    public ArrayList<BufferedImage> afterJumpImages = new ArrayList<>();

    public BufferedImage sliceStrip = ImageLoader.loadImage("/player/slice_strip.png");
    public ArrayList<BufferedImage> sliceRightImages = new ArrayList<>();
    public ArrayList<BufferedImage> sliceLeftImages = new ArrayList<>();

    public int currentImg;
    public int currentIdleImg;
    public int currentDustBeforeImg;
    public int currentDustAfterImg;

    public Player(){
        width = 22;
        height = 32;
        x = 0;
        y = 0;
        horizontalSpeed = 4;
        verticalSpeed = 10;
        state = MovementState.IDLE;
        direction = DirectionState.RIGHT;
        currentImg = 0;
        currentDustAfterImg = 0;
        currentDustBeforeImg = 0;

        splitSpriteSheet(playerIdleStrip, rightPlayerIdleImages, 22, height, 2);
        splitSpriteSheet(playerIdleStrip, leftPlayerIdleImages, 22, height, 2);
        flipImages(leftPlayerIdleImages);

        splitSpriteSheet(playerRunStrip, rightPlayerRunImages, 26, height, 6);
        splitSpriteSheet(playerRunStrip, leftPlayerRunImages, 26, height, 6);
        flipImages(leftPlayerRunImages);

        splitSpriteSheet(jumpUpStrip, rightJumpUpImages, 24, height, 3);
        splitSpriteSheet(jumpUpStrip, leftJumpUpImages, 24, height, 3);
        flipImages(leftJumpUpImages);

        splitSpriteSheet(beforeJumpStrip, beforeJumpImages, 24, height, 4);

        splitSpriteSheet(jumpDownStrip, rightJumpDownImages, 24, height, 3);
        splitSpriteSheet(jumpDownStrip, leftJumpDownImages, 24, height, 3);
        flipImages(leftJumpDownImages);

        splitSpriteSheet(afterJumpStrip, afterJumpImages, 24, height, 4);

        splitSpriteSheet(sliceStrip, sliceRightImages, 32 * 2, height, 4);
        splitSpriteSheet(sliceStrip, sliceLeftImages, 32 * 2, height, 4);
        flipImages(sliceLeftImages);
    }

    public void move(){
        if (!blockBelow() && !jumping && y + height != Game.HEIGHT){
            if (!falling) {
                falling = true;
                velocity = 0;
                currentImg = 0;
            }
            if (y + height >= Game.HEIGHT){
                y = Game.HEIGHT - height;
                falling = false;
                return;
            }
            y -= velocity;
            if (velocity > -verticalSpeed) {
                velocity -= 0.5;
            }
            width = 24;
        }
        if (blockBelow() || y + height == Game.HEIGHT){
            falling = false;
        }
        if (Game.aPressed && !blockLeft){
            x -= horizontalSpeed;
            if (!direction.equals(DirectionState.LEFT)) {
                direction = DirectionState.LEFT;
                if (!slicing) {
                    currentImg = 0;
                }
            }
            if (!state.equals(MovementState.MOVING) && !jumping && !slicing){
                state = MovementState.MOVING;
                currentImg = 0;
                width = 26;
            }
        }
        else if (Game.aPressed && jumping){
            state = MovementState.JUMPING;
        }
        else if (Game.aPressed){
            state = MovementState.IDLE;
        }
        if (Game.dPressed && !blockRight) {
            x += horizontalSpeed;
            if (!direction.equals(DirectionState.RIGHT)) {
                direction = DirectionState.RIGHT;
                if (!slicing) {
                    currentImg = 0;
                }
            }
            if (!state.equals(MovementState.MOVING) && !jumping && !slicing) {
                state = MovementState.MOVING;
                currentImg = 0;
                width = 26;
            }
        }
        else if (Game.dPressed && jumping){
            state = MovementState.JUMPING;
        }
        else if (Game.dPressed){
            state = MovementState.IDLE;
        }
        if ((!Game.aPressed && !Game.dPressed) || (Game.aPressed && Game.dPressed)){
            if (!state.equals(MovementState.IDLE) && !jumping && !slicing) {
                state = MovementState.IDLE;
                currentImg = 0;
                width = 22;
            }
        }
        if (Game.spacePressed){
            if (!jumping) {
                jumping = true;
                velocity = verticalSpeed;
                state = MovementState.JUMPING;
                xBeforeJump = x;
                yBeforeJump = y;
                dustBeforeShowed = false;
                dustAfterShowed = true;
                width = 24;
                if (!slicing) {
                    currentImg = 0;
                }
            }
            y -= velocity;
            if (velocity > -verticalSpeed) {
                velocity -= 0.5;
            }
        }
        if (Game.leftClicked){
            if (!slicing){
                slicing = true;
                currentImg = 0;
                widthBeforeSlice = width;
                width = 32;
            }
            if (currentImg == 4){
                slicing = false;
                Game.leftClicked = false;
                width = widthBeforeSlice;
            }
        }
    }

    public boolean blockBelow(){
        int row = y / Game.TILE_SIZE + 1;
        int columnLeft = x / Game.TILE_SIZE;
        int columnRight = (x + width) / Game.TILE_SIZE;
        for (ArrayList<Integer> tile: Game.tileCoordinates){
            if (tile.get(0) / Game.TILE_SIZE == columnLeft && tile.get(1) / Game.TILE_SIZE == row || tile.get(0) / Game.TILE_SIZE == columnRight && tile.get(1) / Game.TILE_SIZE == row){
                collisionHeight = tile.get(1);
                return true;
            }
        }
        return false;
    }

    public void collisionCheck(){
        sideCollision = false;
        blockRight = false;
        blockLeft = false;

        if (x - horizontalSpeed < 0){
            x = 1;
            blockLeft = true;
            sideCollision = true;
        }
        if (x + width + horizontalSpeed > Game.WIDTH){
            x = Game.WIDTH - width - 1;
            blockRight = true;
            sideCollision = true;
        }
        if (y - velocity < 0){
            y = 1;
            velocity = 0;
        }

        if ((y >= Game.doorCoordinates[1] && y + height <= Game.doorCoordinates[1] + (2 * Game.TILE_SIZE) && y + height > Game.doorCoordinates[1]) && (x >= Game.doorCoordinates[0] && x + width <= Game.doorCoordinates[0] + (2 * Game.TILE_SIZE) && x + width > Game.doorCoordinates[0])){
            Game.setMapTime((double) Math.round((double) Timer.stop() / 60 * 100) / 100);
            Game.inGame = false;
            Game.inLevelMenu = true;
            Game.spacePressed = false;
            Game.leftClicked = false;
            Game.enterPressed = false;
            jumping = false;
            falling = false;
            x = 0;
            y = 0;
            Game.tileCoordinates = new ArrayList<>();
            Levels.clearLevelObjects(Game.currentLevel);
        }

        for (int i = 0; i < Game.currentMapInteractableBgObjects.size(); i++){
            if (Game.currentMapInteractableBgObjects.get(i).get(0) == 106) {
                int cx = Game.currentMapInteractableBgObjects.get(i).get(1) * Game.TILE_SIZE;
                int cy = Game.currentMapInteractableBgObjects.get(i).get(2) * Game.TILE_SIZE;
                if (((y >= cy && y <= cy + 16) || (y + height >= cy && y + height <= cy + 16) || (y + height / 2 >= cy && y + height / 2 <= cy + 16)) && ((x >= cx + 8 && x <= cx + 24) || (x + width >= cx + 8 && x + width <= cx + 24) || (x + width / 2 >= cx + 8 && x + width / 2 <= cx + 24))) {
                    Game.currentMapInteractableBgObjects.get(i).set(0, 107);
                    coins++;
                }
            }
        }

        for (ArrayList<Integer> tile: Game.tileCoordinates){
            if ((y / Game.TILE_SIZE == tile.get(1) / Game.TILE_SIZE) && (x + horizontalSpeed < tile.get(0) && x + width + horizontalSpeed > tile.get(0) && x + width + horizontalSpeed < tile.get(0) + Game.TILE_SIZE)) {
                sideCollision = true;
                blockRight = true;
                x = tile.get(0) - width - 1;
            }
            else if (jumping && ((y + height) / Game.TILE_SIZE == tile.get(1) / Game.TILE_SIZE) && (x + horizontalSpeed < tile.get(0) && x + width + horizontalSpeed > tile.get(0) && x + width + horizontalSpeed < tile.get(0) + Game.TILE_SIZE)){
                sideCollision = true;
                blockRight = true;
                if (!blockBelow()) x = tile.get(0) - width - 1;
            }

            if ((y / Game.TILE_SIZE == tile.get(1) / Game.TILE_SIZE) && (x - horizontalSpeed < tile.get(0) + Game.TILE_SIZE && x - horizontalSpeed > tile.get(0) && x + width - horizontalSpeed > tile.get(0) + Game.TILE_SIZE)) {
                sideCollision = true;
                blockLeft = true;
                x = tile.get(0) + Game.TILE_SIZE + 1;
            }
            else if (jumping && ((y + height) / Game.TILE_SIZE == tile.get(1) / Game.TILE_SIZE) && (x - horizontalSpeed < tile.get(0) + Game.TILE_SIZE && x - horizontalSpeed > tile.get(0) && x + width - horizontalSpeed > tile.get(0) + Game.TILE_SIZE)){
                sideCollision = true;
                blockLeft = true;
                if (!blockBelow()) x = tile.get(0) + Game.TILE_SIZE + 1;
            }

            if ((y - velocity <= tile.get(1) + Game.TILE_SIZE && y - velocity > tile.get(1)) && ((x >= tile.get(0) && x <= tile.get(0) + Game.TILE_SIZE && x + width > tile.get(0) + Game.TILE_SIZE) || (x + width >= tile.get(0) && x + width <= tile.get(0) + Game.TILE_SIZE && x < tile.get(0)) || (x >= tile.get(0) && x <= tile.get(0) + Game.TILE_SIZE && x + width >= tile.get(0) && x + width <= tile.get(0) + Game.TILE_SIZE))){
                y = tile.get(1) + Game.TILE_SIZE;
                velocity = 0;
            }

            if ((y / Game.TILE_SIZE + 1 == tile.get(1) / Game.TILE_SIZE) && (y + height > tile.get(1)) && ((x >= tile.get(0) && x <= tile.get(0) + Game.TILE_SIZE) || (x + width >= tile.get(0) && x + width <= tile.get(0) + Game.TILE_SIZE))) {
                y = tile.get(1) - height;
                if (jumping) {
                    jumping = false;
                    Game.spacePressed = false;
                    dustAfterShowed = false;
                    xAfterJump = x;
                    yAfterJump = y;
                }
                if (falling) {
                    falling = false;
                }
            }
        }
    }

    public void draw(Graphics g){
        switch (state) {
            case MovementState.IDLE:
                if (!falling && !slicing) {
                    currentIdleImg = currentImg / 6;
                    if (direction.equals(DirectionState.LEFT)) {
                        g.drawImage(leftPlayerIdleImages.get(currentIdleImg % 2), x, y, null);
                    } else if (direction.equals(DirectionState.RIGHT)) {
                        g.drawImage(rightPlayerIdleImages.get(currentIdleImg % 2), x, y, null);
                    }
                }
                break;
            case MovementState.MOVING:
                if (!falling && !slicing) {
                    if (direction.equals(DirectionState.LEFT)) {
                        g.drawImage(leftPlayerRunImages.get(currentImg % 6), x, y, null);
                    } else if (direction.equals(DirectionState.RIGHT)) {
                        g.drawImage(rightPlayerRunImages.get(currentImg % 6), x, y, null);
                    }
                }
                break;
            case MovementState.JUMPING:
                if (!slicing) {
                    if (velocity >= 0) {
                        if (direction.equals(DirectionState.LEFT)) {
                            g.drawImage(leftJumpUpImages.get(currentImg % 3), x, y, null);
                        } else if (direction.equals(DirectionState.RIGHT)) {
                            g.drawImage(rightJumpUpImages.get(currentImg % 3), x, y, null);
                        }
                    }
                    if (velocity < 0) {
                        if (direction.equals(DirectionState.LEFT)) {
                            g.drawImage(leftJumpDownImages.get(currentImg % 3), x, y, null);
                        } else if (direction.equals(DirectionState.RIGHT)) {
                            g.drawImage(rightJumpDownImages.get(currentImg % 3), x, y, null);
                        }
                    }
                }
                break;
        }
        if (falling && !jumping){
            if (direction.equals(DirectionState.LEFT)) {
                g.drawImage(leftJumpDownImages.get(currentImg % 3), x, y, null);
            } else if (direction.equals(DirectionState.RIGHT)) {
                g.drawImage(rightJumpDownImages.get(currentImg % 3), x, y, null);
            }
        }
        if (slicing){
            if (direction.equals(DirectionState.LEFT)) {
                g.drawImage(sliceLeftImages.get(currentImg % 4), x - Game.TILE_SIZE, y, null);
            } else if (direction.equals(DirectionState.RIGHT)) {
                g.drawImage(sliceRightImages.get(currentImg % 4), x, y, null);
            }
        }
        if (!dustBeforeShowed) {
            if (currentDustBeforeImg  == 4){
                dustBeforeShowed = true;
                currentDustBeforeImg = 0;
            }
            if (currentDustBeforeImg == 0) return;
            g.drawImage(beforeJumpImages.get(currentDustBeforeImg % 4), xBeforeJump, yBeforeJump, null);
        }
        if (!dustAfterShowed) {
            if (currentDustAfterImg == 4){
                dustAfterShowed = true;
                currentDustAfterImg = 0;
            }
            if (currentDustAfterImg == 0) return;
            g.drawImage(afterJumpImages.get(currentDustAfterImg % 4), xAfterJump, yAfterJump, null);
        }
    }

    public void splitSpriteSheet(BufferedImage sheet, ArrayList<BufferedImage> list, int width, int height, int length){
        for (int i = 0; i < length; i++){
            list.add(sheet.getSubimage(i * width, 0, width, height));
        }
    }

    public void flipImages(ArrayList<BufferedImage> list){
        for (BufferedImage image : list){
            tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-image.getWidth(null), 0);
            op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            image = op.filter(image, null);
            temp.add(image);
        }
        Collections.copy(list, temp);
        temp.clear();
    }
}
