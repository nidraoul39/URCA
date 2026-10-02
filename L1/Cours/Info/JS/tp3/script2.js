const options = {
  oLanguage: {
    sLengthMenu: "Afficher _MENU_ élément(s)",
    sSearch: "Rechercher :",
    sProcessing: "Traitement en cours...",
    sInfo: "Affichage de l'élément _START_ à _END_ sur _TOTAL_ élément(s)",
    sInfoEmpty: "Affichage de l'élément 0 à 0 sur 0 élément(s)",
    sInfoFiltered: "(filtré de _MAX_ élément(s) au total)",
    sInfoPostFix: "",
    sLoadingRecords: "Chargement en cours...",
    sZeroRecords: "Aucun élément à afficher",
    sEmptyTable: "Aucune donnée disponible dans le tableau",
    oPaginate: {
      sFirst: "Premier",
      sPrevious: "Précédent",
      sNext: "Suivant",
      sLast: "Dernier",
    },
    oAria: {
      sSortAscending: ": activer pour trier la colonne par ordre croissant",
      sSortDescending: ": activer pour trier la colonne par ordre décroissant",
    },
  },
  stateSave: true,
};
let table = new DataTable("#myTable", options);
