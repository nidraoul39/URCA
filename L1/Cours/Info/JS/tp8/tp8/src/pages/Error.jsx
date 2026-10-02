import Menu from "@/component/Menu";
function Error() {
  return (
    <>
      <Menu></Menu>
      <div className="container">
        <h1>Erreur</h1>
        <div class="alert alert-danger" role="alert">
          La page que vous tentez d'atteindre n'existe pas. Ce sont des choses
          qui arrivent...
        </div>
      </div>
    </>
  );
}

export default Error;
