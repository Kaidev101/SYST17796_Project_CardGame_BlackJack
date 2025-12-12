/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * @author Group Not Done
 */

public abstract class Player {

    private String name; // the unique name for this player

    public Player(String name) {
        this.name = name;
    }

    //@return the player name
    public String getName() {
        return name;
    }

    //@param name the player name to set
    public void setName(String name) {
        this.name = name;
    }

    public abstract void play();
}

