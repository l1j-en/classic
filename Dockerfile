# https://github.com/kmindi/openjdk-ant-docker/blob/master/Dockerfile
FROM openjdk:11-slim AS builder

ENV ANT_VERSION=1.10.9
ENV ANT_HOME=/opt/ant

# Install OpenJFX and wget
RUN apt-get update && apt-get install -y --no-install-recommends wget openjfx

# Download and extract apache ant to opt folder
RUN wget --no-check-certificate --no-cookies http://archive.apache.org/dist/ant/binaries/apache-ant-${ANT_VERSION}-bin.tar.gz \
    && wget --no-check-certificate --no-cookies http://archive.apache.org/dist/ant/binaries/apache-ant-${ANT_VERSION}-bin.tar.gz.sha512 \
    && echo "$(cat apache-ant-${ANT_VERSION}-bin.tar.gz.sha512) apache-ant-${ANT_VERSION}-bin.tar.gz" | sha512sum -c \
    && tar -zvxf apache-ant-${ANT_VERSION}-bin.tar.gz -C /opt/ \
    && ln -s /opt/apache-ant-${ANT_VERSION} /opt/ant \
    && rm -f apache-ant-${ANT_VERSION}-bin.tar.gz \
    && rm -f apache-ant-${ANT_VERSION}-bin.tar.gz.sha512

# add executables to path
RUN update-alternatives --install "/usr/bin/ant" "ant" "/opt/ant/bin/ant" 1 && \
    update-alternatives --set "ant" "/opt/ant/bin/ant"

RUN mkdir /l1j /l1j/emblem

COPY lib /l1j/lib
COPY build.xml /l1j
COPY src /l1j/src

WORKDIR /l1j
RUN ant

#### Runtime
FROM gcr.io/distroless/java11-debian11

EXPOSE 2000

WORKDIR /l1j

COPY maps /l1j/maps
COPY data /l1j/data
COPY lib /l1j/lib
COPY config /l1j/config
COPY --from=builder /l1j/l1jen.jar /l1j/l1jen.jar
COPY --from=builder /l1j/emblem /l1j/emblem

ENV JDK_JAVA_OPTIONS="-Djava.util.logging.config.file=config/log.properties -Xms1024m -Xmx1024m -cp l1jen.jar:lib/*"

ENTRYPOINT [ "java" ]

CMD [ "l1j.server.Server" ]
