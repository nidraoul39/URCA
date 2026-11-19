"""Module de gestion des espaces pédagogiques et sportifs d'un campus."""


class Salle:
    """Représente une salle de cours générique."""

    _dernier_numero = 0

    def __init__(self, nom: str, capacite: int) -> None:
        Salle._dernier_numero += 1
        self.__nom = nom
        self.__numero = self._dernier_numero
        self.__occupants = 0
        self.__capacite = capacite

    @classmethod
    def from_texte(cls, texte: str) -> "Salle":
        """Crée une instance à partir d'une chaîne 'nom;capacite'."""
        nom, cap = texte.split(";")
        return cls(nom.strip(), int(cap.strip()))

    @staticmethod
    def est_rentable(capacite: int) -> bool:
        """Indique si la salle est rentable (au moins 20 places)."""
        return capacite >= 20

    def est_pleine(self) -> bool:
        """Vérifie si la salle a atteint sa capacité maximale."""
        return self.__occupants >= self.__capacite

    def entrer(self, n: int) -> None:
        """Ajoute n personnes si possible, sinon avertit et n'ajoute rien."""
        if self.__occupants + n > self.__capacite:
            print("pas assez de place")
        else:
            self.__occupants += n

    def sortir(self, n: int) -> None:
        """Retire des personnes sans descendre sous zéro."""
        self.__occupants -= n
        if self.__occupants < 0:
            self.__occupants = 0

    def get_nom(self) -> str:
        return self.__nom

    def get_occupants(self) -> int:
        return self.__occupants

    def set_occupants(self, n: int) -> None:
        self.__occupants = n

    def get_capacite(self) -> int:
        return self.__capacite

    def get_numero(self) -> int:
        return self.__numero

    def set_capacite(self, n: int) -> int | None:
        if n <= 0:
            print("erreur pas de nb negatif")
            return 1
        self.__capacite = n
        return None

    def __repr__(self) -> str:
        return (
            f"Salle[{self.__nom}, cap. {self.__capacite}, "
            f"{self.__occupants} pers.]"
        )

    def __eq__(self, s2: object) -> bool:
        if not isinstance(s2, Salle):
            return False
        return self.get_numero() == s2.get_numero()

    def __del__(self) -> None:
        print("la salle a été supprimer")


class Amphi(Salle):
    """Amphithéâtre appliquant une jauge maximale de sécurité à 90 %."""

    def __init__(self, nom: str, capacite: int, micro: bool) -> None:
        super().__init__(nom, capacite)
        self.__micro = micro

    def entrer(self, n: int) -> None:
        limite = int(0.9 * self.get_capacite())
        if self.get_occupants() + n > limite:
            self.set_occupants(limite)
            print("la salle est pleine tous le monde ne rentrera pas")
        else:
            self.set_occupants(self.get_occupants() + n)


class SalleTP(Salle):
    """Salle de TP contrainte par son nombre de postes informatiques."""

    def __init__(self, nom: str, capacite: int, nb_postes: int) -> None:
        super().__init__(nom, capacite)
        self.__nb_postes = nb_postes

    def entrer(self, n: int) -> int | None:
        if self.__nb_postes < self.get_capacite():
            if self.get_occupants() + n > self.__nb_postes:
                self.set_occupants(self.__nb_postes)
                print(
                    "pas assez de postes pr tout le monde "
                    "donc rentrer pas tous "
                )
                return 1
        if self.get_occupants() + n > self.get_capacite():
            self.set_occupants(self.get_capacite())
            print("pas assez de place")
            return 1
        self.set_occupants(self.get_occupants() + n)
        return None


class CourtDeSport:
    """Terrain de sport sans restriction d'effectif (duck typing)."""

    def __init__(self, surface: str) -> None:
        self.surface = surface
        self.joueurs = 0

    def entrer(self, n: int) -> None:
        self.joueurs += n
        print(
            f"[Court de sport - {self.surface}] {n} personnes entrent "
            f"sans aucune restriction (total : {self.joueurs})"
        )


class Batiment:
    """Représente un bâtiment physique."""

    def __init__(self, nom_batiment: str) -> None:
        self.nom_batiment = nom_batiment


class SalleAnnexe(Salle, Batiment):
    """Salle rattachée à un bâtiment via héritage multiple."""

    def __init__(self, nom: str, capacite: int, nom_batiment: str) -> None:
        Salle.__init__(self, nom, capacite)
        Batiment.__init__(self, nom_batiment)


if __name__ == "__main__":
    print(SalleAnnexe.mro())

    campus = [
        Salle("Salle 101", 40),
        Salle("Salle 102", 25),
        Amphi("Amphi Turing", 150, True),
        SalleTP("Salle TP Info", 35, 20),
        CourtDeSport("MMA"),
    ]

    for s in campus:
        s.entrer(30)

    print(campus[0])

    s1 = Salle("D1", 10)
    s2 = Salle("D1", 10)

    print(s1 == s2)
    print(s1 is s2)

    del s1