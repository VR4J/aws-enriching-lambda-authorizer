package nl.theguild.lambda.model;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = InvocationResponse.Builder.class)
public class InvocationResponse {

    private String requestId;
    private APIGatewayProxyRequestEvent event;

    private InvocationResponse(InvocationResponse.Builder builder) {
        this.requestId = builder.requestId;
        this.event = builder.event;
    }

    public static InvocationResponse.Builder builder() {
        return new InvocationResponse.Builder();
    }

    public String getRequestId() {
        return requestId;
    }

    public APIGatewayProxyRequestEvent getEvent() {
        return event;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static final class Builder {
        private String requestId;
        private APIGatewayProxyRequestEvent event;

        private Builder() { }

        public InvocationResponse.Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public InvocationResponse.Builder event(APIGatewayProxyRequestEvent event) {
            this.event = event;
            return this;
        }

        public InvocationResponse build() {
            return new InvocationResponse(this);
        }
    }
}
