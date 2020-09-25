package nl.theguild.lambda.model.aws;

import com.amazonaws.services.lambda.runtime.*;

public class LambdaContext implements Context {

    private String requestId;

    public LambdaContext(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String getAwsRequestId() {
        return requestId;
    }

    @Override
    public String getLogGroupName() {
        return null;
    }

    @Override
    public String getLogStreamName() {
        return null;
    }

    @Override
    public String getFunctionName() {
        return null;
    }

    @Override
    public String getFunctionVersion() {
        return null;
    }

    @Override
    public String getInvokedFunctionArn() {
        return null;
    }

    @Override
    public CognitoIdentity getIdentity() {
        return null;
    }

    @Override
    public ClientContext getClientContext() {
        return null;
    }

    @Override
    public int getRemainingTimeInMillis() {
        return 0;
    }

    @Override
    public int getMemoryLimitInMB() {
        return 0;
    }

    @Override
    public LambdaLogger getLogger() {
        return LambdaRuntime.getLogger();
    }
}
