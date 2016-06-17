package com.devrajs.thrift.example;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by devraj.singh on 6/10/16.
 */

public class MultiplicationServer {

    public static Handler handler;
    public static MultiplicationService.Processor processor;

    public static void main(String[] args) {
        handler = new Handler();
        processor = new MultiplicationService.Processor(handler);
        Runnable runnable = new Runnable() {
            public void run() {
                startServer(processor);
            }
        };
        new Thread(runnable).start();
    }


    public static void startServer(MultiplicationService.Processor processor)
    {
        try {
            TServerTransport tServerTransport = new TServerSocket(9090);
            TServer tServer = new TSimpleServer(new TServer.Args(tServerTransport).processor(processor));
            System.out.println("Starting the server:");
            System.out.println("Listening on port 9090....");
            tServer.serve();
            System.out.println("started the server....");
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}