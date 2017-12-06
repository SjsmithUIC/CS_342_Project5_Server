import java.net.Socket;

public class ServerClientInfo
{
	private ClientIDTuple T;
	Socket ClientSock;
	
	public void setSock(Socket S)
	{
		ClientSock = S;
	}
	
	public Socket GetSock()
	{
		return ClientSock;
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
