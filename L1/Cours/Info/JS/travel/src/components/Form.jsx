function Form({ methode, url, children }) {
  return (
    <form action={url} method={methode}>
      {children}
    </form>
  );
}

export default Form;
