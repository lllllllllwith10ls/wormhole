public abstract class AbstractDomain {
    BGDomain parent;
    Mo rim;
    public abstract void paintBG(Viewport V, Mo T);
    public abstract void onDraw();
}
