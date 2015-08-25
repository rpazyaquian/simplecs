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

(defn add-entity
  "Add an entity to a data store, and return the new data store."
  [entity data-store]
  (let [new-entities (conj (:entities data-store) entity)]
    (assoc data-store :entities new-entities)))
