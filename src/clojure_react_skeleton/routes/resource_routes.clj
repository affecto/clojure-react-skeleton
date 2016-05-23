(ns clojure-react-skeleton.routes.resource-routes
  (:require [compojure.api.sweet :refer :all]
            [compojure.route :refer [resources]]
            [ring.util.http-response :refer :all]))

(defroutes resource-routes
  (resources "/"))
