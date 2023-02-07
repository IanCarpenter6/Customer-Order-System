package COS;

public class AccountInfo 
{
	private String id;
	private String pw;
	private String sQ;
	private String sA;
	private String addr;
	private String cc;
	private String name;
	
	public AccountInfo(String id1, String pass, String naim, String sq, String sa, String address, String crc)
	{
		id = id1;
		pw = pass;
		sQ = sq;
		sA = sa;
		addr = address;
		cc = crc;
		name = naim;
	}
	
	public String getID()
	{
		return id;
	}
	public String getPass()
	{
		return pw;
	}
	public String getName()
	{
		return name;
	}
	public String getSQ()
	{
		return sQ;
	}
	public String getSA()
	{
		return sA;
	}
	public String getAddress() {
		return addr;
	}
	public String getCC() {
		return cc;
	}
	public void setCC(String ccNbr) {
		cc = ccNbr;
	}
}
