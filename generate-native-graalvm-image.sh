PROJECT_NAME=aws-enriching-lambda-authorizer
PROJECT_VERSION=1.0.0

# Generate Jar file
mvn clean install;

# Generate Native Image
docker run --rm --name graal -v $(pwd):/${PROJECT_NAME} oracle/graalvm-ce:19.2.0 \
    /bin/bash -c "gu install native-image; \
                  native-image \
                    -H:EnableURLProtocols=http \
		                -H:ReflectionConfigurationFiles=/${PROJECT_NAME}/reflect.json \
                    -jar /${PROJECT_NAME}/target/${PROJECT_NAME}-${PROJECT_VERSION}.jar \
                    ; \
                    mkdir /${PROJECT_NAME}/target/custom-runtime \
                    ; \
                    cp ${PROJECT_NAME}-${PROJECT_VERSION} /${PROJECT_NAME}/target/custom-runtime/${PROJECT_NAME}";

echo -e "#!/bin/sh \n \
set -euo pipefail \n \
./${PROJECT_NAME}" > target/custom-runtime/bootstrap;

# Make bootstrap executable
chmod +x target/custom-runtime/bootstrap;

# Zip
rm $PROJECT_NAME-custom-runtime.zip
cd target/custom-runtime || exit
zip -X -r ../../$PROJECT_NAME-custom-runtime.zip .
