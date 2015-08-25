(ns simplecs.core)

(defn create-data-store
  "Create a new data store."
  []
  {:entities []
   :components []})  ; tada! that's it. that's all you get.
