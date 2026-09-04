# AnimalDespawn 0.3.0

Legacy-style passive animal despawning for Paper 1.12.2.

## What it does

This plugin deliberately does **not** implement its own animal spawner. Paper remains responsible for natural animal spawning.

The plugin restores a configurable legacy-style despawn process so that unprotected animals can leave the population and give Paper room to replenish it.

### Presets

`preset: BETA_1_7_3`

Classic Beta-style values:

- more than 128 blocks from the nearest player: immediate removal
- more than 32 blocks away: age accumulates
- after 600 ticks outside 32 blocks: 1/800 random removal check per tick
- within 32 blocks: age resets

`LEGACY_CONSOLE` and `BEDROCK` are provided as named presets and currently use the same 32/128/600/800 despawn model. This keeps the configuration simple while leaving room for version-specific differences to be added later.

`CUSTOM` uses the values under `despawn:`.

## Protection

By default the plugin protects animals after:

- taming
- breeding
- feeding with a valid species food
- being leashed
- being named
- being sheared
- being dyed
- dyeing a tamed wolf's collar
- being a baby

Baby protection is intentional for 1.12.2: ordinary passive-animal babies are player-created through breeding rather than ordinary wild spawning.

## Paper settings

A useful 1.12.2 setup is:

    ticks-per:
      animal-spawns: 1

    spawn-limits:
      animals: 70

`animal-spawns: 1` means Paper attempts animal spawning every tick; it does not guarantee a successful spawn. The plugin therefore leaves spawning to Paper rather than adding another competing spawn system.

## Commands

- `/animaldespawn status`
- `/animaldespawn reload`
- `/animaldespawn scan`
- `/animaldespawn inspect` — toggles operator inspection mode; right-click an animal to see counted/protected/despawn state.

Permission:

`animaldespawn.admin`

## Building

Use the included `build.bat` on the Windows machine with a Java 8 JDK and Maven installed.

The output JAR is:

`target/AnimalDespawn-0.2.0.jar`
