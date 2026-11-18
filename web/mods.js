/*
 * The mod list. To add a new mod:
 *   1. put its jar in web/downloads/
 *   2. add an entry below (newest mods at the top)
 * The page, the hotbar and the download buttons are built from this list.
 */
window.MODS = [
  {
    id: "big-stacks",
    name: "Big Stacks",
    icon: "assets/icon-stack.svg",
    tagline: "Stack up to 999 instead of 64.",
    description:
      "Every item that normally stacks now stacks to 999, in your inventory, chests, barrels, shulker boxes and hoppers. Items that never stack, like tools and armor, stay as they are. Install it on both the client and the server.",
    features: [
      "Stacks of 999 for blocks, food, ores, ender pearls and more",
      "Works in every container, not just your inventory",
      "Big stacks save and load safely, even inside shulker boxes",
      "Pairs well with Inventory Sorter",
    ],
    side: "Client and server",
    version: "1.0.0",
    minecraft: "26.3",
    updated: "2026-11-18",
    download: "downloads/big-stacks-1.0.0.jar",
    source: "https://github.com/finlayharris888/minecraft-mods/tree/main/big-stacks",
  },
  {
    id: "inventory-sorter",
    name: "Inventory Sorter",
    icon: "assets/icon-chest.svg",
    tagline: "One click and your chest is tidy.",
    description:
      "Adds a Sort button to your inventory, chests, barrels, ender chests and shulker boxes. Items are grouped the way the creative menu groups them, so stone ends up next to stone bricks and your tools sit together. It runs only on your side, so it works on any server.",
    features: [
      "Sort button on every chest, barrel and your inventory",
      "Smart order: blocks, tools, combat, food, then everything else",
      "Merges half-empty stacks before sorting",
      "R sorts the container, Shift + R sorts your inventory",
      "Leaves your hotbar, armor and offhand alone",
    ],
    side: "Client only",
    version: "1.0.0",
    minecraft: "26.3",
    updated: "2026-11-18",
    download: "downloads/inventory-sorter-1.0.0.jar",
    source: "https://github.com/finlayharris888/minecraft-mods/tree/main/inventory-sorter",
  },
  {
    id: "mob-probing",
    name: "Mob Probing",
    icon: "assets/icon-zombie.svg",
    tagline: "Every monster within 200 blocks knows where you are.",
    description:
      "Hostile mobs within 200 blocks start walking towards you, and the close ones attack. Nights stop being quiet. Raise Simulation Distance to 13 or more to reach the full range. Install it on the server for multiplayer.",
    features: [
      "Zombies, skeletons, spiders and the rest all head your way",
      "Mobs within 40 blocks lock on and attack",
      "Creative and Spectator players are left alone",
      "Mobs pathfind in short hops, so distance is no excuse",
    ],
    side: "Server and singleplayer",
    version: "1.0.0",
    minecraft: "26.3",
    updated: "2026-11-18",
    download: "downloads/minecraft-mob-probing-1.0.0.jar",
    source: "https://github.com/finlayharris888/minecraft-mods/tree/main/mob-probing",
  },
];

/* Yellow title-screen splashes, picked at random. */
window.SPLASHES = [
  "Now with 200 blocks of trouble!",
  "Sorted!",
  "Fabric powered!",
  "Also try sorting your chest!",
  "Zombies know where you live!",
  "More mods soon!",
  "100% client-side sorting!",
  "Free!",
  "Open source!",
  "Not made by Mojang!",
];
