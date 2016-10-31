import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Bakhtiar Hasan
 * @version 1.0
 */
public class FileReceiver
{
    public static final int SOCKET_PORT_CODE_RECEIVER = 4000;
    public static final int SOCKET_PORT_REQUEST_RECEIVER = 4100;
    public static final int SOCKET_PORT_PROBLEM = 4400;
    public static final int SOCKET_PORT_INPUT= 4500;
    public static final int SOCKET_PORT_OUTPUT = 4600;
    public static final String SERVER = "10.220.60.106";
    public static final int FILE_SIZE = 6022386;
	public boolean requestReceive()
    {
        final String FILE_TO_RECEIVE = "C:/Users/Bakhtiar/Documents/Eclipse/Server/request.txt";
        int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock =null;
        try
        {
            sock = new Socket(SERVER, SOCKET_PORT_REQUEST_RECEIVER);
            byte [] inputByte = new byte[FILE_SIZE];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(FILE_TO_RECEIVE);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(inputByte, 0, inputByte.length);
            current = bytesRead;
            do
            {
                bytesRead = is.read(inputByte, current, (inputByte.length-current));
                if(bytesRead>=0)
                    current+=bytesRead;
            }
            while(bytesRead > -1);

            bos.write(inputByte, 0, current);
            bos.flush();
            return true;
        }
        catch(UnknownHostException e)
        {
        	 return false;
        }
        catch(IOException e)
        {
        	return false;
        }
        finally
        {
            try
            {
            	if(fos!=null)
                    fos.close();
                if(bos!=null)
                    bos.close();
                if(sock!=null)
                    sock.close();
            }
            catch(final IOException e)
            {
            	return false;
            }
        }
    }
    public String requestRead()
    {
        BufferedReader br = null;
        String ret = "";
        try
        {
            br = new BufferedReader(new FileReader("C:/Users/Bakhtiar/Documents/Eclipse/Server/request.txt"));
            ret+=br.readLine();
            if(ret.equals("Code"))
            	ret+=br.readLine();
            File f = new File("C:/Users/Bakhtiar/Documents/Eclipse/Server/request.txt");
            f.delete();
        }
        catch(IOException e)
        {
            return null;
        }
        finally
        {
            if(br!=null)
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    return null;
                }
        }
        return ret;
    }
    @SuppressWarnings("finally")
	public boolean codeReceive()
    {
    	final String FILE_TO_RECEIVE = "C:/Users/Bakhtiar/Documents/Eclipse/Server/a.c";
    	int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock =null;
        try
        {
            sock = new Socket(SERVER, SOCKET_PORT_CODE_RECEIVER);
            byte [] inputByte = new byte[FILE_SIZE];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(FILE_TO_RECEIVE);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(inputByte, 0, inputByte.length);
            current = bytesRead;
            do
            {
                bytesRead = is.read(inputByte, current, (inputByte.length-current));
                if(bytesRead>=0)
                    current+=bytesRead;
            }
            while(bytesRead > -1);

            bos.write(inputByte, 0, current);
            bos.flush();
        }
        catch(UnknownHostException e)
        {
        	 return false;
        }
        catch(IOException e)
        {
        	return false;
        }
        finally
        {
            try
            {
            	if(fos!=null)
                    fos.close();
                if(bos!=null)
                    bos.close();
                if(sock!=null)
                    sock.close();
            }
            catch(final IOException e)
            {
            	return false;
            }
            return true;
        }
    }
	public boolean problemReceive()
    {
    	final String FILE_TO_RECEIVE = "C:/Users/Bakhtiar/Documents/Eclipse/Server/problem.txt";
    	int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock =null;
        try
        {
            sock = new Socket(SERVER, SOCKET_PORT_PROBLEM);
            byte [] inputByte = new byte[FILE_SIZE];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(FILE_TO_RECEIVE);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(inputByte, 0, inputByte.length);
            current = bytesRead;
            do
            {
                bytesRead = is.read(inputByte, current, (inputByte.length-current));
                if(bytesRead>=0)
                    current+=bytesRead;
            }
            while(bytesRead > -1);

            bos.write(inputByte, 0, current);
            bos.flush();
            return true;
        }
        catch(UnknownHostException e)
        {
        	 return false;
        }
        catch(IOException e)
        {
        	return false;
        }
        finally
        {
            try
            {
            	if(fos!=null)
                    fos.close();
                if(bos!=null)
                    bos.close();
                if(sock!=null)
                    sock.close();
            }
            catch(final IOException e)
            {
            	return false;
            }
        }
    }
	public boolean inputReceive()
    {
    	final String FILE_TO_RECEIVE = "C:/Users/Bakhtiar/Documents/Eclipse/Server/input.txt";
    	int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock =null;
        try
        {
            sock = new Socket(SERVER, SOCKET_PORT_INPUT);
            byte [] inputByte = new byte[FILE_SIZE];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(FILE_TO_RECEIVE);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(inputByte, 0, inputByte.length);
            current = bytesRead;
            do
            {
                bytesRead = is.read(inputByte, current, (inputByte.length-current));
                if(bytesRead>=0)
                    current+=bytesRead;
            }
            while(bytesRead > -1);

            bos.write(inputByte, 0, current);
            bos.flush();
            return true;
        }
        catch(UnknownHostException e)
        {
        	 return false;
        }
        catch(IOException e)
        {
        	return false;
        }
        finally
        {
            try
            {
            	if(fos!=null)
                    fos.close();
                if(bos!=null)
                    bos.close();
                if(sock!=null)
                    sock.close();
            }
            catch(final IOException e)
            {
            	return false;
            }
        }
    }
	public boolean outputReceive()
    {
    	final String FILE_TO_RECEIVE = "C:/Users/Bakhtiar/Documents/Eclipse/Server/expected_output.txt";
    	int bytesRead;
        int current = 0;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        Socket sock =null;
        try
        {
            sock = new Socket(SERVER, SOCKET_PORT_OUTPUT);
            byte [] inputByte = new byte[FILE_SIZE];
            InputStream is = sock.getInputStream();
            fos = new FileOutputStream(FILE_TO_RECEIVE);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(inputByte, 0, inputByte.length);
            current = bytesRead;
            do
            {
                bytesRead = is.read(inputByte, current, (inputByte.length-current));
                if(bytesRead>=0)
                    current+=bytesRead;
            }
            while(bytesRead > -1);

            bos.write(inputByte, 0, current);
            bos.flush();
            return true;
        }
        catch(UnknownHostException e)
        {
        	 return false;
        }
        catch(IOException e)
        {
        	return false;
        }
        finally
        {
            try
            {
            	if(fos!=null)
                    fos.close();
                if(bos!=null)
                    bos.close();
                if(sock!=null)
                    sock.close();
            }
            catch(final IOException e)
            {
            	return false;
            }
        }
    }
}
