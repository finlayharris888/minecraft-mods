# Pickaxe Lab: Fabric mods for Minecraft

Small, free Fabric mods for **Minecraft Java Edition 26.3**.

### 🌐 Website and downloads: https://finlayharris888.github.io/minecraft-mods/

[![Website](https://img.shields.io/badge/website-live-5ec188?style=for-the-badge)](https://finlayharris888.github.io/minecraft-mods/)
[![License: MIT](https://img.shields.io/badge/license-MIT-blue?style=for-the-badge)](LICENSE)
![Minecraft 26.3](https://img.shields.io/badge/minecraft-26.3-62b47a?style=for-the-badge)
![Fabric](https://img.shields.io/badge/loader-Fabric-dbd0b4?style=for-the-badge)

## The mods

| Mod | What it does | Runs on | Download |
| --- | --- | --- | --- |
| **[Big Stacks](big-stacks)** | Every item that stacks now stacks to **999** instead of 64, in inventories, chests, barrels and shulker boxes. | Client and server | [big-stacks-1.0.0.jar](web/downloads/big-stacks-1.0.0.jar) |
| **[Inventory Sorter](inventory-sorter)** | A **Sort** button on your inventory, chests, barrels, ender chests and shulker boxes. Items are grouped in creative-menu order. Press `R` to sort a container or `Shift+R` to sort your inventory. | Client only (works on any server) | [inventory-sorter-1.0.0.jar](web/downloads/inventory-sorter-1.0.0.jar) |
| **[Mob Probing](mob-probing)** | Every hostile mob within **200 blocks** starts hunting you. Raise Simulation Distance to 13+ to reach the full range. | Server and singleplayer | [minecraft-mob-probing-1.0.0.jar](web/downloads/minecraft-mob-probing-1.0.0.jar) |

You can also grab every jar from the [website](https://finlayharris888.github.io/minecraft-mods/).

## Install

1. Install [Fabric Loader](https://fabricmc.net/use/installer/) **0.20.1 or newer** for Minecraft **26.3**.
2. Download [Fabric API](https://modrinth.com/mod/fabric-api) for 26.3 and put it in your `mods` folder.
3. Download the mods you want and put the jars in the same `mods` folder.
4. Launch the game with your Fabric profile.

On a multiplayer server, mods marked "Client and server" or "Server" must also be installed on the server. Inventory Sorter is client-only, so it works on any server with nothing installed there.

> These are early releases. If something breaks, please [open an issue](https://github.com/finlayharris888/minecraft-mods/issues) and include your `latest.log`.

## Repository layout

```
minecraft-mods/
├── big-stacks/        Big Stacks mod (Gradle project)
├── inventory-sorter/  Inventory Sorter mod (Gradle project)
├── mob-probing/       Mob Probing mod (Gradle project)
└── web/               The website (plain HTML/CSS/JS) and the downloadable jars
```

Each mod is a standalone Gradle project with its own `gradlew`, so you can build any of them on its own.

## Building from source

You need a **Java 25+** JDK.

```bash
cd big-stacks        # or inventory-sorter, or mob-probing
./gradlew build
```

The mod jar appears in `build/libs/`. Copy it into your `mods` folder to test it.

## Adding a new mod to the website

The site is built from a single list, so new mods need no HTML.

1. Create the mod in its own folder at the top level of this repo.
2. Build it and copy the jar into `web/downloads/`.
3. Add an entry at the top of the list in [`web/mods.js`](web/mods.js) (name, tagline, description, features, download path).
4. Commit and push to `main`. The site redeploys automatically through GitHub Actions.

To preview locally, run `python3 -m http.server` inside the `web` folder and open http://localhost:8000.

## License

[MIT](LICENSE). Not an official Minecraft product. Not approved by or associated with Mojang or Microsoft.
