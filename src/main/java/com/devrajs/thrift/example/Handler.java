package com.devrajs.thrift.example;

import com.sun.org.apache.xalan.internal.xsltc.TransletException;
import org.apache.thrift.TException;

/**
 * Created by devraj.singh on 6/10/16.
 */
public class Handler implements MultiplicationService.Iface{

    public int multiply(int n1, int n2) throws TException
    {
        System.out.println("Calculating multiplication of two numbers: " + n1 + ", " + n2);
        return n1*n2;
    }
}
