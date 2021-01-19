package by.example.team_board.page;

public enum Pages {
    PERSON_PAGE("person-page"),
    ERROR_PAGE("error-page"),
    PERSON_DETAILS("person-details"),
    LIST_PERSONS("list-persons"),
    REGISTER("register"),
    LOGIN("login"),
    START("start"),
    ABOUT("about"),
    HOME("home");

    private final String page;

    Pages(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
