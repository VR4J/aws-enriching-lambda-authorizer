package nl.theguild.lambda.model;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = DefaultResponse.Builder.class)
public class DefaultResponse {

    private int code;
    private String message;

    public DefaultResponse(DefaultResponse.Builder builder) {
        this.code = builder.code;
        this.message = builder.message;
    }

    public static DefaultResponse.Builder builder() {
        return new DefaultResponse.Builder();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {
        private int code;
        private String message;

        public Builder() { }

        public DefaultResponse.Builder code(int code) {
            this.code = code;
            return this;
        }

        public DefaultResponse.Builder message(String message) {
            this.message = message;
            return this;
        }

        public DefaultResponse build() {
            return new DefaultResponse(this);
        }
    }
}
