function Button({ type, css, children }) {
  return (
    <div>
      <button type={type} className={`btn me-1 ${css}`}>
        {children}
      </button>
    </div>
  );
}

export default Button;
