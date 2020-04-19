package com.avatarduel.component;

/**
 * ISummoned is the interface for cards that gets summoned
 */
public interface ISummoned {

    /**
     * Changes card from attack position to defense position and vice versa
     */
    void rotate();

    /**
     * Returns attack if is in attack position, defense if in defense
     * @return attack value if in attack position, defense value otherwise
     */
    int getPositionValue();

    /**
     * Returns the summoned character this class represents
     * @return
     */
    Card getCardInstance();
}