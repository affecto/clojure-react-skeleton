(ns clojure-react-skeleton.core
  (:gen-class)
  (:require [clojure.tools.logging :refer [info error]]
            [ring.adapter.jetty :as jetty]
            [clojure-react-skeleton.routes.handler :refer [app]])
  (:import [java.lang Runtime Thread]))

(def ^:private app-server (atom nil))

(defn- start-server []
  (info "Starting React test...")
  (reset! app-server (jetty/run-jetty app {:max-threads 100 :port 3399 :join? false}))
  (info "React test started successfully!"))

(defn- stop-server []
  (info "Stopping React test...")
  (.stop @app-server)
  (info "React test stopped successfully!"))

(defn -main []
  (try
    (start-server)
    (.addShutdownHook (Runtime/getRuntime) (Thread. stop-server))
    (catch Exception e
      (do (error "Error happened in main" e) (throw e)))))