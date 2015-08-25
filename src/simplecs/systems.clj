(ns simplecs.systems)

; systems builds on the core, rather than being part of it
; it is optional and experimental

; PIPELINES

; a pipeline is:
; a collection of systems,
; with a specified order
; ideally, this should incorporate data-oriented design.
; failing that, liberal use of -> and ->>.

(defn create-pipeline
  "Create a data processing pipeline."
  []
  []) ; uhhhh

; SYSTEMS

; what is a system?
; a system is a function that operates on a game state
; aiming to blahhhhhh.
; okay, i need a better definition of them.