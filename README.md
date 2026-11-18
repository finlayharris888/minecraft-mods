# Minecraft Fabric Mods

Small Fabric mods for **Minecraft Java 26.3** (Fabric Loader 0.20.1+, Fabric API 0.166.2+26.3, Java 25).

| Folder | Mod | Side |
| --- | --- | --- |
| [`mob-probing`](mob-probing) | **Minecraft Mob Probing**: hostile mobs within 200 blocks hunt the player | Server / singleplayer |
| [`inventory-sorter`](inventory-sorter) | **Inventory Sorter**: Smart Sort button for inventory, chests and barrels | Client only |
| [`big-stacks`](big-stacks) | **Big Stacks**: stackable items stack to 999 instead of 64 | Client and server |
| [`web`](web) | Pickaxe Lab website. Add new mods in `web/mods.js` and put the jar in `web/downloads/` | |

Downloads: see the website, or the jars in [`web/downloads`](web/downloads).

## Building

Each mod is its own Gradle project and needs a Java 25+ JDK.

```bash
cd mob-probing   # or inventory-sorter
./gradlew build
```

The jar appears in `build/libs/`.

## License

MIT. Not an official Minecraft product; not approved by or associated with Mojang or Microsoft.
