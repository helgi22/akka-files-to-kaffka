FROM cassandra:3.11.1

MAINTAINER  Oleg Galaykovskiy <helgi22@gmail.com>

COPY sql/*.sql /tmp/
COPY docker-entrypoint.sh /docker-entrypoint.sh
COPY cassandra-model-creator.sh /

RUN mkdir -p /home/cassandra/.cassandra
RUN chmod a+x docker-entrypoint.sh
RUN chmod a+x cassandra-model-creator.sh