/**
 * Class Faculty inherits from abstract Class Employee
 * It contains Education, Level object
 */
public class Faculty extends Employee implements Cloneable{
	//Objects
	Level professor;
	Education level;
	/**
	 * constructor
	 */
	Faculty()
	{
		super();
		level = new Education();
		professor = Level.FU;
	}
	/**
	 * argument constructor with
	 * @param L, F, I, S, year, month, day, D, M, R, lev
	 */
	Faculty(String L, String F, int I, char S, int year, int month, int day, String D, String M, int R, Level lev)
	{
	super(L, F, I, S, year, month, day); //inherits from Employee
	level = new Education(D, M, R);
	professor = lev;
	}
	/**
	 * The following is the getters and setters of the objects
	 */
	public Level getProfessor() {
		return professor;
	}
	public void setProfessor(Level prof) {
		professor = prof;
	}
	public Education getLevel() {
		return level;
	}
	public void setLevel(Education level) {
		this.level = level;
	}
	/**
	 * The abstract method returns the cases of
	 * the object professor from Level enum
	 */
	public double monthlyEarning()
	{
		switch (this.professor){
		case AS:
			return EmployeeInfo.FACULTY_MONTHLY_SALARY;
		case AO:
			return EmployeeInfo.FACULTY_MONTHLY_SALARY * 1.2;
		case FU:
			return EmployeeInfo.FACULTY_MONTHLY_SALARY * 1.4;
		default:
			break;
		}
		return 0.0;
	}
	/**
	 * returns the display format from Employee and entered format
	 */
	public String toString()
	{
		String store = " ";
		if(professor == Level.AO)
			store = "Associate Professor";
		else if(professor == Level.AS)
			store = "Assistant Professor";
		else if(professor == Level.FU)
			store = "Full time Professor";
		
		return super.toString() + "\n" + store + level +
				"\nMonthly Salary: $" + monthlyEarning();
	}
	public void setEducation(String deg, String maj, int res){
		level = new Education(deg, maj, res);
		}  
	public Object clone()throws CloneNotSupportedException
	{
		Faculty b = (Faculty)super.clone();
		Education edu = (Education)level.clone();
		b.setEducation(edu.getDegree(),edu.getMajor(), edu.getResearch());
		return b;
	}
	@Override
	public int compareTo(Employee obj) {
		Employee em = obj;
		if(ID == em.ID)
			return 0;
		else if(ID < em.ID)
			return 1;
		else
			return -1;
	}
	@Override
	public int compare(Employee obj1, Employee obj2) {
		Employee em1 = obj1; //Employee em1 = (Employee)obj1; -> type cast if Comparator<Employee> isn't used
		Employee em2 = obj2;
		return em1.LName.compareTo(em2.LName);
	}
}
