(ns excriba.core
  (:import (org.apache.kafka.clients.producer ProducerConfig KafkaProducer ProducerRecord)
           (org.apache.kafka.common.serialization StringSerializer)
           (io.confluent.kafka.serializers KafkaJsonSerializer))
  (:gen-class))

(defn- build-producer []
  (let [producer-props {"schema.registry.url"                   "http://localhost:8081"
                        ProducerConfig/BOOTSTRAP_SERVERS_CONFIG "localhost:9092"
                        ProducerConfig/ACKS_CONFIG              "all"
                        ProducerConfig/RETRIES_CONFIG           (int 100)
                        ProducerConfig/BATCH_SIZE_CONFIG        (int 0)}
        serializer     (KafkaJsonSerializer.)]
    (KafkaProducer. producer-props (StringSerializer.) (StringSerializer.))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [producer (build-producer)
        topic    "excriba_news"
        news     "Nome"
        record   (ProducerRecord. topic "name" news)]
    (.send producer record)
    (.close producer)))
