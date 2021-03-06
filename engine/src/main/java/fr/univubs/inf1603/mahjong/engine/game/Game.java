package fr.univubs.inf1603.mahjong.engine.game;

import fr.univubs.inf1603.mahjong.engine.persistence.Persistable;
import fr.univubs.inf1603.mahjong.engine.rule.GameRule;
import fr.univubs.inf1603.mahjong.engine.rule.Wind;
import java.time.Duration;
import java.util.ArrayList;

/**
 *
 * @author purpl
 */
public interface Game extends Persistable {

    public static final String LAST_PLAYED_MOVE = "lastplayedmove",
            AVAILABLE_MOVES_SIZE_P0 = "availablemovessizep0",
            AVAILABLE_MOVES_SIZE_P1 = "availablemovessizep1",
            AVAILABLE_MOVES_SIZE_P2 = "availablemovessizep2",
            AVAILABLE_MOVES_SIZE_P3 = "availablemovessizep3",
            INDEXED_AVAILABLE_MOVES_P0 = "availablemovesp0",
            INDEXED_AVAILABLE_MOVES_P1 = "availablemovesp1",
            INDEXED_AVAILABLE_MOVES_P2 = "availablemovesp2",
            INDEXED_AVAILABLE_MOVES_P3 = "availablemovesp3",
            CURRENT_WIND = "currentwind";

    /**
     * Permet de récupérer la règles utilisée pour cette partie
     *
     * @return Regle utilisée
     */
    public GameRule getRule();

    /**
     * Permet de lancer la partie
     */
    public void launchGame();

    /**
     * Permet de recuperer le vent de la main actuellement jouée.
     *
     * @return Le vent de la main actuelle.
     * @throws GameException Si la partie n'es pas en cours
     */
    public Wind getCurrentwind() throws GameException;

    /**
     * Ajoute un Move qui sera (ou non), effectué en fonction du context actuel
     * (timing, validité, ...) Un Move peut aussi etre refusé (différent de non
     * jouer) e.g Si un move décrit un changement correspondant à un état de jeu
     * precedent, il sera refusé.
     *
     * @param move Move à considérer
     * @throws GameException Quand un move est refusé, detaille la raison du
     * refus
     */
    public void registerMove(Move move) throws GameException;

    /**
     * @return The time a stealing phase can last up to.
     */
    public Duration getStealingTime();

    /**
     * @return The time a non stealing phase can last up to.
     */
    public Duration getPlayingTime();

    /**
     * Retourne la vision d'un MahjongBoard en fonction du vent MahjongBoard en
     * entier avec les zones non cachées
     *
     * @param wind
     * @return La vision du Board en fonction du vent
     * @throws GameException si cette implementation ne permet pas de voir la
     * vision demandé.
     */
    public Board getBoard(Wind wind) throws GameException;

    /**
     *
     * @return Le dernier Move joué.
     */
    public Move getLastPlayedMove();

    /**
     * Retourne le nombre de points d'un joueur à un instant t
     *
     * @param player Le joueur
     * @return le nombre de points du joueur
     */
    public int getPlayerPoints(int player);

    /**
     * Retourne le nombre de points d'un joueur à un instant t
     *
     * @param wind Le vent du joueur
     * @return le nombre de points du joueur
     */
    public int getPlayerPoints(Wind wind);

    /**
     * Retourne les points de chaque joueur.
     *
     * @return Un tableau de int où l'indince correspond au numero du joueur.
     */
    public int[] getAllPlayerPoints();

    /**
     * @param player Le numéro du joueur dont on veut le vent
     * @return Le vent du joueur correspondant
     * @throws GameException Si la partie n'a pas commencé ou si il existe une
     * incoherence dans Game
     */
    public Wind getPlayerWind(int player) throws GameException;

    /**
     * @param wind Vent du joueur dont on veut le numero
     * @return Le numéro du joueur correspondant
     * @throws GameException Si la partie n'a pas commencé ou si il existe une
     * incoherence dans Game
     */
    public int getPlayerFromWind(Wind wind) throws GameException;

    /**
     * @return Un tableau de vents où l'indice est le numéro du joueur
     * correspondant
     * @throws GameException Si la partie n'a pas commencé ou si il existe une
     * incoherence dans Game
     */
    public Wind[] getPlayerWinds() throws GameException;

    public ArrayList<Move> getPossibleMoves() throws GameException;

    public ArrayList<Move> getPossibleMoves(Wind wind) throws GameException;

    public ArrayList<Move> getPossibleMoves(int player) throws GameException;

}
