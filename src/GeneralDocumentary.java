public class GeneralDocumentary extends Documentary {

    public GeneralDocumentary(String title, String category, int duration) {
        super(title, category, duration);
    }

    public GeneralDocumentary(String title, int duration) {
        this(title, "General", duration);
    }

    @Override
    public String getType() {
        return "General";
    }
}