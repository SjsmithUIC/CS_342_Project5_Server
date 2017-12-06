import java.io.Serializable;

public class ClientIDTuple implements Serializable
{
	private String ClientID;
	private EncryptionKey ClientPublicKey;
	
	public String GetClientID()
	{
		return ClientID;
	}
	
	public EncryptionKey GetClientPublicKey() 
	{
		return ClientPublicKey;
	}
	
	public void SetClientID(String CID)
	{
		ClientID = CID;
	}
	
	public void SetEncryptionKey(EncryptionKey E)
	{
		ClientPublicKey = E;
	}
}