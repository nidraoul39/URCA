const shifumi = {
  scoreP: 0,
  scoreC: 0,
  player: -1,
  select: function (type) {
    if (this.player == -1) {
      this.player = type;
      let element = document.querySelectorAll("#player img");
      let selected = document.querySelector("#player_" + this.player);
      element.forEach((item) => {
        item.style.visibility = "hidden";
      });
      selected.style.visibility = "visible";
      element = document.querySelectorAll("#computer img");
      element.forEach((item) => {
        item.style.visibility = "hidden";
      });
      setTimeout(() => {
        shifumi.computer();
      }, 1000);
    }
  },
  computer: function () {
    let r = Math.floor(Math.random() * 3);
    selected = document.querySelector("#computer_" + r);
    selected.style.visibility = "visible";
    if (
      (this.player == 0 && r == 1) ||
      (this.player == 1 && r == 2) ||
      (this.player == 2 && r == 0)
    )
      this.scoreC++;
    else if (this.player != r) this.scoreP++;

    let score = document.getElementById("scoreP");
    score.innerHTML = "Score : " + this.scoreP;
    score = document.getElementById("scoreC");
    score.innerHTML = "Score : " + this.scoreC;
    setTimeout(() => {
      shifumi.reset();
    }, 2000);
  },

  reset: function () {
    let element = document.querySelectorAll("#player img");
    element.forEach((item) => {
      item.style.visibility = "visible";
    });
    element = document.querySelectorAll("#computer img");
    element.forEach((item) => {
      item.style.visibility = "visible";
    });
    this.player = -1;
  },
};

document.getElementById("player_0").addEventListener("click", (f) => {
  shifumi.select(0);
});
document.getElementById("player_1").addEventListener("click", (f) => {
  shifumi.select(1);
});
document.getElementById("player_2").addEventListener("click", (f) => {
  shifumi.select(2);
});
