(defproject excriba "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.apache.kafka/kafka-clients "2.1.0"]
                 [org.apache.kafka/kafka-streams "2.1.0"]
                 [io.confluent/kafka-json-serializer "5.1.0"]]
  :repositories [["confluent"  {:url "https://packages.confluent.io/maven/"}]]
  :min-lein-version "2.8.1"
  :main ^:skip-aot excriba.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
