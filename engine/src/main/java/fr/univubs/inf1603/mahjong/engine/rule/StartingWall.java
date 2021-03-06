package fr.univubs.inf1603.mahjong.engine.rule;

import fr.univubs.inf1603.mahjong.engine.game.GameTile;
import fr.univubs.inf1603.mahjong.engine.game.Side;
import java.util.ArrayDeque;

/**
 * StartingWall : class can be usefull if we need to display where the breach is formed on the wall
 *
 * @author Abdelilah MOULIDA
 */
public class StartingWall
{
    /**
     * side of the wall where the breach is made
     */
    private Side startingSide;
    /**
     * heap of the wall where the breach is made
     */
    private int startingHeap;
    /**
     * {@link ArrayDeque} representing the tiles in the wall, we chose a deque because
     * drawing from the back of the wall is possible
     */
    private ArrayDeque<GameTile> cut;

    /**
     * Constructor of the object,
     * @param startingSide side of the wall where the breach is made
     * @param startingHeap heap of the wall where the breach is made
     * @param cut {@link ArrayDeque} representing the tiles in the wall
     */
    StartingWall(Side startingSide, int startingHeap, ArrayDeque<GameTile>cut) {
        this.startingSide = startingSide;
        this.startingHeap = startingHeap;
        this.cut = new ArrayDeque<>(cut);
    }

    /**
     * @return the starting side
     */
    public Side getStartingSide() {
        return startingSide;
    }

    /**
     * @return the starting heap
     */
    public int getStartingHeap() {
        return startingHeap;
    }

    /**
     * @return the cut
     */
    public ArrayDeque<GameTile> getCut() {
        return cut;
    }

    /**
     * @param startingSide the starting side to modify
     */
    public void setStartingSide(Side startingSide) {
        this.startingSide = startingSide;
    }

    /**
     * @param startingHeap the starting heap to modify
     */
    public void setStartingHeap(int startingHeap) {
        this.startingHeap = startingHeap;
    }

    /**
     * @param cut the cut to modify
     */
    public void setCut(ArrayDeque<GameTile> cut) {
        this.cut = new ArrayDeque<>(cut);
    }
}
