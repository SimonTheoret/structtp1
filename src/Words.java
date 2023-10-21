public interface Words {
    /* Public interface for the containers of words. Every container must
    implement a method to verify if a word is part of the container */
    public boolean verifyIfWordExists(String w);
    public boolean verifyIfPartialWordExists(String w);
}
