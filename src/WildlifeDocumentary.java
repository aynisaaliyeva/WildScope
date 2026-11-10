public class WildlifeDocumentary extends Documentary implements Recommendable, Educational {
    private String mainAnimal;

    public WildlifeDocumentary(String title, int duration, String mainAnimal) {
        super(title, "Wildlife", duration);
        this.mainAnimal = mainAnimal;
    }

    public String getMainAnimal() {
        return mainAnimal;
    }
    @Override
    public String getType() {
        return "Wildlife";
    }

    @Override
    public String toString() {
        return super.toString() + " | mainAnimal=" + mainAnimal;
    }
    @Override
    public boolean isRecommended() {
        return getRating() >= 7;
    }
}
