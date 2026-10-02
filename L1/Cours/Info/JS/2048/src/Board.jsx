import { useEffect, useState } from 'react';


const [ keyPress, setKeyPress ] = useState(null);
const [displayEnd,setDisplayEnd] = useState(null);


const grille={
    grille:[[0,0,0,0]*4],
    resetgame: function (){
        grille = [[0,0,0,0]*4]
    }
}



function Board(){
    return(
        
    );
}
export default Board;
