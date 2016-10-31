import java.io.File;

public class source
{
    public static void main(String[] args)
    {
        FileReceiver fr = new FileReceiver();
        
        	boolean flag=false;
        	flag = fr.requestReceive();
            if(flag)
            {
            	String s = fr.requestRead();
                FileSender fs = new FileSender();
                fs.responseSend();
                File req = new File("request.txt");
                req.delete();
                if(s.charAt(0)=='C')
                	CodeChecker.checkCode(s);
                else if(s.charAt(0)=='S' && s.charAt(6)=='P')
                {
                	DatabaseConnection db = new DatabaseConnection();
                	db.store();
                }
                else if(s.charAt(0)=='G')  
                {
                	DatabaseConnection db = new DatabaseConnection();
                	db.retrieveProblem(3);
                	flag = fs.problemSend();
                	File f = new File("problem.txt");
                	f.delete();
                }
            }
        
    }
}
