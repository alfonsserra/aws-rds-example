package com.systelab.aws;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.rds.RdsClient;
import software.amazon.awssdk.services.rds.model.DBInstance;
import software.amazon.awssdk.services.rds.model.DescribeDbInstancesRequest;
import software.amazon.awssdk.services.rds.model.DescribeDbInstancesResponse;

public class AWSRDSExampleApp {

    private Region region = Region.EU_CENTRAL_1;
    private RdsClient rds = RdsClient.builder().region(region).build();

    public void describe(String dbInstanceIdentifier) {
        DescribeDbInstancesRequest request = DescribeDbInstancesRequest.builder().dbInstanceIdentifier(dbInstanceIdentifier).build();
        DescribeDbInstancesResponse response = rds.describeDBInstances(request);
        response.dbInstances().forEach(this::printDBInstance);
    }

    public void printDBInstance(DBInstance dbInstance) {
        System.out.println(dbInstance.endpoint().address());
        System.out.println(dbInstance.endpoint().port());
    }

    public void getInstances() {
        DescribeDbInstancesRequest request = DescribeDbInstancesRequest.builder().maxRecords(100).build();
        DescribeDbInstancesResponse response = rds.describeDBInstances(request);
        response.dbInstances().forEach(this::printDBInstance);
    }

    public static void main(String[] args) {
        AWSRDSExampleApp example = new AWSRDSExampleApp();
        example.getInstances();
        example.describe("mgold");
    }
}
