public class OceanDocumentary extends Documentary implements Recommendable, Educational {
    private int maxDepth;

    public OceanDocumentary(String title, int duration, int maxDepth) {
        super(title, "Ocean", duration);
        this.maxDepth = maxDepth;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    @Override
    public String toString() {
        return super.toString()  +  " | maxDepth=" + maxDepth + "m";
    }
    @Override
    public String getType() {
        return "Ocean";
    }
    @Override
    public boolean isRecommended() {
        return getRating() >= 8;
    }
}

