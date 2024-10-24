- Kafka is a distributed streaming platform used to build real-time data pipelines and streaming applications. 
- https://chatgpt.com/share/67166c26-5154-8002-a2d9-11f57dccf40d
- It is designed to handle large volumes of data with high throughput, fault tolerance, and scalability. 
- Here's a high-level guide on implementing Kafka:
  1. Kafka Setup and Configuration
     Install Kafka and ZooKeeper: Kafka depends on ZooKeeper to manage distributed coordination.
     Download Kafka from Kafka Downloads.
     Extract the downloaded Kafka package.
     - Configure zookeeper.properties and server.properties.
     
                dataDir=/var/lib/zookeeper
                clientPort=2181
                tickTime=2000
                initLimit=10
                syncLimit=5
                server.1=localhost:2888:3888
                server.2=localhost:2889:3889
                maxClientCnxns=60
             Start ZooKeeper:
               bin/zookeeper-server-start.sh config/zookeeper.properties
       
       
                broker.id=0
                listeners=PLAINTEXT://localhost:9092
                log.dirs=/var/lib/kafka/logs
                zookeeper.connect=localhost:2181
                num.partitions=3
                log.retention.hours=168
                log.segment.bytes=1073741824
                log.retention.bytes=10737418240
                auto.create.topics.enable=true
                delete.topic.enable=true
                default.replication.factor=1
                min.insync.replicas=1
                offsets.retention.minutes=10080
                replica.lag.time.max.ms=10000
                inter.broker.listener.name=PLAINTEXT

             Start Kafka Server:
               bin/kafka-server-start.sh config/server.properties
  2. Basic Kafka Concepts
     - Producers: Send messages (records) to Kafka topics.
     - Consumers: Read messages from Kafka topics.
     - Brokers: Kafka instances that store and serve data.
     - Topics: Categories or feed names to which records are published.
     - Partitions: A topic is split into partitions for parallelism and scalability.
  3. Kafka Producer Implementation
     - Set up a Kafka Producer to publish messages:

            import org.apache.kafka.clients.producer.KafkaProducer;
            import org.apache.kafka.clients.producer.ProducerRecord;
            import java.util.Properties;
            public class ProducerExample {
            public static void main(String[] args) {
                    Properties props = new Properties();
                    props.put("bootstrap.servers", "localhost:9092"); // Kafka broker
                    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
                    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            
                    KafkaProducer<String, String> producer = new KafkaProducer<>(props);
            
                    for (int i = 0; i < 10; i++) {
                        producer.send(new ProducerRecord<>("my-topic", Integer.toString(i), "Message " + i));
                    }
            
                    producer.close();
                }
            }
  4. Kafka Consumer Implementation
     - Set up a Kafka Consumer to consume messages:

            import org.apache.kafka.clients.consumer.ConsumerRecord;
            import org.apache.kafka.clients.consumer.KafkaConsumer;
            import org.apache.kafka.clients.consumer.ConsumerRecords;
            import java.util.Collections;
            import java.util.Properties;
            public class ConsumerExample {
            public static void main(String[] args) {
                    Properties props = new Properties();
                    props.put("bootstrap.servers", "localhost:9092");
                    props.put("group.id", "test-group");
                    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
                    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
       
                    KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
                    consumer.subscribe(Collections.singletonList("my-topic"));
            
                    while (true) {
                        ConsumerRecords<String, String> records = consumer.poll(100);
                        for (ConsumerRecord<String, String> record : records) {
                            System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
                        }
                    }
                }
            }
  5. Kafka with Docker Compose
     - Docker Compose simplifies the setup of multi-container applications. Kafka and ZooKeeper can be managed using Docker Compose.

              version: '2'
              services:
              zookeeper:
              image: wurstmeister/zookeeper:3.4.6
              ports:
              - "2181:2181"
              kafka:
              image: wurstmeister/kafka:2.12-2.3.0
              ports:
                - "9092:9092"
                environment:
                KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
                KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
                volumes:
                - /var/run/docker.sock:/var/run/docker.sock
      - Start the services: `docker-compose up`

  6. Kafka Streams API
     - Kafka Streams provides a client library for building applications that process data in real-time.

             import org.apache.kafka.streams.KafkaStreams;
             import org.apache.kafka.streams.StreamsBuilder;
             import org.apache.kafka.streams.kstream.KStream;
             import org.apache.kafka.streams.StreamsConfig;
            
             import java.util.Properties;
            
             public class KafkaStreamsExample {
             public static void main(String[] args) {
             Properties props = new Properties();
             props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-example");
             props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            
                     StreamsBuilder builder = new StreamsBuilder();
                     KStream<String, String> source = builder.stream("input-topic");
                     source.to("output-topic");
            
                     KafkaStreams streams = new KafkaStreams(builder.build(), props);
                     streams.start();
                 }
             }
  7. Kafka Administration
     - Create a new topic: `bin/kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1`
     - List topics: `bin/kafka-topics.sh --list --bootstrap-server localhost:9092`
  8. Monitoring and Logging
     - Kafka can be monitored using tools like Prometheus, Grafana, and Kafka Manager.
     - Kafka logs are stored in the /logs directory and can be viewed for troubleshooting.
  9. Security
     - Kafka supports various security mechanisms such as SSL for encrypting data, SASL for authentication, and ACLs (Access Control Lists) for authorization.

- For a production setup, fine-tuning Kafka configurations, implementing appropriate partitioning strategies,
  - and optimizing consumer lag handling are crucial. 
    - Let me know if you need deeper insights into any of these areas!
      - Kafka Server config 
  
            Property	                Description	                                                      Default/Example
            broker.id	                Unique identifier for the broker	                                  0
            listeners	                Host and port where Kafka listens for incoming connections	      PLAINTEXT://localhost:9092
            advertised.listeners	    Publicly accessible address for clients to connect	              PLAINTEXT://broker.host:9092
            zookeeper.connect	        ZooKeeper connection string	                                      localhost:2181
            log.dirs	                Directories for storing Kafka log files	                          /var/lib/kafka/logs
            num.partitions	            Default number of partitions per topic	                            1
            log.retention.hours	        Duration to retain log segments before deletion	                    168 (7 days)
            log.retention.bytes	        Maximum size of log data to retain for a topic	                    10737418240 (10 GB)
            log.segment.bytes	        Maximum size of a single log segment file	                        1073741824 (1 GB)
            delete.topic.enable	        Enable deletion of topics	                                        true
            auto.create.topics.enable   Automatically create topics when accessed	                        true
            default.replication.factor	Default replication factor for new topics	                          1
            min.insync.replicas	        Minimum number of replicas required for successful writes	          1
            replica.lag.time.max.ms	    Maximum time a replica can lag behind the leader	                  10000
            offsets.retention.minutes	Retention time for consumer offsets	                                10080 (7 days)
            message.max.bytes	        Maximum message size allowed	                                    1000012 (1 MB)
            inter.broker.listener.name	Listener used for communication between brokers	                    PLAINTEXT
            num.network.threads	        Number of threads for network I/O	                                  3
            num.io.threads	            Number of threads for I/O operations	                              8
            socket.send.buffer.bytes	Socket send buffer size	                                              102400
            socket.receive.buffer.bytes	Socket receive buffer size	                                          102400
            socket.request.max.bytes	Maximum size of a request	                                          104857600 (100 MB)

        - Kafka Producer Configuration

               Property	                  Description	                                                Default/Example
               bootstrap.servers	      List of Kafka brokers to connect to	                        localhost:9092
               key.serializer	          Serializer class for the message key	            org.apache.kafka.common.serialization.StringSerializer
               value.serializer	          Serializer class for the message value	        org.apache.kafka.common.serialization.StringSerializer
               acks	                      Level of acknowledgment for sent messages	                      all (wait for all replicas)
               retries	                  Number of retries for failed message sends	                  2147483647 (infinite retries)
               batch.size	              Number of bytes to batch before sending	                      16384
               linger.ms	              Delay before sending a batch	                                  0 (immediate send)
               buffer.memory	          Total memory used for buffering records	                      33554432 (32 MB)
               compression.type	          Compression type for messages (none, gzip, snappy, etc.)	      none
               max.block.ms	              Maximum time to block waiting for buffer availability	          60000 (1 minute)
               max.in.flight.requests
               .per.connection	          Maximum number of unacknowledged requests sent per connection	    5
               enable.idempotence	      Guarantee exactly-once message delivery	                        false
               client.id	              Logical identifier for the client	                                producer-client-1
               request.timeout.ms	      Time to wait for acknowledgment of send request	                30000 (30 seconds)
               delivery.timeout.ms	      Total time to wait for a message to be acknowledged	            120000 (2 minutes)

          -  Kafka Consumer Configuration
        
                 Property	                  Description	                                               Default/Example
                 bootstrap.servers	          List of Kafka brokers to connect to	                        localhost:9092
                 group.id	                  Consumer group ID for grouping consumers	                    consumer-group-1
                 key.deserializer	          Deserializer class for the message key	                    org.apache.kafka.common.serialization.StringDeserializer
                 value.deserializer	          Deserializer class for the message value	                    org.apache.kafka.common.serialization.StringDeserializer
                 auto.offset.reset	          Behavior when no offset is found (latest, earliest)	        latest
                 enable.auto.commit	          Whether to automatically commit offsets	                    true
                 auto.commit.interval.ms	  Frequency of auto-committing offsets	                        5000 (5 seconds)
                 fetch.min.bytes	          Minimum data size to fetch per request	                    1 (1 byte)
                 fetch.max.wait.ms	          Maximum wait time before receiving data	                    500 (500 ms)
                 max.poll.records	          Maximum number of records returned in a single poll	        500
                 session.timeout.ms	          Timeout for detecting consumer failures	                    10000 (10 seconds)
                 heartbeat.interval.ms	      Interval between heartbeats to the group coordinator	        3000 (3 seconds)
                 max.poll.interval.ms	      Maximum delay between poll calls before consumer 
                                                          is considered failed	                            300000 (5 minutes)
                 client.id	                  Logical identifier for the client	                            consumer-client-1
                 isolation.level	          Read committed/uncommitted data 
                                              (read_committed, read_uncommitted)	                         read_uncommitted
                 partition.assignment
                            .strategy	      Strategy for assigning partitions to consumers	        org.apache.kafka.clients.consumer.RangeAssignor