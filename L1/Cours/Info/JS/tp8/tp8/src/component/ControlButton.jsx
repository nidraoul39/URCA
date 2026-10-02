import "./ControlButton.css";
function ControlButton({ children, onClickListener, classnom }) {
  return (
    <>
      <button className={classnom} onClick={onClickListener}>
        {children}
      </button>
    </>
  );
}

export default ControlButton;
