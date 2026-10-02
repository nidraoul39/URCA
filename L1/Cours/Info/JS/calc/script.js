const calculator = {
  buttons: [
    [7, 8, 9, "+"],
    [4, 5, 6, "-"],
    [1, 2, 3, "x"],
    ["C", 0, "=", "/"],
  ],
  button: function (val) {
    return (
      "<button onclick=\"calculator.insert('" +
      val +
      "')\">" +
      val +
      "</button>"
    );
  },
  create: function (id) {
    for (i = 0; i < 4; i++) {
      for (k = 0; k < 4; k++) {
        document.getElementById(id).innerHTML += this.button(
          this.buttons[i][k],
        );
      }
    }
  },
  insert: function (item) {
    let ecran = document.getElementById("display");
    switch (item) {
      default:
        ecran.innerHTML += item;
    }
  },
};

calculator.create("calculator");
