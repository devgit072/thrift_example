package com.devrajs.thrift.example;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Created by devraj.singh on 6/10/16.
 */
public class MultiplicationClient {

    MultiplicationService.Client client;
    TTransport transport;
    public MultiplicationClient(String host, int port) throws TException {
        transport = new TSocket(host,port);
        transport.open();
        TProtocol tProtocol = new TBinaryProtocol(transport);
        client = new MultiplicationService.Client(tProtocol);
        //transport.close();
    }

    public int perform() throws TException {
        int prod = client.multiply(3,4);
        System.out.println("Product : " + prod);
        return prod;
    }

    public void closeSocket()
    {
        System.out.println("Closing socket now....");
        transport.close();
        System.out.println("Closed socket now....");
    }

}

