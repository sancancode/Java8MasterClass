package streams.groupingby;

import java.util.List;

public class Article {
    private int inceptionYear;
    private String title;
    private String articleType;
    private List<Author> authors;
    public int getInceptionYear() {
        return inceptionYear;
    }
    public void setInceptionYear(int inceptionYear) {
        this.inceptionYear = inceptionYear;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArticleType() {
        return articleType;
    }
    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }
    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

}
