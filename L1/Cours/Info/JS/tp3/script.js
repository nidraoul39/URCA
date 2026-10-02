const ctx = document.getElementById("myChart");
const backgroundColors = ["rgb(255, 99, 132)", "rgb(54, 162, 235)"];
const borderColors = ["rgb(255, 99, 132)", "rgb(54, 162, 235)"];
/*
new Chart(ctx, {
  type: "bar",
  data: {
    labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
    datasets: [
      {
        label: "# of Votes",
        data: [12, 19, 3, 5, 2, 3],
        borderWidth: 1,
        backgroundColor: backgroundColors,
        borderColor: borderColors,
      },
    ],
  },
  options: {
    scales: {
      y: {
        beginAtZero: true,
      },
    },
  },
});*/
/*
new Chart(ctx, {
  type: "pie",
  data: {
    labels: [
      "Je suis mort",
      "Je suis en train de mourir",
      "Je n'ai pas entendu la sonnerie",
    ],
    datasets: [
      {
        label: "Ce que pense ma mère quand je ne réponds pas au téléphone",
        data: [48, 48, 4],
        borderWidth: 1,
        backgroundColor: backgroundColors,
        borderColor: borderColors,
      },
    ],
  },
  options: {
    plugins: {
      title: {
        display: true,
        text: "Ce que pense ma mère quand je ne réponds pas au téléphone",
        position: "bottom",
        padding: { top: 30, bottom: 10 },
      },
    },
  },
});*/

new Chart(ctx, {
  type: "line",
  data: {
    labels: [
      "2000",
      "2001",
      "2002",
      "2003",
      "2004",
      "2005",
      "2006",
      "2007",
      "2008",
      "2009",
    ],
    datasets: [
      {
        label: ["Consommation de margarine par habitant"],
        data: [8.2, 7, 6.5, 5.3, 5.2, 4, 4.6, 4.5, 4.2, 3.7],
        borderWidth: 1,
        backgroundColor: "rgb(255, 99, 132)",
        borderColor: "rgb(255, 99, 132)",
        yAxisID: "A",
      },
      {
        label: ["taux de divorce dans la maine"],
        data: [5, 4.7, 4.6, 4.4, 4.3, 4.1, 4.2, 4.2, 4.2, 4.1],
        borderWidth: 1,
        backgroundColor: "rgb(54, 162, 235)",
        borderColor: "rgb(54, 162, 235)",
        yAxisID: "B",
      },
    ],
  },
  options: {
    plugins: {
      title: {
        display: true,
        text: "Consommation de margarine comparée au taux de divorce aux États-Unis",
        position: "bottom",
        margin: { top: 30, bottom: 10 },
      },
      subtitle: {
        display: true,
        text: "* en livres de margarine",
      },
    },
    scale: {
      A: {
        position: "left",
      },
      B: {
        position: "right",
      },
    },
  },
});
