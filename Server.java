import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class Server 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		ObjectInputStream input;
		ObjectOutputStream output;
		SerializedMessage Test;
		Vector<ServerClientInfo> ConnectedClients = new Vector<ServerClientInfo>();
		NetworkCommandCodes NetCodes = new NetworkCommandCodes();
		
		System.out.println("Server is running\n");
		
		ServerSocket ser = new ServerSocket(3000);
			
		Socket S = ser.accept();
		System.out.println("Connected");
		input = new ObjectInputStream(S.getInputStream());
		output = new ObjectOutputStream(S.getOutputStream());
		
		while((Test = (SerializedMessage) input.readObject()) != null)
		{
			int Type = Test.getType();
			ClientIDTuple TempClient = Test.getClient();
			ArrayList<BigInteger> TempMessage = Test.getMessage();
			
			if(Type == NetCodes.USER_CONNECT)
			{
				ServerClientInfo NewClient = new ServerClientInfo();
				NewClient.setOutputStream(output);
				NewClient.setTuple(TempClient);
				
				ConnectedClients.add(NewClient);
				System.out.println("Client added");
				
				for(int i = 0; i < ConnectedClients.size(); i++)
				{
					SerializedMessage SendClients = new SerializedMessage();
					SendClients.SetType(NetCodes.USER_CONNECT);
					SendClients.SetClient(ConnectedClients.get(i).getTuple());
					SendClients.SetMessage(null);
					
					for(int j = 0; j < ConnectedClients.size(); j++)
					{
						ConnectedClients.get(j).GetOutputStream().writeObject(SendClients);
					}
				}
			}
			
			if(Type == NetCodes.USER_DISCONNECT)
			{
				System.out.println("Client Disconnected");
				break;
			}
			
			if(Type == NetCodes.RECIEVE_MESSAGE)
			{
				for(int k = 0; k < ConnectedClients.size(); k++)
				{
					if(TempClient.GetClientID().equals(ConnectedClients.get(k).getTuple().GetClientID()))
					{
						ConnectedClients.get(k).GetOutputStream().writeObject(Test);
					}
				}
			}
			
		}
		
		System.out.println("END");
		input.close();
		output.close();
		S.close();
	}
}
