function Input({ x, label, name, width, value, type, readonly, autofocus }) {
  return (
    <>
      <label htmlFor={label} name={name} className="col-sm-2 col-form-label">
        {label}
      </label>
      <div className={`col-sm-${width}`}>
        <input
          className={`col-sm-${x} form-control`}
          type={type}
          autoFocus={autofocus}
          readOnly={readonly}
          defaultValue={value}
          name={name}
          required
        />
      </div>
    </>
  );
}
export default Input;
