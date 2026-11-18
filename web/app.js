(function () {
  var mods = window.MODS || [];
  var splashes = window.SPLASHES || [];

  function el(tag, cls, text) {
    var e = document.createElement(tag);
    if (cls) e.className = cls;
    if (text != null) e.textContent = text;
    return e;
  }

  // Splash text
  var splash = document.getElementById("splash");
  if (splash && splashes.length) {
    splash.textContent = splashes[Math.floor(Math.random() * splashes.length)];
    splash.addEventListener("click", function () {
      splash.textContent = splashes[Math.floor(Math.random() * splashes.length)];
    });
  }

  // Hotbar: 9 slots, filled with mods, the rest empty
  var hotbar = document.getElementById("hotbar");
  if (hotbar) {
    for (var i = 0; i < 9; i++) {
      var mod = mods[i];
      if (mod) {
        var a = el("a", "slot filled");
        a.href = "#" + mod.id;
        a.title = mod.name;
        a.setAttribute("aria-label", mod.name);
        var img = el("img");
        img.src = mod.icon;
        img.alt = "";
        a.appendChild(img);
        hotbar.appendChild(a);
      } else {
        var s = el("span", "slot");
        s.setAttribute("aria-hidden", "true");
        hotbar.appendChild(s);
      }
    }
  }

  // Mod entries
  var list = document.getElementById("mod-list");
  if (list) {
    mods.forEach(function (mod) {
      var art = el("article", "mod");
      art.id = mod.id;

      var head = el("div", "mod-head");
      var slot = el("div", "slot big");
      var icon = el("img");
      icon.src = mod.icon;
      icon.alt = "";
      slot.appendChild(icon);
      head.appendChild(slot);

      var titles = el("div", "mod-titles");
      titles.appendChild(el("h3", null, mod.name));
      titles.appendChild(el("p", "tagline", mod.tagline));
      head.appendChild(titles);
      art.appendChild(head);

      var facts = el("dl", "facts");
      [["Minecraft", mod.minecraft], ["Runs on", mod.side], ["Version", mod.version], ["Updated", mod.updated]].forEach(function (f) {
        var d = el("div");
        d.appendChild(el("dt", null, f[0]));
        d.appendChild(el("dd", null, f[1]));
        facts.appendChild(d);
      });
      art.appendChild(facts);

      art.appendChild(el("p", "desc", mod.description));

      var ul = el("ul", "features");
      mod.features.forEach(function (f) { ul.appendChild(el("li", null, f)); });
      art.appendChild(ul);

      var actions = el("div", "actions");
      var dl = el("a", "mc-btn primary", "Download " + mod.name);
      dl.href = mod.download;
      dl.setAttribute("download", "");
      actions.appendChild(dl);
      var src = el("a", "mc-btn", "Source code");
      src.href = mod.source;
      actions.appendChild(src);
      art.appendChild(actions);

      list.appendChild(art);
    });

    var count = document.getElementById("mod-count");
    if (count) count.textContent = mods.length + (mods.length === 1 ? " mod" : " mods") + ", " + (9 - mods.length) + " slots free";
  }
})();
