package springIntro;

public class MsSqlCustomerDal implements ICustomerDal{

	String connectionString;

	public String getConnectionString() {
		return connectionString;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}
	
	@Override
	public void add() {
		System.out.println("System Connection : " + connectionString);

		System.out.println("Ms Sql Veri Tabanina Eklendi");
	}

}
