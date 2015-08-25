(ns simplecs.core)

; DATA STORES

(defn create-data-store
  "Create a new data store."
  []
  {:entities #{}  ; entities should be unique
   :components []})  ; tada! that's it. that's all you get.

; ENTITIES

(defn create-entity
  "Create a new entity - i.e., a UUID."
  []
  (java.util.UUID/randomUUID))  ; nice and simple.

(defn add-entity
  "Add an entity to a data store, and return the new data store."
  [entity data-store]
  (let [new-entities (union (:entities data-store) entity)]
    (assoc data-store :entities new-entities)))

(defn delete-entity
  "Remove an entity from a data store, and return the new data store."
  [entity data-store]
  (let [new-entities (disjoin (:entities data-store) entity)]
    (assoc data-store :entities new-entities)))

; there's no real reason to query the data store for a specific entity.
; the only thing you can use to get such an entity is its UUID - which is the entity itself!

(defn get-all-entities
  "Get all entities in a data store. Might be useful for something...?"
  [data-store]
  (:entities data-store))

; COMPONENTS

(defn create-component
  "Create a component, given an entity and a map of properties."
  [entity properties]
  (assoc properties :entity entity))
