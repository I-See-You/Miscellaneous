import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileSender
{
	public static final int SOCKET_PORT_RESPONSE_SENDER = 4300;
	public static final int SOCKET_PORT_VERDICT_SENDER = 4200;
	public static final int SOCKET_PORT_PROBLEM_SENDER = 4800;
	@SuppressWarnings("resource")
	public boolean responseSend()
	{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
	    OutputStream os = null;
	    ServerSocket servsock = null;
	    Socket sock = null;
	    final String FILE_TO_SEND = "C:/Users/Bakhtiar/Documents/Eclipse/Server/SendMe.txt";
	    try
	    {
	    	servsock = new ServerSocket(SOCKET_PORT_RESPONSE_SENDER);
	    	try
	    	{
	    		sock = servsock.accept();
	    		File myFile = new File(FILE_TO_SEND);
	    		byte [] mybytearray  = new byte [(int)myFile.length()];
	    		fis = new FileInputStream(myFile);
		        bis = new BufferedInputStream(fis);
		        bis.read(mybytearray,0,mybytearray.length);
		        os = sock.getOutputStream();
		        os.write(mybytearray,0,mybytearray.length);
		        os.flush();
	    	}
	    	catch(IOException e)
	    	{
	    		return false;
	    	}
	    	return true;
	    }
	    catch(IOException e)
	    {
	    	return false;
	    }
	    finally
	    {
	    	try
	    	{
	    		if (bis != null)
	    			bis.close();
		        if (os != null)
		        	os.close();
		        if (sock!=null)
		        	sock.close();
		        if(servsock!=null)
		        	servsock.close();
	    	}
	    	catch(IOException e)
	    	{
	    		return false;
	    	}
	    }
	}
	@SuppressWarnings("resource")
	public boolean verdictSend(String v)
	{
		String FILE_TO_SEND = null;
		if(v.equals("Accepted"))
			FILE_TO_SEND = "C:/Users/Bakhtiar/Documents/Eclipse/Server/AC.txt";
		else if(v.equals("Wrong Answer"))
			FILE_TO_SEND = "C:/Users/Bakhtiar/Documents/Eclipse/Server/WA.txt";
		else if(v.equals("Compilation Error"))
			FILE_TO_SEND = "C:/Users/Bakhtiar/Documents/Eclipse/Server/CE.txt";
		else
			FILE_TO_SEND = "C:/Users/Bakhtiar/Documents/Eclipse/Server/RE.txt";
		FileInputStream fis = null;
		BufferedInputStream bis = null;
	    OutputStream os = null;
	    ServerSocket servsock = null;
	    Socket sock = null;
	    try
	    {
	    	servsock = new ServerSocket(SOCKET_PORT_VERDICT_SENDER);
	    	try
	    	{
	    		sock = servsock.accept();
	    		File myFile = new File(FILE_TO_SEND);
	    		byte [] mybytearray  = new byte [(int)myFile.length()];
	    		fis = new FileInputStream(myFile);
		        bis = new BufferedInputStream(fis);
		        bis.read(mybytearray,0,mybytearray.length);
		        os = sock.getOutputStream();
		        os.write(mybytearray,0,mybytearray.length);
		        os.flush();
	    	}
	    	catch(IOException e)
	    	{
	    		e.printStackTrace();
	    		return false;
	    	}
	    }
	    catch(IOException e)
	    {
	    	e.printStackTrace();
	    	return false;
	    }
	    finally
	    {
	    	try
	    	{
	    		if (bis != null)
	    			bis.close();
		        if (os != null)
		        	os.close();
		        if (sock!=null)
		        	sock.close();
		        if(servsock!=null)
		        	servsock.close();
	    	}
	    	catch(IOException e)
	    	{
	    		e.printStackTrace();
	    		return false;
	    	}
	    }
	    return true;
	}
	@SuppressWarnings("resource")
	public boolean problemSend()
	{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
	    OutputStream os = null;
	    ServerSocket servsock = null;
	    Socket sock = null;
	    final String FILE_TO_SEND = "C:/Users/Bakhtiar/Documents/Eclipse/Server/problem.txt";
	    try
	    {
	    	servsock = new ServerSocket(SOCKET_PORT_PROBLEM_SENDER);
	    	try
	    	{
	    		sock = servsock.accept();
	    		File myFile = new File(FILE_TO_SEND);
	    		byte [] mybytearray  = new byte [(int)myFile.length()];
	    		fis = new FileInputStream(myFile);
		        bis = new BufferedInputStream(fis);
		        bis.read(mybytearray,0,mybytearray.length);
		        os = sock.getOutputStream();
		        os.write(mybytearray,0,mybytearray.length);
		        os.flush();
	    	}
	    	catch(IOException e)
	    	{
	    		e.printStackTrace();
	    		return false;
	    	}
	    }
	    catch(IOException e)
	    {
	    	e.printStackTrace();
	    	return false;
	    }
	    finally
	    {
	    	try
	    	{
	    		if (bis != null)
	    			bis.close();
		        if (os != null)
		        	os.close();
		        if (sock!=null)
		        	sock.close();
		        if(servsock!=null)
		        	servsock.close();
	    	}
	    	catch(IOException e)
	    	{
	    		e.printStackTrace();
	    		return false;
	    	}
	    }
	    return true;
	}
}
