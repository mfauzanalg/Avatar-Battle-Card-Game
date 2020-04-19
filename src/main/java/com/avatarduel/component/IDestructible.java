package com.avatarduel.component;

/**
 * IDestructible is the interface for cards that can be destroyed and needs to be removed later on
 */
interface IDestructible {
    
    /**
     * Removes card from board
     */
    void destroy();
}