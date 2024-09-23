public class LightThemeFactory implements ThemeFactory {

    @Override
    public Header createHeader() {
        return new LightHeader();
    }

    @Override
    public Footer createFooter() {
        return new LightFooter();
    }

    @Override
    public Body createBody() {
        return new LightBody();
    }
}
