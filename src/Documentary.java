public abstract class Documentary implements Comparable<Documentary> {

    private String title;
    private String category;
    private int duration;
    private double rating;
    private boolean watched;

    public Documentary(String title, String category, int duration) {
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.rating = 0.0;
        this.watched = false;

    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getDuration() {
        return duration;
    }

    public double getRating() {
        return rating;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setRating(double rating) throws InvalidRatingException {

        if (rating < 0 || rating > 10) {
            throw new InvalidRatingException(
                    "Rating must be between 0 and 10, but got " + rating
            );
        }

        this.rating = rating;
    
    }

    public void markAsWatched() {
        watched = true;
    }

    @Override
    public int compareTo(Documentary other) {
        return Double.compare(other.rating, this.rating);
    }

    public abstract String getType();
    
    @Override
    public String toString() {
        return "Documentary{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                ", watched=" + watched +
                '}';
    }

}

