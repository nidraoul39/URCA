
if [ $# -ne 2 ]
then 
    echo "nb de parametre incorrect";
    exit 1;
fi


dateedit1=$(stat -c %Y "$1");
dateedit2=$(stat -c %Y "$2");

if [ $dateedit1 -gt $dateedit2 ];
then
    touch -m $2;
else
    touch -m $1;
fi