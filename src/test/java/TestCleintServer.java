import com.devrajs.thrift.example.MultiplicationClient;
import com.devrajs.thrift.example.MultiplicationService;
import org.apache.thrift.TException;
import org.testng.annotations.Test;

/**
 * Created by devraj.singh on 6/17/16.
 */
public class TestCleintServer {

    @Test
    public void simpleTest() throws TException {
        MultiplicationClient client = new MultiplicationClient("localhost", 9090);
        System.out.println("Client created.....");
        System.out.println("calling client now....");
        client.perform();
        System.out.println("done with operation......");
        client.closeSocket();
    }
}
