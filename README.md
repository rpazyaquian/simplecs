# simplecs

A simple entity-component system (ECS) library.

## Rationale

The entity-component system (ECS) architecture makes game development significantly easier by separating behavior from data, in a grand departure from established object-oriented practices. In short, everything that "is" and "does" in a game is specified as an **entity** - a player is an entity, an enemy is an entity, a level boundary is an entity, a camera is an entity. An entity is no more than a UUID. **Components** tie together entities and properties, and hold the actual data of an entity. They're not much more than maps, or associative arrays. **Systems** give entities behavior by modifying their components; for example, a physics system would change the physics components of a certain set of entities. Essentially, the collection of components go through a data pipeline that outputs their collective state after a given period of time.

So far, this library handles entities and components. It doesn't say anything about systems, so it doesn't actually do much. It remains to be seen how opinionated this library is about how systems should be implemented, how advanced entity management should be handled, etc. Therefore, this library will change in the future.

This library was created in order to isolate and provide a simple pluggable implementation of the absolute very basics of an entity component system. There's entities, and there's components. Enjoy.

## How do I...

### ...Create a new data store?

TODO: Add example.

### ...Create a new entity?

TODO: Add example.

### ...Add an entity to a data store?

TODO: Add example.

### ...Delete an entity?

TODO: Add example.

### ...Create a new component?

TODO: Add example.

### ...Add a component?

TODO: Add example.

### ...Delete a component?

TODO: Add example.

### ...Query for components?

TODO: Add example.

### ...Update a component?

TODO: Add example.

## License

Copyright © 2015 Rebecca Paz

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
