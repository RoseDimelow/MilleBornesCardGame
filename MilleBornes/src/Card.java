class Card
{
  private String title;
  private int miles;
  private String category;

  public Card (String t, int m, String c)
  {
    title = t;
    miles = m;
    category = c;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String t)
  {
    title = t;
  }

  public int getMiles()
  {
    return miles;
  }

  public void getMiles(int m)
  {
    miles = m;
  }

  public String getCategory()
  {
    return category;
  }

  public void setCategory(String c)
  {
    category = c;
  }
  
}