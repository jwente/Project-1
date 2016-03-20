package project1;

/**
 * Created by npena9 on 3/8/2016.
 */
public class Book
{

    private String name;
    private Genre category;
    private int id;

    public Book(int id, String name, Genre category)
    {
        this.name = name;
        this.category = category;
    }

    public Book(int id, String name, String genre)
    {
        this.id = id;
        this.name = name;
        this.category = convertStringToGenre(genre);
    }

    static public Genre convertStringToGenre(String genre)
    {
        if(genre.equalsIgnoreCase("Art Books"))
        {
            return Genre.Art;
        }
        else if(genre.equalsIgnoreCase("Business & Economics Books"))
        {
            return Genre.BusinessAndEconomics;
        }
        else if(genre.equalsIgnoreCase("Computer Science Books"))
        {
            return Genre.ComputerScience;
        }
        else if(genre.equalsIgnoreCase("Design Books"))
        {
            return Genre.Design;
        }
        else if(genre.equalsIgnoreCase("Education Books"))
        {
            return Genre.Education;
        }
        else if(genre.equalsIgnoreCase("Law Books"))
        {
            return Genre.Law;
        }
        else if(genre.equalsIgnoreCase("Mathematics Books"))
        {
            return Genre.Mathematics;
        }
        else if(genre.equalsIgnoreCase("Music Books"))
        {
            return Genre.Music;
        }
        else if(genre.equalsIgnoreCase("Philosophy & Psychology Books"))
        {
            return Genre.PhilosophyAndPsychology;
        }

        return null;
    }

    public int getID()
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public Genre getCategory() {
        return category;
    }


}
