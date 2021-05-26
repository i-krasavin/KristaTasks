package ru.krista.uniyar;
import io.grpc.stub.StreamObserver;
import io.quarkus.calc.CalculatorServiceGrpc;
import io.quarkus.calc.CalculatorProto;
import javax.inject.Singleton;

@Singleton
public class CalculatorService extends CalculatorServiceGrpc.CalculatorServiceImplBase {
    @Override
    public void calculate(io.quarkus.calc.CalculatorProto.CalculatorRequest request,
                          io.grpc.stub.StreamObserver<io.quarkus.calc.CalculatorProto.CalculatorResponse> responseObserver) {
        double num1 = request.getNumber1();
        double num2 = request.getNumber2();
        double result= 0;
        String message = "";
        switch(request.getOperationValue()){
            case 0:
                result = num1 + num2;
                break;
            case 1:
                result = num1 - num2;
                break;
            case 2:
                result = num1 * num2;
                break;
            case 3:
                if (num2 != 0)
                    result = num1/num2;
                else
                    message = "Деление на ноль";
                break;
            default:
                result = 0;
        }
        responseObserver.onNext(io.quarkus.calc.CalculatorProto.CalculatorResponse.newBuilder().setResult(result).setMessage(message).build());
        responseObserver.onCompleted();
    }

}

