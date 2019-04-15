package com.systelab.aws;

public class AWSRDSExampleApp {

    public static void main(String[] args) {
        RDSService service = new RDSService();
        service.getInstances();
    }
}
