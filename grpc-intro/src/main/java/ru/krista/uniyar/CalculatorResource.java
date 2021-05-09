package ru.krista.uniyar;

import io.grpc.stub.StreamObserver;
import io.quarkus.calc.CalculatorServiceGrpc;
import io.quarkus.calc.CalculatorProto;
import io.quarkus.grpc.runtime.annotations.GrpcService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/calculator")
public class CalculatorResource {
    @Inject
    @GrpcService("calculator")
    CalculatorServiceGrpc.CalculatorServiceBlockingStub client;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String perpareToCalculate() {
        return "Введите числа и операцию";
    }
    @GET
    @Path("/ADD/{num1}/{num2}")
    public double getAddResult(@PathParam("num1") double num1, @PathParam("num2") double num2) {
        return client.calculate(io.quarkus.calc.CalculatorProto.CalculatorRequest.newBuilder().setNumber1(num1).setNumber2(num2).setOperation(CalculatorProto.CalculatorRequest.OperationType.ADD).build()).getResult();
    }
    @GET
    @Path("/SUBTRACT/{num1}/{num2}")
    public double getSubtractResult(@PathParam("num1") double num1, @PathParam("num2") double num2) {
        return client.calculate(io.quarkus.calc.CalculatorProto.CalculatorRequest.newBuilder().setNumber1(num1).setNumber2(num2).setOperation(CalculatorProto.CalculatorRequest.OperationType.SUBTRACT).build()).getResult();
    }
    @GET
    @Path("/MULTIPLY/{num1}/{num2}")
    public double getMultiplyResult(@PathParam("num1") double num1, @PathParam("num2") double num2) {
        return client.calculate(io.quarkus.calc.CalculatorProto.CalculatorRequest.newBuilder().setNumber1(num1).setNumber2(num2).setOperation(CalculatorProto.CalculatorRequest.OperationType.MULTIPLY).build()).getResult();
    }
    @GET
    @Path("/DIVIDE/{num1}/{num2}")
    public String getDivideResult(@PathParam("num1") double num1, @PathParam("num2") double num2) {
        io.quarkus.calc.CalculatorProto.CalculatorResponse response
                = client.calculate(io.quarkus.calc.CalculatorProto.CalculatorRequest.newBuilder()
                .setNumber1(num1)
                .setNumber2(num2)
                .setOperation(CalculatorProto.CalculatorRequest.OperationType.DIVIDE)
                .build());
        if (!response.getMessage().equals(""))
            return response.getMessage();
        else
            return Double.toString(client.calculate(io.quarkus.calc.CalculatorProto.CalculatorRequest.newBuilder().setNumber1(num1).setNumber2(num2).setOperation(CalculatorProto.CalculatorRequest.OperationType.DIVIDE).build()).getResult());
    }
}
