(ns simplecs.core)

(defn create-data-store
  "Create a new data store."
  []
  {:entities []
   :components []})  ; tada! that's it. that's all you get.

(defn create-entity
  "Create a new entity - i.e., a UUID."
  []
  (java.util.UUID/randomUUID))  ; nice and simple.
