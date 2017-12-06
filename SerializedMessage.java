import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;

public class SerializedMessage implements Serializable 
{
	private int Type;
	private ClientIDTuple Client;
	ArrayList<BigInteger> Message;
	
	public int getType()
	{
		return Type;
	}
	
	public ClientIDTuple getClient()
	{
		return Client;
	}
	
	public ArrayList<BigInteger> getMessage()
	{
		return Message;
	}
	
	public void SetType(int T)
	{
		Type = T;
	}
	
	public void SetClient(ClientIDTuple N)
	{
		Client = N;
	}
	
	public void SetMessage(ArrayList<BigInteger> B)
	{
		Message = B;
	}
}