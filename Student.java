public class Student
{
    public String id;
    public String name;
    public String age;

    public Student()
    {}
    
    public Student(String id, String name, String age)
    {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    
    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return this.id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getAge()
    {
        return this.age;
    }
}
