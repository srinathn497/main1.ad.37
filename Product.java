import java.io.Serializable;



public class Product implements Serializable
{	private String pid;	
    private String pname;
	private int pcost;
	public void setPid(String pid)
	{	this.pid=pid;
	}public void setPname(String pname)
	{	this.pname=pname;
	}public void setPcost(int pcost)
	{	this.pcost=pcost;
	}public String getPid()
	{	return pid;
	}public String getPname()
	{	return pname;
	}
	public int getPcost()
	{
		return pcost;
	}
}
