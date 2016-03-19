package project1;

/**
 * Created by npena9 on 3/8/2016.
 */
public class Book
{

    private String name;
    private Genre category;

    public Book(String name, Genre category)
    {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getCategory() {
        return category;
    }

    public void setCategory(Genre category) {
        this.category = category;
    }


}
