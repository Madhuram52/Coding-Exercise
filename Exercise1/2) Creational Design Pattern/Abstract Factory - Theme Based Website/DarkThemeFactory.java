public class DarkThemeFactory implements ThemeFactory {

    @Override
    public Header createHeader() {
        return new DarkHeader();
    }

    @Override
    public Footer createFooter() {
        return new DarkFooter();
    }

    @Override
    public Body createBody() {
        return new DarkBody();
    }
}
