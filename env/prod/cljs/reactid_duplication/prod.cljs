(ns reactid-duplication.prod
  (:require [reactid-duplication.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
