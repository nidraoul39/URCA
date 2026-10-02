import "bootstrap-icons/font/bootstrap-icons.css";

function ControlBarButton({ children, active, onSelectListener }) {
  return (
    <button onClick={onSelectListener}>
      {active ? (
        <i className="bi-circle"></i>
      ) : (
        <i className="bi-circle-fill"></i>
      )}
    </button>
  );
}
export default ControlBarButtonl;
