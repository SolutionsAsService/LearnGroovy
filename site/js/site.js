/* Learn Groovy: stop/start the record, and copy a track's code. */
(function () {
  "use strict";

  var toggle = document.querySelector(".spin-toggle");
  var record = document.querySelector(".record");
  if (toggle && record) {
    toggle.addEventListener("click", function () {
      var paused = record.classList.toggle("paused");
      toggle.setAttribute("aria-pressed", String(paused));
      toggle.textContent = paused ? "Play the record" : "Stop the record";
    });
  }

  document.querySelectorAll("[data-copy]").forEach(function (btn) {
    btn.addEventListener("click", function () {
      var text = document.getElementById(btn.dataset.copy).innerText;
      var done = function () { btn.textContent = "Copied"; setTimeout(function () { btn.textContent = "Copy"; }, 1600); };
      if (navigator.clipboard) navigator.clipboard.writeText(text).then(done, function () { btn.textContent = "Select and copy"; });
      else btn.textContent = "Select and copy";
    });
  });
})();
