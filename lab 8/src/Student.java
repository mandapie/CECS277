/**
 * Amanda Pan
 * 4/6/2016
 * lab 8
 * cecs 277
 */
public class Student implements Comparable<Student> {

    private String fName, lName;
    private Integer id;

    Student()
    {
        fName = new String();
        lName = new String();
        id = null;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Student s)
    {
        if (lName.equals(s.lName))
        {
            if (fName.compareTo(s.fName) == 0)
            {
                if (id == s.id)
                {
                    return 0;
                }
                else
                    return id - s.id;
            }
            else
                return fName.compareTo(s.fName);
        }
        else
            return lName.compareTo(s.lName);
    }

    /**
     Calculates a hashcode by combining the hashcodes of the instance variables.
     @return a hashcode dependant on the instance variables
     */
    public int hashCode()
    {
        final int HASH_MULTIPLIER = 29;
        int h = HASH_MULTIPLIER * fName.hashCode() + lName.hashCode();
        h = HASH_MULTIPLIER * h + ((Integer) id).hashCode();
        return h;
    }
}