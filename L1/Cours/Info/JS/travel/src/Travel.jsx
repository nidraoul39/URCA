import FormRow from "./components/FormRow";
import Input from "./components/Input";
import Button from "./components/Button";
import Form from "./components/Form";
import DateInterval from "./components/DateInterval";

function Travel() {
  return (
    <>
      <h1>Formulaire d'inscription</h1>
      <Form methode="post" url="https://www.cyrilrabat.fr/test.php">
        <FormRow>
          <Input
            x="2"
            type="text"
            label="telephone"
            width="4"
            value="+33666666666"
            name="telephone"
          ></Input>
          <Input
            x="2"
            type="text"
            label="email"
            width="4"
            value="test@test"
            name="email"
            autoFocus
          ></Input>
          <DateInterval
            labels={{ start: "debut", end: "fin" }}
            names={{ start: "debut", end: "fin" }}
          ></DateInterval>
          <Button type="submit" css="btn-primary">
            Valider la réservation
          </Button>
        </FormRow>
      </Form>
    </>
  );
}
export default Travel;
