import FormRow from "./FormRow";
import { useState } from "react";

function DateInterval({ labels, names }) {
  const [etatdeb, setEtatDeb] = useState();
  const [etatfin, setEtatFin] = useState();

  return (
    <FormRow>
      <div>
        <label htmlFor={labels.start}></label>
        <input
          type="date"
          name={names.start}
          value={etatdeb}
          onChange={setEtatDeb}
        />
        <label htmlFor={labels.end}></label>
        <input
          type="date"
          name={names.end}
          value={etatfin}
          onChange={setEtatFin}
        />
      </div>
    </FormRow>
  );
}
export default DateInterval;
