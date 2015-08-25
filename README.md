# simplecs

A simple entity-component system (ECS) library.

# Question

When do you ever have to work with a single component?

Alright, I think i'm starting to get this.

Creating an entity or creating a component is a separate operation from updating a data store.

Therefore, you shouldn't be doing something like `(create-entity data-store)` and expect to get an entity back. That doesn't make sense. Instead, you have two functions: `(create-entity)`, which takes no parameters and returns an entity, and `(add-entity data-store entity)`, which takes two parameters, a data store and an entity, and returns a new data store with

Right now, the pipeline looks like this:

`(create-entity) -> [entity] + [data-store] -> (add-entity) -> [data-store]`

If you need the entity for something later after updating the data store (say, for asserting that the data store was updated with that entity), you can have the entity be a higher-level declaration that can be used later on in the closure.


````
(create-entity) -> [entity] + [data-store] -> (add-entity) -> [data-store]
[entity] v [data-store] -> (check-in-data-store) -> [bool]
```

Or, in actual code:

```
(let [new-entity (create-entity)
      new-data-store (add-entity data-store new-entity)]
  (assert-in new-entity new-data-store))
```

This way, we both make it easier to test and retain a sane output for each function.

## How do I...

### ...Create a new data store?

A data store is a warehouse of sorts for entities and components.

  - Tracks created entities.
  - Tracks created components.
  - Operated upon to query for components.
  - Operated upon to update components.
  - Operated upon for general CRUD operations.

```clojure
; Given that I want to create a new data store,
; When I call `create-data-store`,
(def data-store (create-data-store))
; Then I have a new data store.

```

### ...Create a new entity?

Creating a new entity necessitates creating a data store. Creating a new entity is also an operation upon a data store, i.e. a function. Therefore, it makes sense to create closures in order to work on a data store.

Except that we'll be creating a new function every time we want to change a data store. Hmmmmm.

The functional way to do this is to declare that a data store is immutable, and that all these functions actually *do*. Closures make sense with mutable structures, but they're pretty useless with immutable structures.

Here's the thing - a data store is quite literally just a small data structure. It's also gonna be fed through an update loop. It's not going to last very long, so there's no real advantage to creating a closure over one. There isn't really a dependency hell when you only have one dependency. Having functions explicitly take data stores as part of their whatever makes things a hell of a lot easier. Plus, it enables one function to work on many different data stores, and they're not all particularly special, so there's no reason to make one function for each data store.

So, fuck it. Data store functions operate on data stores in general. Doesn't matter which ones or how.

```clojure
; When I call `create-entity`,
(def entity (create-entity))
; Then a new entity is created.
```

### ...Add an entity to a data store?

`add-entity`, the function for updating a data store, takes two parameters: the entity to add, and the data store to add it to. **`add-entity` returns an updated version of the data store.** Don't expect it to return the entity that was added. This is for ease of composition.

```clojure
; Given that I have a data store,
(def data-store (create-data-store))
; And a new entity,
(def new-entity (create-entity))
; When I call `add-entity`,
; I get an updated version of the data store with the entity added
(def new-data-store (add-entity data-store entity))
```

### ...Delete an entity?

These functions leverage immutable data and operations. They do not change the state of anything they put in, and should create as few local variables/"let"s as possible.

```clojure
(def data-store (create-data-store))
(def new-entity (create-entity))
(def new-data-store (add-entity data-store entity))
(def reverted-data-store (delete-entity data-store entity))
```

### ...Create a new component?

To create a component, you need:

- The component properties, and
- The entity to attach it to

```clojure
(def entity (create-entity))
(def component-properties {:type "vec2d"
                           :x 0
                           :y 0})
(def component (create-component entity component-properties))
(= (:type component) (:type component-properties))
(= (:entity component) entity)
```

### ...Add a component?

```clojure
(def data-store (create-data-store))
(def data-store-with-component (add-component data-store component))
```

### ...Query for components?

Now this is the interesting bit.

I have a data store.

I want to get all the components in it matching these

```clojure
; Given that I have an entity,
(def entity (create-entity data-store))
; And that I have a component for that entity,
(def component-properties {:type "vec2d"})
(def component (create-component data-store entity component-properties))
; And that component has a `:type` property of `"vec2d"`,
(= (:type component) "vec2d")
; When I call `query-components` with `{:type "vec2d"}`,
(def query-results (query-components data-store {:type "vec2d"}))
; Then it returns the initial component.
(= (:type query-results) "vec2d")
```

### ...Update a component?



### ...Delete a component?

### ...Get components of an entity? (advanced)

## License

Copyright © 2015 Rebecca Paz

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
