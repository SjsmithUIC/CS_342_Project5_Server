import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerClientInfo
{
	private ClientIDTuple T;
	ObjectOutputStream ClientOS;
	
	public void setOutputStream(ObjectOutputStream S)
	{
		ClientOS = S;
	}
	
	public ObjectOutputStream GetOutputStream()
	{
		return ClientOS;
	}
	
	public void setTuple(ClientIDTuple in)
	{
		T = in;
	}
	
	public ClientIDTuple getTuple()
	{
		return T;
	}
}
