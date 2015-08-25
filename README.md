# simplecs

A simple entity-component system (ECS) library. There's data stores, entities, and components. Enjoy.

## Rationale

The entity-component system (ECS) architecture makes game development significantly easier by separating behavior from data, in a grand departure from established object-oriented practices. In short, everything that "is" and "does" in a game is specified as an **entity** - a player is an entity, an enemy is an entity, a level boundary is an entity, a camera is an entity. An entity is no more than a UUID. **Components** tie together entities and properties, and hold the actual data of an entity. They're not much more than maps, or associative arrays. **Systems** give entities behavior by modifying their components; for example, a physics system would change the physics components of a certain set of entities. Essentially, the collection of components go through a data pipeline that outputs their collective state after a given period of time.

So far, this library handles entities and components. It doesn't say anything about systems, so it doesn't actually do much. It remains to be seen how opinionated this library is about how systems should be implemented, how advanced entity management should be handled, etc. Therefore, this library will change in the future.

This library was created in order to isolate and provide a simple pluggable implementation of the absolute very basics of an entity component system. (More informally, this library was created so that I don't have to build an ECS architecture from scratch every single time I want to make a game.)

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

## Why is this so barebones?

Changes in game state is ultimately a function of about three different things:

1. The current game state
2. The current input signals
3. The amount of time since the last game state (time delta)

Boiling down game dev to this basic rule means that your data structures and algorithms are relatively simple and require little complexity. All you need is a data structure and a few functions, and you're golden. That's Simplecs - the data structure and functions.

Simplecs is not a game engine. Simplecs is a specification for managing entities and components. It cannot make assumptions about *how* it is going to be used, and therefore, it is just a building block.

## What *should* this library do?

The most complicated things in ECS architectures are:

- How do I get the components I want?
- What order do I run systems in?
- Should components affect other components, and if so, how?

I would love a library or engine that answers these questions for me. I haven't found one that satisfies me, however, and I still don't have the perfect answers to these questions. I'll have to think about what I want this library to do, ultimately.

## License

Copyright © 2015 Rebecca Paz

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
