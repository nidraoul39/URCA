import "./Square.css";

export default function Square({ value, active, onSelectListener }) {
  return (
    <div
      className={active ? "square-selected" : "square"}
      onClick={() => onSelectListener(value)}
    ></div>
  );
}
