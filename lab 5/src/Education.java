/**
 * Class Education will be used in Class Faculty
 * It contains attributes Degree, Major, Research
 */
public class Education implements Cloneable{
	//attributes
	String Degree, Major;
	int Research;
	/**
	 * constructor
	 */
	Education()
	{
		Degree = Major = " ";
		Research = 0;
	}
	/**
	 * argument constructor with
	 * @param D, M, R
	 */
	Education(String D, String M, int R)
	{
		Degree = D;
		Major = M;
		Research = R;
	}
	/**
	 * The following is the getter and setters of the attributes
	 */
	public String getDegree()
	{
		return Degree;
	}
	public void setDegree(String d)
	{
		Degree = d;
	}
	public String getMajor()
	{
		return Major;
	}
	public void setMajor(String m)
	{
		Major = m;
	}
	public int getResearch()
	{
		return Research;
	}
	public void setResearch(int r)
	{
		Research = r;
	}
	public Object clone()
	{
		return new Education(Degree, Major, Research);
	}
	/**
	 * returns the output format
	 */
	public String toString()
	{
		return "\nDegree: " + Degree + "\nMajor: " + Major + "\nResearch: " + Research;
	}
}
