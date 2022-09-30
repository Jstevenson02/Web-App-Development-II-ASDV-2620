package asdv.slcc.beans;

public class Author implements java.io.Serializable, Comparable<Author> {

    private String first;
    private String last;
    private String bio;

    public Author() {
        this.first = null;
        this.last = null;
        this.bio = null;
    }

    public Author(String first, String last, String bio) {
        this.first = first;
        this.last = last;
        this.bio = bio;
    }

    /**
     * @return the first
     */
    public String getFirst() {
        return first;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * @return the last
     */
    public String getLast() {
        return last;
    }

    /**
     * @param last the last to set
     */
    public void setLast(String last) {
        this.last = last;
    }

    /**
     * @return the bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * @param bio the bio to set
     */
    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public int compareTo(Author o) {
        return this.last.compareTo(o.last);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Author == false) {
            return false;
        }
        if (this.last.compareTo(((Author) o).last) == 0) {
            return true;
        }
        return false;
    }

}
